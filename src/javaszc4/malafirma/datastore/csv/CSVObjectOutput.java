package javaszc4.malafirma.datastore.csv;

import java.io.IOException;
import java.io.ObjectOutput;
import java.util.Base64;
import java.util.Collection;
import javaszc4.malafirma.datastore.DataStore;
import javaszc4.malafirma.datastore.DataTable;
import javaszc4.malafirma.datastore.exceptions.DataStoreUnsupportedObjectException;

/**
 *
 * @author sebastian
 */
final class CSVObjectOutput implements ObjectOutput {

    private final Collection<String> cells;
    private final DataStore store;
    private static final String NULL = "NULL";

    CSVObjectOutput(Collection<String> cells, DataStore store) {
        this.cells = cells;
        this.store = store;
    }

    @Override
    public void writeObject(Object obj) throws IOException {
        if (obj == null) {
            cells.add(NULL);
        } else if (obj instanceof DataTable) {
            long insert = store.insert((DataTable) obj);
            if (insert < 0) {
                throw new IOException();
            }
            cells.add(obj.getClass().getName() + '@' + Long.toHexString(insert));
        } else {
            throw new DataStoreUnsupportedObjectException();
        }
    }

    @Override
    public void write(int b) throws IOException {
        cells.add(Integer.toString(b));
    }

    @Override
    public void write(byte[] b) throws IOException {
        if (b == null) {
            cells.add(NULL);
        } else {
            cells.add(Base64.getEncoder().encodeToString(b));
        }
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        if (b == null) {
            cells.add(NULL);
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
        writeUTF(Character.toString((char) v));
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
            cells.add(NULL);
        } else {
            cells.add('"' + s.replaceAll("\"", "\"\"\"")
                    .replaceAll("\n", "\"\"n")
                    .replaceAll("\r", "\"\"r")
                    .replaceAll("\t", "\"\"t")
                    .replaceAll("\f", "\"\"f")
                    .replaceAll("\b", "\"\"b") + '"');
        }
    }
}
