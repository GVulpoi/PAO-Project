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

    public List<Restaurant> cautaRestaurant(String nume) {
        List<Restaurant> auxRestaurante = new ArrayList<>() ;

        for(int i = 0; i < restaurante.size(); i++) {
            if (restaurante.get(i).getNume().toLowerCase().contains(nume.toLowerCase()) || restaurante.get(i).getNume().toLowerCase().equals(nume.toLowerCase())) {
                auxRestaurante.add(restaurante.get(i));
            }
        }

        return auxRestaurante;
    }

    public List<Restaurant> cautaLocatie(String nume) {
        List<Restaurant> auxRestaurante = new ArrayList<>() ;

        for(int i = 0; i < restaurante.size(); i++) {
            if (restaurante.get(i).getLocalizare().getOras().toLowerCase().contains(nume.toLowerCase()) || restaurante.get(i).getLocalizare().getOras().toLowerCase().equals(nume.toLowerCase())) {
                auxRestaurante.add(restaurante.get(i));
            }
        }

        return auxRestaurante;
    }

    private void sortRest() {
        restaurante.sort(Comparator.comparing(Restaurant::getNume));
    }
}
