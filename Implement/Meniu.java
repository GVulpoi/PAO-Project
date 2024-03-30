package Implement;

import Implement.Preparat;
import Service.MeniuService;

import java.util.HashSet;
import java.util.Set;

public class Meniu implements MeniuService {
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
            System.out.print(k);
            System.out.print(") Nume : ");
            System.out.println(preparat.getNume());
            System.out.println("Ingrediente : ");
            preparat.showIngrediente();
            k += 1;
        }
    }
}
