package Database;

import java.sql.*;

public class Database {
    private static Database dbInstance = null;
    public Connection connection;

    private Database() throws SQLException {
        connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/PAO", "postgres", "1234567890");
    }

    public ResultSet execQuery(String querry) throws SQLException {
        Statement st = connection.createStatement();
        ResultSet resultSet = st.executeQuery(querry);
        return resultSet;
    }

    public void execUpdate(String querry) throws SQLException {
        Database db = Database.getInstance();
        PreparedStatement stmt = connection.prepareStatement(querry);
        stmt.executeUpdate();
        stmt.close();
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

        stmt = connection.prepareStatement(
                "CREATE TABLE PREPARATE (" +
                        "id_preparat INTEGER NOT NULL DEFAULT nextval('seq'), " +
                        "nume VARCHAR(50)," +
                        "durata INTEGER," +
                        "PRIMARY KEY (id_preparat));"
        );
        stmt.executeUpdate();

        stmt = connection.prepareStatement("INSERT INTO USERS (username, password, is_admin) VALUES ('admin', '1234567', true), ('adrian', '1234567', false);");
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

        stmt = connection.prepareStatement(
                "CREATE TABLE INGREDIENTE (" +
                        "id_ingredient INTEGER NOT NULL DEFAULT nextval('seq'), " +
                        "nume VARCHAR(50)," +
                        "PRIMARY KEY (id_ingredient));"
        );
        stmt.executeUpdate();

        {

            String[][] ingrediente = {
                    {"cartofi", "ardei", "suc de rosii"},
                    {"carne de pui", "ceapa", "usturoi", "apa"},
                    {"orez", "fasole", "rosii"},
                    {"branza", "salam", "smantana"},
                    {"oua"},
                    {"paste", "sos de rosii", "branza", "busuioc"},
                    {"ton", "salata verde", "masline"},
                    {"piept de pui", "sos teriyaki", "orez", "broccoli"},
                    {"dovlecei", "vinete"},
                    {"carne tocata", "morcov", "mazare"}
            };

            for (String[] ingredientGroup : ingrediente) {
                for (String ingredient : ingredientGroup) {
                    stmt = connection.prepareStatement("INSERT INTO INGREDIENTE (nume) VALUES ('" + ingredient + "');");
                    stmt.executeUpdate();
                }
            }
        }

        {
            String[] statements = {"INSERT INTO PREPARATE (nume, durata) VALUES ('Tocana de Ardei', 130);",
                    "INSERT INTO PREPARATE (nume, durata) VALUES ('Supa de pui', 200);",
                    "INSERT INTO PREPARATE (nume, durata) VALUES ('Chili con carne', 300);",
                    "INSERT INTO PREPARATE (nume, durata) VALUES ('Cartofi gratinati', 250);",
                    "INSERT INTO PREPARATE (nume, durata) VALUES ('Omleta', 180);",
                    "INSERT INTO PREPARATE (nume, durata) VALUES ('Paste cu sos de rosii', 350);",
                    "INSERT INTO PREPARATE (nume, durata) VALUES ('Salata Nicoise', 180);",
                    "INSERT INTO PREPARATE (nume, durata) VALUES ('Pui teriyaki cu orez', 280);",
                    "INSERT INTO PREPARATE (nume, durata) VALUES ('Ratatouille', 220);",
                    "INSERT INTO PREPARATE (nume, durata) VALUES ('Pilaf', 320);"};

            for (String quer : statements) {
                stmt = connection.prepareStatement(quer);
                stmt.executeUpdate();
            }
        }

        {
            stmt = connection.prepareStatement(
                    "CREATE TABLE ELEMENTE_PREPARATE (" +
                            "id_element_preparat INTEGER NOT NULL DEFAULT nextval('seq'), " +
                            "id_preparat INTEGER," +
                            "id_ingredient INTEGER," +
                            "PRIMARY KEY (id_element_preparat)," +
                            "FOREIGN KEY (id_preparat) REFERENCES PREPARATE (id_preparat)," +
                            "FOREIGN KEY (id_ingredient) REFERENCES INGREDIENTE (id_ingredient));"
            );
            stmt.executeUpdate();

            String[][] ingrediente = {
                    {"cartofi", "ardei", "suc de rosii"},
                    {"carne de pui", "ceapa", "usturoi", "apa"},
                    {"orez", "fasole", "ardei", "rosii"},
                    {"cartofi", "branza", "salam", "smantana"},
                    {"oua", "ceapa", "rosii", "ardei"},
                    {"paste", "sos de rosii", "branza", "busuioc"},
                    {"ton", "salata verde", "rosii", "masline"},
                    {"piept de pui", "sos teriyaki", "orez", "broccoli"},
                    {"dovlecei", "vinete", "ardei", "ceapa"},
                    {"carne tocata", "orez", "morcov", "mazare"}
            };

            Statement st = connection.createStatement();
            ResultSet resultSet = st.executeQuery("SELECT * FROM PREPARATE");

            int i = 0;
            while (resultSet.next()) {
                    for(String ingredient : ingrediente[i]) {
                        st = connection.createStatement();
                        ResultSet resultSet2 = st.executeQuery("SELECT id_ingredient FROM INGREDIENTE WHERE nume = '" + ingredient + "';");
                        resultSet2.next();

                        stmt = connection.prepareStatement("INSERT INTO ELEMENTE_PREPARATE (id_preparat, id_ingredient) VALUES (" + resultSet.getString("id_preparat") + ", " + resultSet2.getString("id_ingredient") + ");");
                        stmt.executeUpdate();
                }
                    i++;
            }
        }


        stmt.close();
    }

    public static synchronized Database getInstance() throws SQLException {
        if (dbInstance == null) {
            dbInstance = new Database();
        }

        return dbInstance;
    }

}
