import Meniu.Ingrediente;
import Meniu.Meniu;
import Meniu.Preparat;

import User.Users;
import User.User;
import User.UserWithRole;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Users users = new Users();

        UserWithRole admin = new UserWithRole("admin", "1234567", true);

        users.addUser(admin);

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

        Meniu meniu = new Meniu(new HashSet<>(Arrays.asList(pr1, pr2, pr3)));

        meniu.showMeniu();
        //part1(users);
    }

    public static void part1(Users users) {
        System.out.println("1. Creare user");
        System.out.println("2. Login");
        System.out.println("3. Creare user admin");
        System.out.println("e. Exit");

        Scanner scanner = new Scanner(System.in);
        String option = scanner.nextLine();

        if(option.equals("1")) {
            part11(users);
        }
        else{
            if(option.equals("2")) {
                part12(users);
            }
            else {
                if(option.equals("3")) {
                    part13(users);
                }
                else {
                    if(option.equals("e")) {
                        System.exit(1);
                    }
                    else {
                        System.out.println(System.lineSeparator().repeat(50));
                        System.out.println("Wrong input!");
                        part1(users);
                    }
                }
            }
        }
    }

    public static void part2(Users users) {
        System.out.println("1. Afisare restaurante");
        System.out.println("2. Afisare locatii");
        System.out.println("3. Cauta locatia");
        System.out.println("4. Cauta restaurant");
        System.out.println("e. Exit");

        Scanner scanner = new Scanner(System.in);
        String option = scanner.nextLine();

        if(option.equals("1")) {

        }

        if(option.equals("")) {

        }

        if(option.equals("")) {

        }

        if(option.equals("")) {

        }
    }

    public static void part2A(Users users) {
        System.out.println("1. Afisare users");
        System.out.println("2. Sterge users");
        System.out.println("3. Modifica restaurant");
        System.out.println("4. Modifica locatie");
        System.out.println("e. Exit");

        Scanner scanner = new Scanner(System.in);
        String option = scanner.nextLine();

        if(option.equals("1")) {
            part2A1(users);
        }
        else{
            if(option.equals("2")) {
                part2A2(users);
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
                            part1(users);
                        }
                    }
                }
            }
        }
    }

    public static void part11(Users users) {
        if(!users.register()) {
            part1(users);
        }

        part1(users);
    }

    public static void part12(Users users) {
        UserWithRole user = users.login();

        if(user == null) {
            part1(users);
        }

        if(user.isAdmin()) {
            part2A(users);
        }
        else {
            part2(users);
        }
    }

    public static void part13(Users users) {
        if(!users.registerAsAdmin()) {
            part1(users);
        }

        part1(users);
    }

    public static void part2A1(Users users) {
        users.showUsers();
        part2A(users);
    }

    public static void part2A2(Users users) {
        users.showUsers();
        users.deleteUser();
        part2A(users);
    }
}
