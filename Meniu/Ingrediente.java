package Meniu;

import java.util.ArrayList;
import java.util.List;

public class Ingrediente {
    private List<String> ingrediente;

    public Ingrediente() {
        ingrediente = new ArrayList<>();
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

    public void addIngredient(String ingredient) {
        ingrediente.add(ingredient);
    }

    public void showIngrediente() {
        for (String aux : ingrediente) {
            System.out.println("-" + aux);
        }
    }
}
