package javaszc4.malafirma.datastore.exceptions;

public class DataStoreUnsupportedObjectException extends DataStoreException {

    public DataStoreUnsupportedObjectException() {
    }

    public DataStoreUnsupportedObjectException(String message) {
        super(message);
    }

    public DataStoreUnsupportedObjectException(String message, Throwable cause) {
        super(message, cause);
    }

    public DataStoreUnsupportedObjectException(Throwable cause) {
        super(cause);
    }

}
