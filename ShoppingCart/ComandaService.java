package ShoppingCart;

import Meniu.Preparat;

public interface ComandaService {
    void adaugaPreparat(Preparat preparat);
    void eliminaPreparat(Preparat preparat);
    void afiseazaComanda();
}
