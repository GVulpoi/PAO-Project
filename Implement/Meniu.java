package Implement;

import Database.Database;
import Implement.Preparat;
import Service.MeniuService;

import javax.xml.crypto.Data;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class Meniu implements MeniuService {
    private String nume;
    private Set<Preparat> preparate;

    public Meniu(String nume) throws SQLException {
        preparate = new HashSet<>();

        Database database = Database.getInstance();
        ResultSet idMeniu =  database.execQuery("SELECT id_meniu FROM MENIURI WHERE nume = '" + nume + "';");

        if (idMeniu.next()){
            ResultSet idPreparate = database.execQuery("SELECT id_preparat FROM ELEMENTE_MENIURI WHERE id_meniu = " + idMeniu.getInt("id_meniu") + ";" );
            while (idPreparate.next()) {
                ResultSet preparat = database.execQuery("SELECT * FROM PREPARATE WHERE id_preparat = " + idPreparate.getInt("id_preparat") + ";");
                if (preparat.next()) {
                    preparate.add(new Preparat(preparat.getString("nume"), preparat.getInt("durata")));
                }
            }
        }

    }

    public void addPreparat(Preparat preparat) throws SQLException {
        preparate.add(preparat);

        Database database = Database.getInstance();
        ResultSet rsIdMeniu = database.execQuery("SELECT id_meniu FROM MENIURI WHERE nume = '" + nume.toLowerCase() + "');");
        ResultSet rsIdPreparat = database.execQuery("SELECT id_preparat FROM PREPARATE WHERE nume ='" + preparat.getNume().toLowerCase() + "');");

        if(rsIdPreparat.next()) {
            database.execUpdate("INSERT INTO TABLE ELEMENTE_MENIURI VALUES (id_meniu) VALUES (" + rsIdMeniu.getString("rsIdMeniu") + ", " + rsIdPreparat.getString("id_preparat") + ");");
        }
        else {
            database.execUpdate("INSERT INTO TABLE PREPARATE (nume) VALUES ('" + preparat.getNume().toLowerCase() + "');");
            ResultSet rsIdPreparat1 = database.execQuery("SELECT id_preparat FROM PREPARATE WHERE nume ='" + preparat.getNume().toLowerCase() + "');");
            rsIdPreparat1.next();

            for(String ingredient : preparat.getIngrediente()) {
                database.execUpdate("INSERT INTO TABLE ELEMENTE_PREPARATE (id_preparat, id_ingredient) VALUES (" + rsIdPreparat1.getString("id_preparat") + ", " + rsIdMeniu.getString("id_meniu")+ ");");
            }
        }
    }

    public void deletePreparat(Preparat preparat) throws SQLException {
        Database database = Database.getInstance();
        ResultSet rsIdPreparat = database.execQuery("SELECT id_preparat FROM PREPARATE WHERE nume ='" + preparat.getNume().toLowerCase() + "');");

        if(rsIdPreparat.next()) {
            ResultSet ingredientePreparat = database.execQuery("SELECT id_element_preparat FROM ELEMENTE_PREPARATE WHERE id_preparat = " + rsIdPreparat.getInt("id_preparat") + " ;" );
            database.execUpdate("DELETE FROM PREPARATE WHERE id_preparat = " + rsIdPreparat.getInt("id_preparat") + " ;");
            while (ingredientePreparat.next()) {
                database.execUpdate("DELETE FROM ELEMENTE_PREPARATE WHERE id_element_preparat = " + ingredientePreparat.getInt("id_element_preparat" + " ;"));
            }
        }
    }

    public Set<Preparat> getPreparate() {
        return preparate;
    }

    public Preparat getPreparat(int id) {
        int k = 1;
        for (Preparat preparat : preparate) {
            if (id == k) {
                return preparat;
            }
            k += 1;
        }

        return null;
    }

    public void showMeniu() throws SQLException {
        int k = 1;
        for (Preparat preparat : preparate) {
            System.out.print( k + ") Nume : ");
            preparat.showPreparat();
            k++;
        }
    }
}
