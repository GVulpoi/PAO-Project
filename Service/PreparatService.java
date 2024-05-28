package Service;

import java.sql.SQLException;

public interface PreparatService extends IngredienteService {
    public void deletePreparat(String nume) throws SQLException;
    public void showPreparat() throws SQLException;
    public String getNume();
}
