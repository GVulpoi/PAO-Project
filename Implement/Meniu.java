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


    public void addPreparat(Preparat preparat) {
        preparate.add(preparat);
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

    public void showMeniu() {
        int k = 1;
        for (Preparat preparat : preparate) {
            System.out.print(k + ") ");
            System.out.print(") Nume : ");
            System.out.println(preparat.getNume());
            System.out.println("Ingrediente : ");
            preparat.showIngrediente();
            k += 1;
        }
    }
}
