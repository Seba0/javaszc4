package javaszc4.malafirma.datastore.csv;

import javaszc4.malafirma.datastore.DataFilter;
import javaszc4.malafirma.datastore.DataStore;
import javaszc4.malafirma.datastore.DataTable;

import java.io.*;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

public class CSVDataStore implements DataStore {

    private File path;

    @Override
    public void open(String name) {
        path = Paths.get(System.getProperty("user.home"), ".csvdatastore", name).toFile();
        path.mkdirs();
    }

    @Override
    public boolean isOpen() {
        return path != null && path.isDirectory();
    }

    @Override
    public <T extends DataTable> long insert(T object) throws IOException {
        String name = object.getClass().getName();
        if (name.isEmpty()) {
            return -1;
        }
        File f = new File(path, name + ".csv");
        List<String> cells = new ArrayList<>();
        object.writeExternal(new ObjectOutput() {
            @Override
            public void writeObject(Object obj) throws IOException {
                if (obj == null) {
                    cells.add(null);
                } else if (obj instanceof DataTable) {
                    long insert = insert((DataTable) obj);
                    if (insert < 0) {
                        throw new IOException();
                    }
                    cells.add(obj.getClass().getName() + '@' + Long.toHexString(insert));
                } else {
                    writeUTF(obj.toString());
                }
            }

            @Override
            public void write(int b) throws IOException {
                cells.add(Integer.toString(b));
            }

            @Override
            public void write(byte[] b) throws IOException {
                if (b == null) {
                    cells.add(null);
                } else {
                    cells.add(Base64.getEncoder().encodeToString(b));
                }
            }

            @Override
            public void write(byte[] b, int off, int len) throws IOException {
                if (b == null) {
                    cells.add(null);
                } else {
                    byte[] buffor = new byte[len];
                    System.arraycopy(b, off, buffor, 0, len);
                    write(buffor);
                }
            }

            @Override
            public void flush() throws IOException {
            }

            @Override
            public void close() throws IOException {
            }

            @Override
            public void writeBoolean(boolean v) throws IOException {
                cells.add(Boolean.toString(v));
            }

            @Override
            public void writeByte(int v) throws IOException {
                cells.add(Integer.toString(v));
            }

            @Override
            public void writeShort(int v) throws IOException {
                cells.add(Integer.toString(v));
            }

            @Override
            public void writeChar(int v) throws IOException {
                cells.add(Integer.toString(v));
            }

            @Override
            public void writeInt(int v) throws IOException {
                cells.add(Integer.toString(v));
            }

            @Override
            public void writeLong(long v) throws IOException {
                cells.add(Long.toString(v));
            }

            @Override
            public void writeFloat(float v) throws IOException {
                cells.add(Float.toString(v));
            }

            @Override
            public void writeDouble(double v) throws IOException {
                cells.add(Double.toString(v));
            }

            @Override
            public void writeBytes(String s) throws IOException {
                writeUTF(s);
            }

            @Override
            public void writeChars(String s) throws IOException {
                writeUTF(s);
            }

            @Override
            public void writeUTF(String s) throws IOException {
                if (s == null) {
                    cells.add(null);
                } else {
                    cells.add('"' + s.replaceAll("\"", "\"\"\"") + '"');
                }
            }
        });
        try (Writer w = new FileWriter(f)) {
            w.append(Long.toString(object.getId()));
            for (String cell : cells) {
                w.append(',').append(cell == null ? "NULL" : cell);
            }
            w.append('\n').flush();
        }

    }

    @Override
    public <T extends DataTable> int insert(Iterable<T> objects) {
        return 0;
    }

    @Override
    public <T extends DataTable> T update(T object) {
        return null;
    }

    @Override
    public <T extends DataTable> T select(Class<T> type, long id) {
        return null;
    }

    @Override
    public <T extends DataTable> Iterable<T> query(Class<T> type, DataFilter<T> filter) {
        return null;
    }

    @Override
    public <T extends DataTable> boolean delete(T object) {
        return false;
    }

    @Override
    public <T extends DataTable> int delete(Iterable<T> objects) {
        return 0;
    }

    @Override
    public <T extends DataTable> T delete(Class<T> type, long id) {
        return null;
    }

    @Override
    public void close() throws Exception {
        path = null;
    }
}
