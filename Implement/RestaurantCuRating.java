package Implement;

import Service.RestaurantCuRatingService;

public class RestaurantCuRating extends Implement.Restaurant implements RestaurantCuRatingService {

    double rating;

    public RestaurantCuRating(double auxRating, Restaurant auxRestaurant) {
        rating = auxRating;
        this.setNume(auxRestaurant.getNume());
        this.setLocalizare(auxRestaurant.getLocalizare());
        this.setMeniu(auxRestaurant.getMeniu());
    }

    public RestaurantCuRating(Restaurant auxRestaurant) {
        rating = 0;
        this.setNume(auxRestaurant.getNume());
        this.setLocalizare(auxRestaurant.getLocalizare());
        this.setMeniu(auxRestaurant.getMeniu());
    }
}
