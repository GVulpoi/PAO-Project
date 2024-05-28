package Service;

import Implement.Preparat;

import java.sql.SQLException;
import java.util.Set;

public interface MeniuService {
    public void addPreparat(Preparat preparat) throws SQLException;

    public Set<Preparat> getPreparate();

    public Preparat getPreparat(int id);

    public void showMeniu() throws SQLException;
}
