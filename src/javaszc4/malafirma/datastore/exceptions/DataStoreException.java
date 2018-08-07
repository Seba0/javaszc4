package javaszc4.malafirma.datastore.exceptions;

import java.io.IOException;

/**
 *
 * @author sebastian
 */
public class DataStoreException extends IOException {

    public DataStoreException() {
    }

    public DataStoreException(String message) {
        super(message);
    }

    public DataStoreException(String message, Throwable cause) {
        super(message, cause);
    }

    public DataStoreException(Throwable cause) {
        super(cause);
    }
}
