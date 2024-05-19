package Implement;

import Service.DatabaseService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database implements DatabaseService {
    private static Database single_instance = null;
    private Connection connection;

    private Database (String url, String username, String password) throws SQLException {
        if (username == null) {
            System.out.println("Username-ul introdus pentru baza de date este null!");
            return;
        }
        else {
            if (password == null) {
                System.out.println("Parola intordusa pentru baza de date este null!");
            }
        }

        try {
            connection = DriverManager.getConnection(url, username, password);
        }
        catch (SQLException ex) {
            System.out.println("Conexiunea cu baza de date a esuat!");
        }
    }

    public static synchronized Database getInstance(String url, String username, String password) throws SQLException {
        if(single_instance == null) {
            single_instance = new Database(url, username, password);
        }

        return single_instance;
    }
}
