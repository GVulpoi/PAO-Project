package Meniu;

public class Ingrediente {
    private String[] nume;

    public Ingrediente() {
    }

    public void setNume(String[] nume) {
        this.nume = nume;
    }

    public String[] getNume() {
        return nume;
    }
    public Ingrediente(String[] auxNume) {
        nume = new String[auxNume.length];
        for(int i = 0; i < auxNume.length; i++) {
            nume[i] = auxNume[i];
        }
    }

    public void addIngredient(String ingredient) {
        String[] auxNume = new String[nume.length + 1];
        for(int i = 0; i < nume.length; i++) {
            auxNume[i] = nume[i];
        }

        auxNume[nume.length] = ingredient;

        nume = new String[auxNume.length];
        for(int i = 0; i < auxNume.length; i++) {
            nume[i] = auxNume[i];
        }
    }

    public void showIngrediente() {
        for (String aux : nume) {
            System.out.print("-");
            System.out.println(aux);
        }
    }
}
