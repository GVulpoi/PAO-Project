package Service;

import Implement.Localizare;
import Implement.Meniu;

public interface RestaurantService {

    public Localizare getLocalizare();

    public String getNume();

    public Meniu getMeniu();

    public void setLocalizare(Localizare localizare);

    public void setNume(String nume);

    public void setMeniu(Meniu meniu);
}
