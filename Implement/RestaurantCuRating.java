package Implement;

import Service.RestaurantCuRatingService;

public class RestaurantCuRating extends Implement.Restaurant implements RestaurantCuRatingService {

    float rating;

    public RestaurantCuRating(float auxRating, Restaurant auxRestaurant) {
        rating = auxRating;
        this.setNume(auxRestaurant.getNume());
        this.setLocalizare(auxRestaurant.getLocalizare());
    }
}
