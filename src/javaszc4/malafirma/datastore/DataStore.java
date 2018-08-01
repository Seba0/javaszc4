package javaszc4.malafirma.datastore;

import java.io.IOException;

public interface DataStore extends AutoCloseable {

    void open(String name);

    boolean isOpen();

    <T extends DataTable> long insert(T object) throws IOException;

    <T extends DataTable> int insert(Iterable<T> objects);

    <T extends DataTable> T update(T object);

    <T extends DataTable> T select(Class<T> type, long id);

    <T extends DataTable> Iterable<T> query(Class<T> type, DataFilter<T> filter);

    <T extends DataTable> boolean delete(T object);

    <T extends DataTable> int delete(Iterable<T> objects);

    <T extends DataTable> T delete(Class<T> type, long id);
}
