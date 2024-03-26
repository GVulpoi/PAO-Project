package Restaurante;

public class RestaurantCuRating extends Restaurant {
    float rating;

    public RestaurantCuRating(float auxRating, Restaurant auxRestaurant) {
        rating = auxRating;
        this.setNume(auxRestaurant.getNume());
        this.setLocalizare(auxRestaurant.getLocalizare());
    }
}
