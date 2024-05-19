package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {
    private static Database dbInstance = null;
    public Connection connection;

    private Database() throws SQLException {
        connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/PAO", "postgres", "1234567890");
    }

    public void initialization() {
        if (connection == null) {
            System.out.println("Nu s-a putut efectua initializarea bazei de date!");
            return ;
        }

        //Statement inserare = connection.prepareStatement("");
    }

    public static synchronized Database getInstance() throws SQLException {
        if (dbInstance == null) {
            dbInstance = new Database();
        }

        return dbInstance;
    }

}
