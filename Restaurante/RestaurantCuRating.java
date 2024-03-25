package Restaurante;

public class RestaurantCuRating extends Restaurant {
    float rating;

    public RestaurantCuRating(float auxRating, Restaurant auxRestaurant) {
        rating = auxRating;
        this.nume = auxRestaurant.getNume();
        this.localizare = auxRestaurant.getLocalizare();
    }
}
