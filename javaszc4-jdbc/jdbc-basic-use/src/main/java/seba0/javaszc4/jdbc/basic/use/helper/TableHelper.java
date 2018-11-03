package seba0.javaszc4.jdbc.basic.use.helper;

import java.io.Closeable;
import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class TableHelper implements Closeable {
    private final Connection connection;

    private final Map<Class<?>, String> types;

    public TableHelper(Connection connection) throws IOException {
        this.connection = Objects.requireNonNull(connection);
        this.types = initTypesMap(connection);
    }

    private Map<Class<?>, String> initTypesMap(Connection connection) throws IOException {
        try {
            Map<Integer, String> jdbcTypeNames = getJdbcTypeNames();
            DatabaseMetaData metaData = connection.getMetaData();
            try (ResultSet rs = metaData.getTypeInfo()) {
                while (rs.next()) {
                    String typeName = rs.getString("TYPE_NAME");
                    int dataType = rs.getInt("DATA_TYPE");
                    String type = jdbcTypeNames.get(dataType);
                    System.out.println(typeName + " : " + type);
                }
            }
            return null;
        } catch (SQLException e) {
            throw new IOException(e);
        }
    }

    public static Map<Integer, String> getJdbcTypeNames() {
        Map<Integer, String> map = new HashMap<>();

        // Get all field in java.sql.Types
        for (Field field : Types.class.getFields()) {
            try {
                String name = field.getName();
                Integer value = (Integer) field.get(null);
                map.put(value, name);
            } catch (IllegalAccessException e) {
            }
        }
        return map;
    }

    public boolean create(Serializable object) throws IOException {
        Objects.requireNonNull(object);
        Class<? extends Serializable> aClass = object.getClass();
        String name = aClass.getSimpleName();
        if (!aClass.isAnnotationPresent(Table.class)) {
            throw new IOException(name + " is not Table");
        }
        StringBuilder query = new StringBuilder("create table `")
                .append(name).append("`(");
        for (Field f : aClass.getDeclaredFields()) {
            query.append('`').append(f.getName()).append("` ");
        }

        query.append(')');
        try (Statement statement = connection.createStatement()) {
            return statement.execute(query.toString());
        } catch (SQLException e) {
            throw new IOException(e);
        }
    }

    public void read(Serializable object) {

    }

    @Override
    public void close() throws IOException {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new IOException(e);
        }
    }
}
