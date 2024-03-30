package Service;

import Implement.Preparat;

import java.util.Set;

public interface MeniuService {
    public void addPreparat(Preparat preparat);

    public Set<Preparat> getPreparate();

    public Preparat getPreparat(int id);

    public void showMeniu();
}
