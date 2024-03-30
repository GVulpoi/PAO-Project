package Service;

import java.util.ArrayList;
import java.util.List;

public interface IngredienteService {

    public void setIngrediente(List<String> ingrediente);

    public List<String> getIngrediente();

    public void addIngredient(String ingredient);

    public void showIngrediente();
}
