package Implement;

import Database.Database;
import Service.PreparatService;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class Preparat extends Ingrediente implements PreparatService {
    private String nume;
    private int durata;

    public Preparat(String auxNume, int auxDurata) throws SQLException {
        nume = auxNume;
        durata = auxDurata;

        Database database = Database.getInstance();
        ResultSet ingrediente = database.execQuery("SELECT id_ingredient FROM ELEMENTE_PREPARATE WHERE id_preparat = (SELECT id_preparat FROM PREPARATE WHERE nume = '" + auxNume + "' );");

        while (ingrediente.next()) {
            ResultSet numeIngredient = database.execQuery("SELECT nume FROM INGREDIENTE WHERE id_ingredient = " + ingrediente.getInt("id_ingredient") + ";");
            if (numeIngredient.next()) {
                this.addIngredient(numeIngredient.getString("nume"));
            }
        }
    }

    public String getNume() {
        return nume;
    }

    public void deletePreparat(String nume) throws SQLException {
        Database database = Database.getInstance();
        ResultSet idPreparat = database.execQuery("SELECT id_preparat FROM PREPARATE WHERE nume = '" + nume + "';");

        if(idPreparat.next()) {
            database.execUpdate("DELETE FROM PREPARATE WHERE id_preparat = " + idPreparat.getInt("id_preparat") + ";");
        }

        ResultSet idElemPrep = database.execQuery("SELECT id_element_preparat, id_preparat FROM ELEMENTE_PREPARATE WHERE id_preparat = " + idPreparat.getInt("idPreparat") + ";");
        while (idElemPrep.next()) {
            database.execUpdate("DELETE FROM ELEMENTE_PREPARATE WHERE id_element_preparat = " + idElemPrep.getInt("id_element_preparat") + " ;");
        }
    }

    public void showPreparat() throws SQLException {
        System.out.println(nume);

        Database database = Database.getInstance();
        ResultSet idPreparat = database.execQuery("SELECT id_preparat FROM PREPARATE WHERE nume = '" + nume + "';");
        idPreparat.next();

        ResultSet ingrediente = database.execQuery("SELECT id_ingredient FROM ELEMENTE_PREPARATE WHERE id_preparat = " + idPreparat.getInt("id_preparat") + ";");
        while (ingrediente.next()) {
            ResultSet numeIngredient = database.execQuery("SELECT nume FROM INGREDIENTE WHERE id_ingredient = " + ingrediente.getInt("id_ingredient") + " ;");
            numeIngredient.next();
            System.out.println('-' + numeIngredient.getString("nume"));
        }
    }
}
