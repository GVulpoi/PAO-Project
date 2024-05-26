package Implement;

import Database.Database;
import Service.PreparatService;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

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

    public void showPreparat() throws SQLException {
        Database database = Database.getInstance();
        ResultSet idPreparat = database.execQuery("SELECT id_preparat FROM PREPARATE WHERE nume = '" + nume + "';");
        idPreparat.next();

        ResultSet ingrediente = database.execQuery("SELECT nume FROM ELEMENTE_PREPARATE WHERE id_preparat = " + idPreparat.getInt("id_preparat") + ";");
        while (ingrediente.next()) {
            System.out.println('-' + ingrediente.getString("nume"));
        }

    }
}
