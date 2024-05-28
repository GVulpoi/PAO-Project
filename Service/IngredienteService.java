package Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface IngredienteService {

    public void setIngrediente(List<String> ingrediente);

    public List<String> getIngrediente();

    public void addIngredient(String ingredient) throws SQLException;

    public void deleteIngredient(String nume) throws SQLException;

    public void updateIngredient(String newName, String oldName) throws SQLException;

    public void showIngrediente();
}
