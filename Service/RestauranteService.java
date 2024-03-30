package Service;

import Implement.Localizare;

import java.util.List;

public interface RestauranteService {
    public void addRestaurant(Implement.Restaurant auxRestaurant);
    public void addRestaurant(Implement.RestaurantCuRating auxRestaurant);

    public void showRestaurante();

    public Implement.Restaurant getRestauranteLoc(Localizare auxLocalizare);

    public void showRestaurant(Implement.Restaurant auxRestaurant);

    public List<Implement.Restaurant> getRestaurante();
}
