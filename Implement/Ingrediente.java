package Implement;

import Database.Database;
import Service.IngredienteService;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Ingrediente implements IngredienteService {
    private List<String> ingrediente;


    public Ingrediente() throws SQLException {
        ingrediente = new ArrayList<>();

        Database database = Database.getInstance();
        ResultSet rsIngrediente = database.execQuery("SELECT nume FROM INGREDIENTE;");

        while(rsIngrediente.next()) {
            String nume = rsIngrediente.getString("nume").toLowerCase();
            ingrediente.add(nume);
        }
    }

    public Ingrediente(String[] auxingrediente) {
        ingrediente = new ArrayList<>();
        for (String num : auxingrediente) {
            ingrediente.add(num);
        }
    }

    public void setIngrediente(List<String> ingrediente) {
        this.ingrediente = ingrediente;
    }

    public List<String> getIngrediente() {
        return ingrediente;
    }

    public void addIngredient(String ingredient) throws SQLException {
        ingrediente.add(ingredient.toLowerCase());
        Database database = Database.getInstance();
        database.execUpdate("INSERT INTO INGREDIENTE (nume) VALUES ('" + ingredient.toLowerCase() + "');");
    }

    public void updateIngredient(String newName, String oldName) throws SQLException {
        if(ingrediente.contains(oldName.toLowerCase())) {
            for(int i = 0; i < ingrediente.size(); i++) {
                if (ingrediente.get(i).equals(oldName.toLowerCase())) {
                    ingrediente.remove(i);
                    Database database = Database.getInstance();
                    database.execUpdate("DELETE FROM INGREDIENTE WHERE nume = '" + oldName.toLowerCase() + "';");

                    ingrediente.add(newName);
                    database.execUpdate("INSERT INTO INGREDIENTE (nume) VALUES ('" + newName.toLowerCase() + "');");
                }
            }
        }
        else {
            System.out.println("Ingredientul nu a putut fi gasit!");
        }
    }

    public void deleteIngredient(String nume) throws SQLException {
        if(ingrediente.contains(nume.toLowerCase())) {
            for(int i = 0; i < ingrediente.size(); i++) {
                if (ingrediente.get(i).equals(nume.toLowerCase())) {
                    ingrediente.remove(i);
                    Database database = Database.getInstance();
                    database.execUpdate("DELETE FROM INGREDIENTE WHERE nume = '" + nume.toLowerCase() + "';");
                }
            }
        }
        else {
            System.out.println("Ingredientul nu a putut fi gasit!");
        }
    }

    public void showIngrediente() {
        for (String aux : ingrediente) {
            System.out.println("-" + aux);
        }
    }
}
