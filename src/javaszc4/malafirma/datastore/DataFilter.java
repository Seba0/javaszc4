package javaszc4.malafirma.datastore;

public interface DataFilter<T extends DataTable> {

    boolean accept(T object);

    default int limit() {
        return Integer.MAX_VALUE;
    }
}
