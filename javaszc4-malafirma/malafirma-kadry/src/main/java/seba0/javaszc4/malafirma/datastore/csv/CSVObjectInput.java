package seba0.javaszc4.malafirma.datastore.csv;

import seba0.javaszc4.malafirma.datastore.DataStore;
import seba0.javaszc4.malafirma.datastore.DataTable;
import seba0.javaszc4.malafirma.datastore.exceptions.DataStoreCorruptedException;

import java.io.IOException;
import java.io.ObjectInput;
import java.util.Base64;

/**
 * @author sebastian
 */
final class CSVObjectInput implements ObjectInput {

    private String row;
    private final DataStore store;
    private static final String NULL = "NULL";
    private static final String BASE64 = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/=";

    CSVObjectInput(String row, DataStore store) {
        this.row = row;
        this.store = store;
    }

    @Override
    public Object readObject() throws IOException {
        row = row.trim();
        if (row.isEmpty()) {
            throw new DataStoreCorruptedException(row);
        } else if (!Character.isLetter(row.charAt(0)) && row.charAt(0) != '_') {
            throw new DataStoreCorruptedException(row);
        }
        int fieldEnd = row.indexOf(',');
        String value;
        if (fieldEnd < 0) {
            fieldEnd = row.length();
            value = row;
        } else {
            value = row.substring(0, fieldEnd);
        }
        if (NULL.equalsIgnoreCase(value)) {
            return null;
        }
        int classEnd = value.indexOf('@');
        if (classEnd < 0) {
            throw new DataStoreCorruptedException(row);
        }
        String className = value.substring(0, classEnd);
        String idClass = value.substring(classEnd + 1);
        try {
            long id = Long.parseUnsignedLong(idClass, 16);
            Class<? extends DataTable> aClass = (Class<? extends DataTable>) Class.forName(className);
            return store.select(aClass, id);
        } catch (NumberFormatException | ClassNotFoundException | IOException ex) {
            throw new DataStoreCorruptedException(row, ex);
        } finally {
            fieldEnd++;
            if (row.length() > fieldEnd) {
                row = row.substring(fieldEnd);
            } else {
                row = "";
            }
        }
    }

    @Override
    public int read() throws IOException {
        return readInt();
    }

    @Override
    public int read(byte[] b) throws IOException {
        return read(b, 0, b.length);
    }

    @Override
    public int read(byte[] b, int off, int len) throws IOException {
        row = row.trim();
        if (row.isEmpty()) {
            throw new DataStoreCorruptedException(row);
        } else if (BASE64.indexOf(row.charAt(0)) < 0) {
            throw new DataStoreCorruptedException(row);
        }
        int fieldEnd = row.indexOf(',');
        String value = row.substring(0, fieldEnd);
        if (NULL.equalsIgnoreCase(value)) {
            return 0;
        }
        byte[] decode = Base64.getDecoder().decode(value);
        int size = Math.min(decode.length, off + Math.min(len, b.length)) - off;
        System.arraycopy(decode, off, b, 0, size);
        row = row.substring(fieldEnd + 1);
        return size;
    }

    @Override
    public long skip(long n) throws IOException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int available() throws IOException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void close() throws IOException {
    }

    @Override
    public void readFully(byte[] b) throws IOException {
        if (read(b) != b.length) {
            throw new DataStoreCorruptedException(row);
        }
    }

    @Override
    public void readFully(byte[] b, int off, int len) throws IOException {
        if (read(b, off, len) != len) {
            throw new DataStoreCorruptedException(row);
        }
    }

    @Override
    public int skipBytes(int n) throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean readBoolean() throws IOException {
        row = row.trim();
        if (row.isEmpty()) {
            throw new DataStoreCorruptedException(row);
        } else if (!Character.isLetter(row.charAt(0))) {
            throw new DataStoreCorruptedException(row);
        }
        int fieldEnd = row.indexOf(',');
        if (fieldEnd < 0) {
            throw new DataStoreCorruptedException(row);
        }
        String value = row.substring(0, fieldEnd);
        try {
            return Boolean.parseBoolean(value);
        } finally {
            row = row.substring(fieldEnd + 1);
        }
    }

    @Override
    public byte readByte() throws IOException {
        row = row.trim();
        if (row.isEmpty()) {
            throw new DataStoreCorruptedException(row);
        } else if (!Character.isDigit(row.charAt(0)) && row.charAt(0) != '-') {
            throw new DataStoreCorruptedException(row);
        }
        int fieldEnd = row.indexOf(',');
        if (fieldEnd < 0) {
            throw new DataStoreCorruptedException(row);
        }
        String value = row.substring(0, fieldEnd);
        try {
            return Byte.parseByte(value);
        } catch (NumberFormatException e) {
            throw new DataStoreCorruptedException(row, e);
        } finally {
            row = row.substring(fieldEnd + 1);
        }
    }

    @Override
    public int readUnsignedByte() throws IOException {
        row = row.trim();
        if (row.isEmpty()) {
            throw new DataStoreCorruptedException(row);
        } else if (row.charAt(0) == '-' || !Character.isDigit(row.charAt(0))) {
            throw new DataStoreCorruptedException(row);
        }
        int fieldEnd = row.indexOf(',');
        if (fieldEnd < 0) {
            throw new DataStoreCorruptedException(row);
        }
        String value = row.substring(0, fieldEnd);
        try {
            return Short.parseShort(value);
        } catch (NumberFormatException e) {
            throw new DataStoreCorruptedException(row, e);
        } finally {
            row = row.substring(fieldEnd + 1);
        }
    }

    @Override
    public short readShort() throws IOException {
        row = row.trim();
        if (row.isEmpty()) {
            throw new DataStoreCorruptedException(row);
        } else if (!Character.isDigit(row.charAt(0)) && row.charAt(0) != '-') {
            throw new DataStoreCorruptedException(row);
        }
        int fieldEnd = row.indexOf(',');
        if (fieldEnd < 0) {
            throw new DataStoreCorruptedException(row);
        }
        String value = row.substring(0, fieldEnd);
        try {
            return Short.parseShort(value);
        } catch (NumberFormatException e) {
            throw new DataStoreCorruptedException(row, e);
        } finally {
            row = row.substring(fieldEnd + 1);
        }
    }

    @Override
    public int readUnsignedShort() throws IOException {
        row = row.trim();
        if (row.isEmpty()) {
            throw new DataStoreCorruptedException(row);
        } else if (row.charAt(0) == '-' || !Character.isDigit(row.charAt(0))) {
            throw new DataStoreCorruptedException(row);
        }
        int fieldEnd = row.indexOf(',');
        if (fieldEnd < 0) {
            throw new DataStoreCorruptedException(row);
        }
        String value = row.substring(0, fieldEnd);
        try {
            return Integer.parseUnsignedInt(value);
        } catch (NumberFormatException e) {
            throw new DataStoreCorruptedException(row, e);
        } finally {
            row = row.substring(fieldEnd + 1);
        }
    }

    @Override
    public char readChar() throws IOException {
        row = row.trim();
        if (row.isEmpty()) {
            throw new DataStoreCorruptedException(row);
        } else if (row.charAt(0) != '"') {
            throw new DataStoreCorruptedException(row);
        }
        String value = readUTF();
        if (value.length() != 1) {
            throw new DataStoreCorruptedException(row);
        }
        return value.charAt(0);
    }

    @Override
    public int readInt() throws IOException {
        row = row.trim();
        if (row.isEmpty()) {
            throw new DataStoreCorruptedException(row);
        } else if (!Character.isDigit(row.charAt(0)) && row.charAt(0) != '-') {
            throw new DataStoreCorruptedException(row);
        }
        int fieldEnd = row.indexOf(',');
        if (fieldEnd < 0) {
            throw new DataStoreCorruptedException(row);
        }
        String value = row.substring(0, fieldEnd);
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new DataStoreCorruptedException(row, e);
        } finally {
            row = row.substring(fieldEnd + 1);
        }
    }

    @Override
    public long readLong() throws IOException {
        row = row.trim();
        if (row.isEmpty()) {
            throw new DataStoreCorruptedException(row);
        } else if (!Character.isDigit(row.charAt(0)) && row.charAt(0) != '-') {
            throw new DataStoreCorruptedException(row);
        }
        int fieldEnd = row.indexOf(',');
        if (fieldEnd < 0) {
            throw new DataStoreCorruptedException(row);
        }
        String value = row.substring(0, fieldEnd);
        try {
            return Long.parseLong(value);
        } catch (NumberFormatException e) {
            throw new DataStoreCorruptedException(row, e);
        } finally {
            row = row.substring(fieldEnd + 1);
        }
    }

    @Override
    public float readFloat() throws IOException {
        row = row.trim();
        if (row.isEmpty()) {
            throw new DataStoreCorruptedException(row);
        } else if (!Character.isDigit(row.charAt(0)) && row.charAt(0) != '-') {
            throw new DataStoreCorruptedException(row);
        }
        int fieldEnd = row.indexOf(',');
        if (fieldEnd < 0) {
            throw new DataStoreCorruptedException(row);
        }
        String value = row.substring(0, fieldEnd);
        try {
            return Float.parseFloat(value);
        } catch (NumberFormatException e) {
            throw new DataStoreCorruptedException(row, e);
        } finally {
            row = row.substring(fieldEnd + 1);
        }
    }

    @Override
    public double readDouble() throws IOException {
        row = row.trim();
        if (row.isEmpty()) {
            throw new DataStoreCorruptedException(row);
        } else if (!Character.isDigit(row.charAt(0)) && row.charAt(0) != '-') {
            throw new DataStoreCorruptedException(row);
        }
        int fieldEnd = row.indexOf(',');
        if (fieldEnd < 0) {
            throw new DataStoreCorruptedException(row);
        }
        String value = row.substring(0, fieldEnd);
        try {
            return Double.parseDouble(value);
        } catch (NumberFormatException e) {
            throw new DataStoreCorruptedException(row, e);
        } finally {
            row = row.substring(fieldEnd + 1);
        }
    }

    @Override
    public String readLine() throws IOException {
        return readUTF();
    }

    @Override
    public String readUTF() throws IOException {
        row = row.trim();
        if (row.isEmpty()) {
            throw new DataStoreCorruptedException(row);
        } else if (row.startsWith(NULL)) {
            row = row.substring(row.indexOf(',') + 1);
            return null;
        } else if (row.charAt(0) != '"') {
            throw new DataStoreCorruptedException(row);
        }
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (int i = 1; i < row.length(); i++) {
            char c = row.charAt(i);
            if (count > 0) {
                if (count == 2) {
                    count = 0;
                    switch (c) {
                        case '"':
                            sb.append('"');
                            break;
                        case 'n':
                            sb.append('\n');
                            break;
                        case 'r':
                            sb.append('\r');
                            break;
                        case 't':
                            sb.append('\t');
                            break;
                        case 'f':
                            sb.append('\f');
                            break;
                        case 'b':
                            sb.append('\b');
                            break;
                        default:
                            throw new DataStoreCorruptedException(row);
                    }
                } else if (count == 1) {
                    if (c == '"') {
                        count++;
                    } else if (c == ',') {
                        row = row.substring(i + 1);
                        return sb.toString();
                    } else if (!Character.isWhitespace(c)) {
                        throw new DataStoreCorruptedException(row);
                    }
                }
            } else if (c == '"') {
                count++;
                if (i + 1 == row.length()) {
                    row = row.substring(i + 1);
                    return sb.toString();
                }
            } else {
                sb.append(c);
            }
        }
        throw new DataStoreCorruptedException(row);
    }

}
