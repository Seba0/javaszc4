package javaszc4.malafirma.datastore.exceptions;

/**
 *
 * @author sebastian
 */
public class DataStoreCorruptedException extends DataStoreException {

    public DataStoreCorruptedException() {
    }

    public DataStoreCorruptedException(String message) {
        super(message);
    }

    public DataStoreCorruptedException(String message, Throwable cause) {
        super(message, cause);
    }

    public DataStoreCorruptedException(Throwable cause) {
        super(cause);
    }
    
}
