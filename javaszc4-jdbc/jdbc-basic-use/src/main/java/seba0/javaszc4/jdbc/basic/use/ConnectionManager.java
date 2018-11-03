package seba0.javaszc4.jdbc.basic.use;

import java.net.PasswordAuthentication;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;

public enum ConnectionManager {
    INSTANCE;

    private Connection connection;
    private PasswordAuthentication authenticator;

    public void setAuthenticator(PasswordAuthentication authenticator) {
        this.authenticator = Objects.requireNonNull(authenticator);
    }

    public Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            if (authenticator == null) {
                throw new SecurityException("Authenticator is required");
            }
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/library",
                    authenticator.getUserName(),
                    new String(authenticator.getPassword()));
        }
        return connection;
    }

    public void createTables() throws SQLException {
        try (Statement statement = getConnection().createStatement()) {
            createAuthorTable(statement);
            createBookTable(statement);
        }
    }

    private boolean createAuthorTable(Statement statement) throws SQLException {
        return statement.execute("create table author(" +
                "`id` int unsigned auto_increment not null primary key," +
                "`first_name` varchar(35) not null," +
                "`last_name` varchar(35) not null)");
    }

    private boolean createBookTable(Statement statement) throws SQLException {
        return statement.execute("create table book(" +
                "`id` int unsigned auto_increment not null primary key," +
                "`title` varchar(128) not null," +
                "`author_id` int unsigned not null," +
                "`release` date not null," +
                "foreign key (`author_id`) references author(id))");
    }

    public boolean dropTables(String... tableName) throws SQLException {
        try (Statement statement = getConnection().createStatement()) {
            for (String name : tableName) {
                try {
                    dropTable(statement, name);
                } catch (SQLException e) {

                }
            }
        }
        return true;
    }

    public boolean dropTable(String tableName) throws SQLException {
        try (Statement statement = getConnection().createStatement()) {
            return dropTable(statement, tableName);
        }
    }

    private boolean dropTable(Statement statement, String tablesName) throws SQLException {
        return statement.execute("drop table " + tablesName);
    }
}
