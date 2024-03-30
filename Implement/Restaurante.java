package Implement;

import Service.RestauranteService;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Restaurante implements RestauranteService {

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

    public Restaurant getRestauranteLoc(Localizare auxLocalizare) {
        for (Restaurant auxRestaurant : restaurante) {
            if(auxRestaurant.getLocalizare().getOras().equals(auxLocalizare.getOras()) && auxRestaurant.getLocalizare().getStrada().equals(auxLocalizare.getStrada()) && auxRestaurant.getLocalizare().getNr() == auxLocalizare.getNr() ) {
                return auxRestaurant;
            }
        }
        return null;
    }

    public void showRestaurant(Restaurant auxRestaurant) {
        System.out.print("1) ");
        System.out.println(auxRestaurant.getNume());
    }

    public List<Restaurant> getRestaurante() {
        return restaurante;
    }

    private void sortRest() {
        restaurante.sort(Comparator.comparing(Restaurant::getNume));
    }
}
