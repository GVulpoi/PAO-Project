package Database;

import java.sql.*;

public class Database {
    private static Database dbInstance = null;
    public Connection connection;

    private Database() throws SQLException {
        connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/PAO", "postgres", "1234567890");
    }

    public void initialization() throws SQLException {
        if (connection == null) {
            System.out.println("Nu s-a putut efectua initializarea bazei de date!");
            return ;
        }

        PreparedStatement stmt = connection.prepareStatement("CREATE SEQUENCE seq START WITH 1 INCREMENT BY 1 NO MINVALUE NO MAXVALUE CACHE 1;");
        stmt.executeUpdate();

        stmt = connection.prepareStatement(
                "CREATE TABLE USERS (" +
                        "id_user INTEGER NOT NULL DEFAULT nextval('seq'), " +
                        "username VARCHAR(50), " +
                        "password VARCHAR(50), " +
                        "is_admin BOOLEAN, " +
                        "PRIMARY KEY (id_user));"
        );
        stmt.executeUpdate();

        stmt = connection.prepareStatement("INSERT INTO USERS (username, password, is_admin) VALUES ('admin', '1234567', true), ('adrian', '1234567', false);");
        stmt.executeUpdate();

        stmt = connection.prepareStatement(
                "CREATE TABLE PREPARATE (" +
                        "id_preparat INTEGER NOT NULL DEFAULT nextval('seq'), " +
                        "nume VARCHAR(50), " +
                        "PRIMARY KEY (id_preparat));"
        );
        stmt.executeUpdate();

        stmt = connection.prepareStatement(
                "CREATE TABLE COMENZI (" +
                        "id_comanda INTEGER NOT NULL DEFAULT nextval('seq'), " +
                        "PRIMARY KEY (id_comanda));"
        );
        stmt.executeUpdate();

        stmt = connection.prepareStatement(
                "CREATE TABLE ELEMENTE_COMANDA (" +
                        "id_element INTEGER NOT NULL DEFAULT nextval('seq'), " +
                        "id_comanda INTEGER, " +
                        "id_preparat INTEGER, " +
                        "PRIMARY KEY (id_element), " +
                        "FOREIGN KEY (id_comanda) REFERENCES COMENZI (id_comanda), " +
                        "FOREIGN KEY (id_preparat) REFERENCES PREPARATE (id_preparat));"
        );
        stmt.executeUpdate();
        stmt.close();
    }

    public static synchronized Database getInstance() throws SQLException {
        if (dbInstance == null) {
            dbInstance = new Database();
        }

        return dbInstance;
    }

}
