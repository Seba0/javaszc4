package javaszc4.malafirma.datastore;

import java.io.IOException;
import java.util.Collection;

public interface DataStore extends AutoCloseable {


    void open(String name) throws IOException;

    boolean isOpen();

    <T extends DataTable> long getNextId(Class<T> type) throws IOException;

    <T extends DataTable> long insert(T object) throws IOException;

    <T extends DataTable> int insert(Class<T> type, Iterable<T> objects) throws IOException;

    <T extends DataTable> T update(T object) throws IOException;

    <T extends DataTable> T select(Class<T> type, long id) throws IOException;

    <T extends DataTable> Collection<T> select(Class<? extends DataTable> type, DataFilter<T> filter) throws IOException;

    <T extends DataTable> boolean delete(T object) throws IOException;

    <T extends DataTable> int delete(Iterable<T> objects) throws IOException;

    <T extends DataTable> T delete(Class<T> type, long id) throws IOException;
}
