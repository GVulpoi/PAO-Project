package Meniu;

public class Preparat extends Ingrediente{
    private String nume;
    private int durata;

    public Preparat(String[] auxIngrediente, String auxNume, int auxDurata) {
        for(String aux : auxIngrediente) {
            this.addIngredient(aux);
        }
        nume = auxNume;
        durata = auxDurata;
    }
}
