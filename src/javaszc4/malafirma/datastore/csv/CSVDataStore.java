package javaszc4.malafirma.datastore.csv;

import javaszc4.malafirma.datastore.DataFilter;
import javaszc4.malafirma.datastore.DataStore;
import javaszc4.malafirma.datastore.DataTable;
import javaszc4.malafirma.datastore.exceptions.DataStoreCorruptedException;
import javaszc4.malafirma.datastore.exceptions.DataStoreException;

import java.io.*;
import java.lang.reflect.Field;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CSVDataStore implements DataStore {

    private static final Field FIELD_ID = getField("id");

    private static Field getField(String name) {
        try {
            Field field = DataTable.class.getDeclaredField(name);
            field.setAccessible(true);
            return field;
        } catch (NoSuchFieldException | SecurityException ex) {
            Logger.getLogger(DataTable.class.getName()).log(Level.SEVERE, name, ex);
        }
        return null;
    }

    private File path;

    @Override
    public synchronized void open(String name) {
        path = Paths.get(System.getProperty("user.home"), ".csvdatastore", name).toFile();
        path.mkdirs();
    }

    @Override
    public synchronized boolean isOpen() {
        return path != null && path.isDirectory();
    }

    private <T extends DataTable> File getFile(Class<T> type) {
        String name = type.getName();
        if (name.isEmpty()) {
            return null;
        }
        return new File(path, name + ".csv");
    }

    private File getTmpFile() throws IOException {
        File tmp = File.createTempFile("~", ".tmp", path);
        tmp.deleteOnExit();
        return tmp;
    }

    @Override
    public synchronized <T extends DataTable> long getNextId(Class<T> type) throws IOException {
        File f = getFile(type);
        return getNextId(f);
    }

    private synchronized <T extends DataTable> long getNextId(File f) throws IOException {
        if (f == null) {
            return -1;
        } else if (!f.exists()) {
            return 1;
        }
        long id = -1;
        try (BufferedReader r = new BufferedReader(new FileReader(f))) {
            String buffer;
            while ((buffer = r.readLine()) != null) {
                buffer = buffer.substring(0, buffer.indexOf(','));
                long rowId = Long.parseUnsignedLong(buffer);
                if (rowId > id) {
                    id = rowId;
                }
            }
        }
        return id + 1;
    }

    @Override
    public synchronized <T extends DataTable> long insert(T object) throws IOException {
        File f = getFile(object.getClass());
        if (f == null) {
            return -1;
        }

        List<String> cells = new ArrayList<>();

        object.writeExternal(new CSVObjectOutput(cells, this));

        long nextId = getNextId(f);

        try (Writer w = new FileWriter(f)) {
            w.append(Long.toString(nextId));
            for (String cell : cells) {
                w.append(',').append(cell == null ? "NULL" : cell);
            }
            w.append('\n').flush();
        }
        try {
            FIELD_ID.setLong(object, nextId);
        } catch (IllegalArgumentException | IllegalAccessException ex) {
            throw new DataStoreCorruptedException(ex);
        }
        return nextId;
    }

    private static void writeRow(long id, Iterable<String> row, Writer w) throws IOException {
        w.append(Long.toString(id));
        for (String cell : row) {
            w.append(',').append(cell == null ? "NULL" : cell);
        }
        w.append('\n').flush();
    }

    @Override
    public synchronized <T extends DataTable> int insert(Class<T> type, Iterable<T> objects) throws IOException {
        File f = getFile(type);
        if (f == null) {
            return -1;
        }

        long nextId = getNextId(f);
        int count = 0;

        File tmp = getTmpFile();
        try (Writer w = new FileWriter(tmp)) {

            List<String> cells = new ArrayList<>();
            CSVObjectOutput csvObjectOutput = new CSVObjectOutput(cells, this);

            for (T object : objects) {
                object.writeExternal(csvObjectOutput);
                writeRow(nextId, cells, w);
                cells.clear();
                FIELD_ID.setLong(object, nextId++);
                count++;
            }
        } catch (IllegalArgumentException | IllegalAccessException ex) {
            throw new DataStoreCorruptedException(ex);
        }
        if (f.exists()) {
            try (InputStream in = new FileInputStream(tmp);
                    OutputStream w = new FileOutputStream(f, true)) {
                int size;
                byte[] buffor = new byte[1024];
                while ((size = in.read(buffor)) > 0) {
                    w.write(buffor, 0, size);
                }
            }
            tmp.delete();
        } else {
            tmp.renameTo(f);
        }
        return count;
    }

    @Override
    public synchronized <T extends DataTable> T update(T object) throws IOException {
        Class<? extends DataTable> aClass = object.getClass();
        File f = getFile(aClass);
        if (f == null) {
            throw new DataStoreException();
        }
        File tmp = getTmpFile();
        T oldObject = null;
        try (BufferedReader r = new BufferedReader(new FileReader(f));
                Writer w = new FileWriter(tmp)) {
            String row;
            boolean write = true;
            while ((row = r.readLine()) != null) {
                row = row.trim();
                int indexOf = row.indexOf(',');
                String strId = row.substring(0, indexOf);
                long rowId = Long.parseUnsignedLong(strId);
                if (rowId == object.getId()) {
                    if (write) {
                        oldObject = (T) aClass.newInstance();
                        oldObject.readExternal(new CSVObjectInput(row.substring(indexOf + 1).trim(), this));

                        List<String> cells = new ArrayList<>();
                        object.writeExternal(new CSVObjectOutput(cells, this));
                        writeRow(object.getId(), cells, w);
                        write = false;
                    }
                } else {
                    w.append(row).append('\n');
                }
            }
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException ex) {
            Logger.getLogger(CSVDataStore.class.getName()).log(Level.SEVERE, null, ex);
        }
        tmp.renameTo(f);
        return oldObject;
    }

    @Override
    public synchronized <T extends DataTable> T select(Class<T> type, long id) throws IOException {
        File f = getFile(type);
        if (f == null) {
            throw new DataStoreException();
        }
        try (BufferedReader r = new BufferedReader(new FileReader(f))) {
            String row;
            while ((row = r.readLine()) != null) {
                row = row.trim();
                int indexOf = row.indexOf(',');
                String strId = row.substring(0, indexOf);
                long rowId = Long.parseUnsignedLong(strId);
                if (rowId == id) {
                    T object = (T) type.newInstance();
                    FIELD_ID.setLong(object, id);
                    object.readExternal(new CSVObjectInput(row.substring(indexOf + 1).trim(), this));
                    return object;
                }
            }
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException ex) {
            throw new DataStoreCorruptedException(ex);
        }
        return null;
    }

    @Override
    public synchronized <T extends DataTable> Collection<T> select(Class<? extends DataTable> type, DataFilter<T> filter) throws IOException {
        File f = getFile(type);
        if (f == null) {
            throw new DataStoreException();
        }
        try (BufferedReader r = new BufferedReader(new FileReader(f))) {
            int count = 0;
            String row;
            List<T> objects = new ArrayList<>();
            while ((row = r.readLine()) != null) {
                row = row.trim();
                int indexOf = row.indexOf(',');
                String strId = row.substring(0, indexOf);
                long rowId = Long.parseUnsignedLong(strId);
                T object = (T) type.newInstance();
                FIELD_ID.setLong(object, rowId);
                object.readExternal(new CSVObjectInput(row.substring(indexOf + 1).trim(), this));
                if (filter == null) {
                    objects.add(object);
                } else if (filter.accept(object)) {
                    objects.add(object);
                    if (++count >= filter.limit()) {
                        break;
                    }
                }
            }
            return objects;
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException ex) {
            throw new DataStoreCorruptedException(ex);
        }
    }

    @Override
    public synchronized <T extends DataTable> boolean delete(T object) throws IOException {
        long id = object.getId();
        Class<? extends DataTable> aClass = object.getClass();
        return delete(aClass, id) != null;
    }

    @Override
    public synchronized <T extends DataTable> int delete(Iterable<T> objects) throws IOException {
        File f = null;
        List<Long> ids = new ArrayList<>();
        for (T object : objects) {
            if (f == null) {
                f = getFile(object.getClass());
                if (f == null) {
                    throw new DataStoreException();
                }
            }
            long id = object.getId();
            if (!ids.contains(id)) {
                ids.add(id);
            }
        }
        int count = 0;
        File tmp = getTmpFile();
        try (BufferedReader r = new BufferedReader(new FileReader(f));
                Writer w = new FileWriter(tmp)) {
            String row;
            while ((row = r.readLine()) != null) {
                row = row.trim();
                int indexOf = row.indexOf(',');
                String strId = row.substring(0, indexOf);
                long rowId = Long.parseUnsignedLong(strId);
                if (ids.contains(rowId)) {
                    count++;
                } else {
                    w.append(row).append('\n');
                }
            }
        }
        tmp.renameTo(f);
        return count;
    }

    @Override
    public synchronized <T extends DataTable> T delete(Class<T> type, long id) throws IOException {
        File f = getFile(type);
        if (f == null) {
            throw new DataStoreException();
        }
        File tmp = getTmpFile();
        T object = null;
        try (BufferedReader r = new BufferedReader(new FileReader(f));
                Writer w = new FileWriter(tmp)) {
            String row;
            boolean write = true;
            while ((row = r.readLine()) != null) {
                row = row.trim();
                int indexOf = row.indexOf(',');
                String strId = row.substring(0, indexOf);
                long rowId = Long.parseUnsignedLong(strId);
                if (rowId == id) {
                    if (write) {
                        object = (T) type.newInstance();
                        FIELD_ID.setLong(object, rowId);
                        object.readExternal(new CSVObjectInput(row.substring(indexOf + 1).trim(), this));
                        write = false;
                    }
                } else {
                    w.append(row).append('\n');
                }
            }
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException ex) {
            Logger.getLogger(CSVDataStore.class.getName()).log(Level.SEVERE, null, ex);
        }
        tmp.renameTo(f);
        return object;
    }

    @Override
    public synchronized void close() throws Exception {
        path = null;
    }
}
