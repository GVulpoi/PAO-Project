package Implement;

import java.util.HashSet;
import java.util.Set;
import Implement.Preparat;
import Service.ComandaService;

public class ComandaImpl implements ComandaService {
    private Set<Preparat> comanda;

    public ComandaImpl() {
        comanda = new HashSet<>();
    }

    public void adaugaPreparat(Preparat preparat) {
        comanda.add(preparat);
    }

    public void eliminaPreparat(Preparat preparat) {
        comanda.remove(preparat);
    }

    public void afiseazaComanda() {
        System.out.println("Preparatele din comanda:");
        for (Preparat preparat : comanda) {
            System.out.print("-");
            System.out.println(preparat.getNume());
        }
    }
}
