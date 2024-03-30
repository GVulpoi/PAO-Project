package Implement;

import Service.PreparatService;

public class Preparat extends Ingrediente implements PreparatService {
    private String nume;
    private int durata;

    public Preparat(String[] auxIngrediente, String auxNume, int auxDurata) {
        for(String aux : auxIngrediente) {
            this.addIngredient(aux);
        }
        nume = auxNume;
        durata = auxDurata;
    }

    public String getNume() {
        return nume;
    }
}
