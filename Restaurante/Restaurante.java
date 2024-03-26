package Restaurante;

import Localizare.Localizare;

import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;

public class Restaurante {
    private List<Restaurant> restaurante;

    public Restaurante(){
        restaurante = new ArrayList<>();
    }

    public Restaurante(List<Restaurant> auxRestaurante) {
        for(Restaurant auxRestaurant : auxRestaurante) {
            restaurante.add(auxRestaurant);
        }

        sortRest();
    }

    public void addRestaurant(Restaurant auxRestaurant) {
        restaurante.add(auxRestaurant);
        sortRest();
    }

    public void addRestaurant(RestaurantCuRating auxRestaurant) {
        restaurante.add((Restaurant) auxRestaurant);
    }

    public void showRestaurante() {
        int k = 1;
        for(Restaurant auxRestaurant : restaurante) {
            System.out.print(k);
            System.out.print(") ");
            System.out.println(auxRestaurant.getNume());
            k += 1;
        }
    }

    public void showRestauranteLoc(Localizare auxLocalizare) {
        int k = 1;
        for (Restaurant auxRestaurant : restaurante) {
            ////
        }
    }

    public List<Restaurant> getRestaurante() {
        return restaurante;
    }

    private void sortRest() {
        restaurante.sort(Comparator.comparing(Restaurant::getNume));
    }
}
