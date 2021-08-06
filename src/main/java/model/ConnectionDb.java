package model;

import java.sql.*;

public class ConnectionDb {
    private static ConnectionDb instanceConnect;
    private static final String USER_NAME = "postgres";
    private static final String USER_PASSWORD = "root";
    private static final String URL = "jdbc:postgresql://localhost:5432/Zoo";
    private Connection connection;
    private Statement statement;

    private ConnectionDb() {}

    public static ConnectionDb getInstanceConnect() {
        if(instanceConnect == null) {
            instanceConnect = new ConnectionDb();
        }
        return instanceConnect;
    }

    public Connection getConnection() {
        try {

            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(URL, USER_NAME, USER_PASSWORD);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return connection;
    }


}
