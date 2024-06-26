import Implement.*;
import Database.Database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws InterruptedException, SQLException {
        Database database = Database.getInstance();
        //database.initialization();

        Users users = new Users();

        List<Localizare> localizari = new ArrayList<>();
        localizari.add(new Localizare("Bucuresti", "Herastrau park", 28));
        localizari.add(new Localizare("Targoviste", "Centrul vechi", 17));
        localizari.add(new Localizare("Bucuresti", "Calea floreasca", 111));
        localizari.add(new Localizare("Bucuresti", "Calea floreasca", 111));

        List<RestaurantCuRating> restauranteCuRating = new ArrayList<>();
        RestaurantCuRating tavRac = new RestaurantCuRating(5, new Restaurant("Taverna Racilor", new Localizare("Bucuresti", "Herastrau park", 28), new Meniu("meniu1")));
        RestaurantCuRating story = new RestaurantCuRating(4.3, new Restaurant("Story Wine and Music", new Localizare("Targoviste", "Centrul vechi", 17), new Meniu("meniu2")));
        RestaurantCuRating vacamuuu = new RestaurantCuRating(4.9, new Restaurant("Vacamuuu", new Localizare("Bucuresti", "Calea floreasca", 111), new Meniu("meniu3")));
        RestaurantCuRating pescLuiMatei = new RestaurantCuRating(3.9, new Restaurant("Pescaria Lui Matei", new Localizare("Constanta", "Strada meduzei", 13), new Meniu("meniu4")));

        restauranteCuRating.add(tavRac);


        Restaurante restaurante = new Restaurante();
        restaurante.addRestaurant(tavRac);
        restaurante.addRestaurant(story);
        restaurante.addRestaurant(vacamuuu);
        restaurante.addRestaurant(pescLuiMatei);

        part1(users, restaurante, localizari, restauranteCuRating);
    }

    public static void part1(Users users, Restaurante restaurante, List<Localizare> localizari, List<RestaurantCuRating> restauranteCuRating) throws InterruptedException, SQLException {
        System.out.println("1. Creare user");
        System.out.println("2. Login");
        System.out.println("3. Creare user admin");
        System.out.println("e. Exit");

        Scanner scanner = new Scanner(System.in);
        String option = scanner.nextLine();

        if(option.equals("1")) {
            part11(users, restaurante, localizari, restauranteCuRating);
        }
        else{
            if(option.equals("2")) {
                part12(users, restaurante, localizari, restauranteCuRating);
            }
            else {
                if(option.equals("3")) {
                    part13(users, restaurante, localizari, restauranteCuRating);
                }
                else {
                    if(option.equals("e")) {
                        System.exit(1);
                    }
                    else {
                        System.out.println(System.lineSeparator().repeat(50));
                        System.out.println("Wrong input!");
                        part1(users, restaurante, localizari, restauranteCuRating);
                    }
                }
            }
        }
    }

    public static void part11(Users users, Restaurante restaurante, List<Localizare> localizari, List<RestaurantCuRating> restauranteCuRating) throws InterruptedException, SQLException {
        if(!users.register()) {
            part1(users, restaurante, localizari, restauranteCuRating);
        }

        part1(users, restaurante, localizari, restauranteCuRating);
    }

    public static void part12(Users users, Restaurante restaurante, List<Localizare> localizari, List<RestaurantCuRating> restauranteCuRating) throws InterruptedException, SQLException {
        UserWithRole user = users.login();

        if(user == null) {
            part1(users, restaurante, localizari, restauranteCuRating);
        }

        if(user.isAdmin()) {
            System.out.println("A");
            part2A(users, restaurante, localizari, restauranteCuRating);
        }
        else {
            System.out.println("B");
            part2(users, restaurante, localizari, restauranteCuRating);
        }
    }

    public static void part13(Users users, Restaurante restaurante, List<Localizare> localizari, List<RestaurantCuRating> restauranteCuRating) throws InterruptedException, SQLException {
        if(!users.registerAsAdmin()) {
            part1(users, restaurante, localizari, restauranteCuRating);
        }

        part1(users, restaurante, localizari, restauranteCuRating);
    }


    public static void part2A(Users users, Restaurante restaurante, List<Localizare> localizari, List<RestaurantCuRating> restauranteCuRating) throws InterruptedException, SQLException {
        System.out.println("1. Afisare users");
        System.out.println("2. Sterge users");
        System.out.println("3. Modifica user");
        System.out.println("e. Exit");

        Scanner scanner = new Scanner(System.in);
        String option = scanner.nextLine();

        if(option.equals("1")) {
            part2A1(users, restaurante, localizari, restauranteCuRating);
        }
        else{
            if(option.equals("2")) {
                part2A2(users, restaurante, localizari, restauranteCuRating);
            }
            else {
                if(option.equals("3")) {
                    part2A4(users, restaurante, localizari, restauranteCuRating);
                }
                    if (option.equals("e")) {
                        System.exit(1);
                    } else {
                        System.out.println(System.lineSeparator().repeat(50));
                        System.out.println("Wrong input!");
                        part1(users, restaurante, localizari, restauranteCuRating);
                    }
            }
        }
    }

    public static void part2A1(Users users, Restaurante restaurante, List<Localizare> localizari, List<RestaurantCuRating> restauranteCuRating) throws InterruptedException, SQLException {
        users.showUsers();
        part2A(users, restaurante, localizari, restauranteCuRating);
    }

    public static void part2A2(Users users, Restaurante restaurante, List<Localizare> localizari, List<RestaurantCuRating> restauranteCuRating) throws InterruptedException, SQLException {
        users.showUsers();
        users.deleteUser();
        part2A(users, restaurante, localizari, restauranteCuRating);
    }

    public static void part2A4(Users users, Restaurante restaurante, List<Localizare> localizari, List<RestaurantCuRating> restauranteCuRating) throws SQLException, InterruptedException {
        users.showUsers();
        users.modificaUser();
        part2A(users, restaurante, localizari, restauranteCuRating);
    }

    public static void part2(Users users, Restaurante restaurante, List<Localizare> localizari, List<RestaurantCuRating> restauranteCuRating) throws InterruptedException, SQLException {
        System.out.println("1. Afisare restaurante");
        System.out.println("2. Afisare locatii");
        System.out.println("3. Cauta locatia");
        System.out.println("4. Cauta restaurant");
        System.out.println("e. Exit");

        Scanner scanner = new Scanner(System.in);
        String option = scanner.nextLine();

        if(option.equals("1")) {
            part21(users, restaurante, localizari, restauranteCuRating);
        }
        else {
            if (option.equals("2")) {
                part22(users, restaurante, localizari, restauranteCuRating);
            } else {
                if (option.equals("3")) {
                    part23(users, restaurante, localizari, restauranteCuRating);
                } else {
                    if (option.equals("4")) {
                        part24(users, restaurante, localizari, restauranteCuRating);
                    } else {
                        if (option.equals("e")) {
                            System.exit(1);
                        } else {
                            System.out.println(System.lineSeparator().repeat(50));
                            System.out.println("Wrong input!");
                            part1(users, restaurante, localizari, restauranteCuRating);
                        }
                    }
                }
            }
        }
    }

    public static void part21(Users users, Restaurante restaurante, List<Localizare> localizari, List<RestaurantCuRating> restauranteCuRating) throws InterruptedException, SQLException {
        restaurante.showRestaurante();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Introduceti numarul restaurantului :");

        int id = scanner.nextInt();

        if (id > 0 && id <= restaurante.getRestaurante().size()) {
            part3(users, restaurante, restaurante.getRestaurante().get(id - 1), localizari, restauranteCuRating);
        }
        else {
            System.out.println(System.lineSeparator().repeat(50));
            System.out.println("Numar invalid !");
            part21(users, restaurante, localizari, restauranteCuRating);
        }
    }

    public static void part22(Users users, Restaurante restaurante, List<Localizare> localizari, List<RestaurantCuRating> restauranteCuRating) throws InterruptedException, SQLException {
        int k = 1;
        for(Localizare auxLoc : localizari) {
            System.out.print(k);
            System.out.print(") Oras : ");
            System.out.print(auxLoc.getOras());
            System.out.print("\t Strada : ");
            System.out.print(auxLoc.getStrada());
            System.out.print("\t Nr. : ");
            System.out.println(auxLoc.getNr());
            k += 1;
        }
        System.out.println("Introduceti locatia :");

        Scanner scanner = new Scanner(System.in);

        int id = scanner.nextInt();

        if(id > 0 && id <= localizari.size()) {
            Localizare localizare = localizari.get(id - 1);
            Restaurant restaurant = restaurante.getRestauranteLoc(localizare);

            System.out.println(System.lineSeparator().repeat(50));
            System.out.print("Ati selectat restaurantul ");
            System.out.print(restaurant.getNume());
            System.out.println("!");
            part3(users, restaurante, restaurant, localizari, restauranteCuRating);
        }
        else {
            System.out.println(System.lineSeparator().repeat(50));
            System.out.println("Optiunea nu este valida!");
            part22(users, restaurante, localizari, restauranteCuRating);
        }
    }

    public static void part23(Users users, Restaurante restaurante, List<Localizare> localizari, List<RestaurantCuRating> restauranteCuRating) throws InterruptedException, SQLException {
        Scanner scanner = new Scanner(System.in);

        System.out.println(System.lineSeparator().repeat(50));
        System.out.println("Introduceti numele locului :");

        String search = scanner.nextLine();


        List<Restaurant> auxRestaurante = restaurante.cautaLocatie(search);

        if(auxRestaurante == null) {
            part2(users, restaurante, localizari, restauranteCuRating);
        }

        for(int i = 0; i < auxRestaurante.size(); i++) {
            System.out.println((i + 1) + ") " + auxRestaurante.get(i).getNume());
        }

        System.out.println("Introduceti numarul restaurantului dorit:");


        Scanner scanner1 = new Scanner(System.in);
        int nrRestaurant = scanner1.nextInt();

        if(nrRestaurant < 1 || nrRestaurant > auxRestaurante.size()) {
            System.out.println(System.lineSeparator().repeat(50));
            System.out.println("Numarul introdus este invalid!");
        }
        else{
            Restaurant restaurant = auxRestaurante.get(nrRestaurant - 1);

            if (restaurant == null || restaurant.getMeniu() == null || restaurant.getLocalizare() == null) {
                System.out.println("S-a produs o eroare la selectarea restaurantului!");
                System.exit(1);
            }

            part3(users, restaurante, restaurant, localizari, restauranteCuRating);
        }

    }

    public static void part24(Users users, Restaurante restaurante, List<Localizare> localizari, List<RestaurantCuRating> restauranteCuRating) throws InterruptedException, SQLException {
        Scanner scanner = new Scanner(System.in);

        System.out.println(System.lineSeparator().repeat(50));
        System.out.println("Introduceti numele restaurantului :");

        String search = scanner.nextLine();


        List<Restaurant> auxRestaurante = restaurante.cautaRestaurant(search);

        if(auxRestaurante == null) {
            part2(users, restaurante, localizari, restauranteCuRating);
        }

        for(int i = 0; i < auxRestaurante.size(); i++) {
            System.out.println((i + 1) + ") " + auxRestaurante.get(i).getNume());
        }

        System.out.println("Introduceti numarul restaurantului dorit:");


        Scanner scanner1 = new Scanner(System.in);
        int nrRestaurant = scanner1.nextInt();

        if(nrRestaurant < 1 || nrRestaurant > auxRestaurante.size()) {
            System.out.println(System.lineSeparator().repeat(50));
            System.out.println("Numarul introdus este invalid!");
        }
        else{
            Restaurant restaurant = auxRestaurante.get(nrRestaurant - 1);

            if (restaurant == null || restaurant.getMeniu() == null || restaurant.getLocalizare() == null) {
                System.out.println("S-a produs o eroare la selectarea restaurantului!");
                System.exit(1);
            }

            part3(users, restaurante, restaurant, localizari, restauranteCuRating);
        }

    }

    public static void part3(Users users,Restaurante restaurante, Restaurant restaurant, List<Localizare> localizari, List<RestaurantCuRating> restauranteCuRating) throws InterruptedException, SQLException {
        System.out.println("1. Afisare meniu");
        System.out.println("e. Exit");

        Scanner scanner = new Scanner(System.in);
        String option = scanner.nextLine();

        if(option.equals("1")) {
            part31(users, restaurante, restaurant, new ComandaImpl(), restauranteCuRating);
        }
        else{
            if(option.equals("2")) {
                part32(users, restaurante,restaurant , localizari, restauranteCuRating);
            }
            else {
                if (option.equals("e")) {
                    System.exit(1);
                } else {
                    System.out.println(System.lineSeparator().repeat(50));
                    System.out.println("Wrong input!");
                    part1(users, restaurante, localizari, restauranteCuRating);
                }
            }
        }
    }

    public static void part31(Users users, Restaurante restaurante, Restaurant restaurant, ComandaImpl comanda, List<RestaurantCuRating> restauranteCuRating) throws InterruptedException, SQLException {
        boolean ok = true;

        while (ok) {
            System.out.println(System.lineSeparator().repeat(50));

            restaurant.getMeniu().showMeniu();

            Scanner scanner = new Scanner(System.in);

            System.out.println("Selectati preparatul dorit :");

            int id = scanner.nextInt();

            if (id > 0 && id <= restaurant.getMeniu().getPreparate().size()) {
                comanda.adaugaPreparat(restaurant.getMeniu().getPreparat(id));
            }

            System.out.println("1. Finalizeaza comanda");
            System.out.println("2. Continua comanda");
            System.out.println("e. Exit");

            Scanner scanner2 = new Scanner(System.in);
            String id2 = scanner2.nextLine();

            if(id2.equals("1")) {
                finalComanda(users, restaurante, restaurant, comanda);
                ok = false;
            }
            else {
                    if (id2.equals("e")) {
                        System.exit(1);
                    }
            }
        }
    }

    public static void part32(Users users,Restaurante restaurante, Restaurant restaurant, List<Localizare> localizari, List<RestaurantCuRating> restauranteCuRating) throws InterruptedException {

    }

    public static void finalComanda(Users users, Restaurante restaurante, Restaurant restaurant, ComandaImpl comanda) throws InterruptedException {
        System.out.println(System.lineSeparator().repeat(50));

        Scanner scanner = new Scanner(System.in);

        System.out.println("Introduceti adresa :");
        String adresa = scanner.nextLine();

        System.out.println(System.lineSeparator().repeat(50));

        System.out.println("Rezumat comanda :");
        comanda.afiseazaComanda();
        System.out.print("Adresa livrarii : ");
        System.out.println(adresa);


        for(int i = 0; i < 10; i++){
            System.out.print("-");
            Thread.sleep(1000);
        }
        System.out.println(System.lineSeparator().repeat(50));

        Random random = new Random();

        int t1 = random.nextInt(10) + 5;

        System.out.print("Timp estimat de livrare : ");
        System.out.print(t1 + 5);
        System.out.println(" min.");

        Thread.sleep(random.nextInt(5)*1000 + 5000);
        System.out.println(System.lineSeparator().repeat(50));
        System.out.println("Comanda livrata!");
    }
}