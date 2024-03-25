package Meniu;

import java.util.HashSet;
import java.util.Set;
import java.util.List;

public class Meniu {
    private Set<Preparat> preparate;

    public Meniu() {
        preparate = new HashSet<>();
    }

    public Meniu(Set<Preparat> auxPreparate) {
        preparate = new HashSet<>();

        for(Preparat aux : auxPreparate) {
            preparate.add(aux);
        }
    }

    public void addPreparat(Preparat preparat) {
        preparate.add(preparat);
    }

    public void showMeniu() {
        int k = 1;
        for (Preparat preparat : preparate) {
            System.out.print(k);
            System.out.print(") Nume : ");
            System.out.println(preparat.getNume());
            System.out.print("Ingrediente : ");
        }
    }
}
