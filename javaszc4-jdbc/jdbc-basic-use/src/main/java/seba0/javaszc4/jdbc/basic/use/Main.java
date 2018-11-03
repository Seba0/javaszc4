package seba0.javaszc4.jdbc.basic.use;

import seba0.javaszc4.jdbc.basic.use.helper.TableHelper;

import java.net.PasswordAuthentication;
import java.sql.Connection;

public class Main {

    private static final ConnectionManager MANAGER = ConnectionManager.INSTANCE;

    public static void main(String[] args) {

        MANAGER.setAuthenticator(new PasswordAuthentication("Seba_0", "1234".toCharArray()));

        try (Connection connection = MANAGER.getConnection()) {
            TableHelper helper = new TableHelper(connection);
            helper.create(new Book());
//            System.out.println("Connected to database");
//            MANAGER.dropTables("book", "author");
//            MANAGER.createTables();
//            System.out.println("Created table Book");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
