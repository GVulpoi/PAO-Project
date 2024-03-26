import Localizare.Localizare;
import Meniu.Ingrediente;
import Meniu.Meniu;
import Meniu.Preparat;

import Restaurante.Restaurant;
import Restaurante.Restaurante;
import ShoppingCart.ComandaImpl;
import User.Users;
import User.User;
import User.UserWithRole;

import java.util.*;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Users users = new Users();

        UserWithRole admin = new UserWithRole("admin", "1234567", true);
        User adita = new UserWithRole("adrian", "1234567", false);

        users.addUser(admin);
        users.addUser(adita);

        Preparat pr1 = new Preparat(new String[]{"cartofi", "ardei", "suc de rosii"}, "Tocana de Ardei", 130);
        Preparat pr2 = new Preparat(new String[]{"carne de pui", "ceapa", "usturoi", "apa"}, "Supa de pui", 200);
        Preparat pr3 = new Preparat(new String[]{"orez", "fasole", "ardei", "rosii"}, "Chili con carne", 300);
        Preparat pr4 = new Preparat(new String[]{"cartofi", "branza", "salam", "smantana"}, "Cartofi gratinati", 250);
        Preparat pr5 = new Preparat(new String[]{"oua", "ceapa", "rosii", "ardei"}, "Omleta", 180);
        Preparat pr6 = new Preparat(new String[]{"paste", "sos de rosii", "branza", "busuioc"}, "Paste cu sos de rosii", 350);
        Preparat pr7 = new Preparat(new String[]{"ton", "salata verde", "rosii", "masline"}, "Salata Nicoise", 180);
        Preparat pr8 = new Preparat(new String[]{"piept de pui", "sos teriyaki", "orez", "broccoli"}, "Pui teriyaki cu orez", 280);
        Preparat pr9 = new Preparat(new String[]{"dovlecei", "vinete", "ardei", "ceapa"}, "Ratatouille", 220);
        Preparat pr10 = new Preparat(new String[]{"carne tocata", "orez", "morcov", "mazare"}, "Pilaf", 320);

        List<Localizare> localizari = new ArrayList<>();
        localizari.add(new Localizare("Bucuresti", "Herastrau park", 28));
        localizari.add(new Localizare("Targoviste", "Centrul vechi", 17));
        localizari.add(new Localizare("Bucuresti", "Calea floreasca", 111));
        localizari.add(new Localizare("Bucuresti", "Calea floreasca", 111));

        Restaurant tavRac = new Restaurant("Taverna Racilor", new Localizare("Bucuresti", "Herastrau park", 28), new Meniu(new HashSet<>(Arrays.asList(pr1, pr2, pr3))));
        Restaurant story = new Restaurant("Story Wine and Music", new Localizare("Targoviste", "Centrul vechi", 17), new Meniu(new HashSet<>(Arrays.asList(pr3, pr2, pr5, pr6))));
        Restaurant vacamuuu = new Restaurant("Vacamuuu", new Localizare("Bucuresti", "Calea floreasca", 111), new Meniu(new HashSet<>(Arrays.asList(pr3, pr8, pr5, pr9, pr7))));
        Restaurant pescLuiMatei = new Restaurant("Pescaria Lui Matei", new Localizare("Bucuresti", "Calea floreasca", 111), new Meniu(new HashSet<>(Arrays.asList(pr3, pr10, pr4, pr6))));

        Restaurante restaurante = new Restaurante();
        restaurante.addRestaurant(tavRac);
        restaurante.addRestaurant(story);
        restaurante.addRestaurant(vacamuuu);
        restaurante.addRestaurant(pescLuiMatei);

        part1(users, restaurante, localizari);
    }

    public static void part1(Users users, Restaurante restaurante, List<Localizare> localizari) throws InterruptedException {
        System.out.println("1. Creare user");
        System.out.println("2. Login");
        System.out.println("3. Creare user admin");
        System.out.println("e. Exit");

        Scanner scanner = new Scanner(System.in);
        String option = scanner.nextLine();

        if(option.equals("1")) {
            part11(users, restaurante, localizari);
        }
        else{
            if(option.equals("2")) {
                part12(users, restaurante, localizari);
            }
            else {
                if(option.equals("3")) {
                    part13(users, restaurante, localizari);
                }
                else {
                    if(option.equals("e")) {
                        System.exit(1);
                    }
                    else {
                        System.out.println(System.lineSeparator().repeat(50));
                        System.out.println("Wrong input!");
                        part1(users, restaurante, localizari);
                    }
                }
            }
        }
    }

    public static void part2(Users users, Restaurante restaurante, List<Localizare> localizari) throws InterruptedException {
        System.out.println("1. Afisare restaurante");
        System.out.println("2. Afisare locatii");
        System.out.println("3. Cauta locatia");
        System.out.println("4. Cauta restaurant");
        System.out.println("e. Exit");

        Scanner scanner = new Scanner(System.in);
        String option = scanner.nextLine();

        if(option.equals("1")) {
            part21(users, restaurante, localizari);
        }
        else {
            if (option.equals("2")) {
                part22(users, restaurante, localizari);
            } else {
                if (option.equals("3")) {
                } else {
                    if (option.equals("4")) {

                    } else {
                        if (option.equals("e")) {
                            System.exit(1);
                        } else {
                            System.out.println(System.lineSeparator().repeat(50));
                            System.out.println("Wrong input!");
                            part1(users, restaurante, localizari);
                        }
                    }
                }
            }
        }
    }

    public static void part2A(Users users, Restaurante restaurante, List<Localizare> localizari) throws InterruptedException {
        System.out.println("1. Afisare users");
        System.out.println("2. Sterge users");
        System.out.println("3. Modifica restaurant");
        System.out.println("4. Modifica locatie");
        System.out.println("e. Exit");

        Scanner scanner = new Scanner(System.in);
        String option = scanner.nextLine();

        if(option.equals("1")) {
            part2A1(users, restaurante, localizari);
        }
        else{
            if(option.equals("2")) {
                part2A2(users, restaurante, localizari);
            }
            else {
                if(option.equals("3")) {
                }
                else {
                    if(option.equals("4")) {

                    }
                    else {
                        if (option.equals("e")) {
                            System.exit(1);
                        } else {
                            System.out.println(System.lineSeparator().repeat(50));
                            System.out.println("Wrong input!");
                            part1(users, restaurante, localizari);
                        }
                    }
                }
            }
        }
    }

    public static void part3(Users users,Restaurante restaurante, Restaurant restaurant, List<Localizare> localizari) throws InterruptedException {
        System.out.println("1. Afisare meniu");
        System.out.println("2. Afisare descriere");
        System.out.println("3. Afisare rating");
        System.out.println("e. Exit");

        Scanner scanner = new Scanner(System.in);
        String option = scanner.nextLine();

        if(option.equals("1")) {
            part31(users, restaurante, restaurant, new ComandaImpl());
        }
        else{
            if(option.equals("2")) {
            }
            else {
                if(option.equals("3")) {
                }
                else {
                    if (option.equals("e")) {
                        System.exit(1);
                    } else {
                        System.out.println(System.lineSeparator().repeat(50));
                        System.out.println("Wrong input!");
                        part1(users, restaurante, localizari);
                    }
                }
            }
        }
    }

    public static void part11(Users users, Restaurante restaurante, List<Localizare> localizari) throws InterruptedException {
        if(!users.register()) {
            part1(users, restaurante, localizari);
        }

        part1(users, restaurante, localizari);
    }

    public static void part12(Users users, Restaurante restaurante, List<Localizare> localizari) throws InterruptedException {
        UserWithRole user = users.login();

        if(user == null) {
            part1(users, restaurante, localizari);
        }

        if(user.isAdmin()) {
            part2A(users, restaurante, localizari);
        }
        else {
            part2(users, restaurante, localizari);
        }
    }

    public static void part13(Users users, Restaurante restaurante, List<Localizare> localizari) throws InterruptedException {
        if(!users.registerAsAdmin()) {
            part1(users, restaurante, localizari);
        }

        part1(users, restaurante, localizari);
    }

    public static void part2A1(Users users, Restaurante restaurante, List<Localizare> localizari) throws InterruptedException {
        users.showUsers();
        part2A(users, restaurante, localizari);
    }

    public static void part2A2(Users users, Restaurante restaurante, List<Localizare> localizari) throws InterruptedException {
        users.showUsers();
        users.deleteUser();
        part2A(users, restaurante, localizari);
    }

    public static void part21(Users users, Restaurante restaurante, List<Localizare> localizari) throws InterruptedException {
        restaurante.showRestaurante();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Introduceti numarul restaurantului :");

        int id = scanner.nextInt();

        if (id > 0 && id <= restaurante.getRestaurante().size()) {
            part3(users, restaurante, restaurante.getRestaurante().get(id - 1), localizari);
        }
        else {
            System.out.println(System.lineSeparator().repeat(50));
            System.out.println("Numar invalid !");
            part21(users, restaurante, localizari);
        }
    }

    public static void part22(Users users, Restaurante restaurante, List<Localizare> localizari) {
        int k = 1;
        for(Localizare auxLoc : localizari) {
            System.out.print(k);
            System.out.print(") Oras : ");
            System.out.print(auxLoc.getOras());
            System.out.print("\t Strada : ");
            System.out.print(auxLoc.getStrada());
            System.out.print("\t Nr. : ");
            System.out.println(auxLoc.getNr());
        }
        System.out.println("Introduceti locatia :");

        Scanner scanner = new Scanner(System.in);

        int id = scanner.nextInt();

        if(id > 0 && id <= localizari.size()) {
            Localizare localizare = localizari.get(id - 1);

        }
        else {
            System.out.println(System.lineSeparator().repeat(50));
            System.out.println("Optiunea nu este valida!");
            part22(users, restaurante, localizari);
        }
    }

    public static void part31(Users users, Restaurante restaurante, Restaurant restaurant, ComandaImpl comanda) throws InterruptedException {
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
            }else if (id2.equals("e")) {
                System.exit(1);
            }
        }
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
