package Implement;

import Implement.User;
import Service.UsersService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Users implements UsersService {
    private List<UserWithRole> users;

    public Users() {
        users = new ArrayList<>();
    }

    public UserWithRole login() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Username :");

        String username = scanner.nextLine();

        for(int i = 0; i < users.size(); i++) {
            if (username.equals(users.get(i).getUsername())) {
                System.out.println("Password :");

                String password = scanner.nextLine();

                if (password.equals(users.get(i).getPassword())) {
                    System.out.println(System.lineSeparator().repeat(50));
                    System.out.println("Ati fost logat cu succes !");
                    return users.get(i);
                }
                else {
                    System.out.println(System.lineSeparator().repeat(50));
                    System.out.println("Parola introdusa este incorecta !");
                    return null;
                }
            }
        }
        System.out.println(System.lineSeparator().repeat(50));
        System.out.println("Numele de utilizator introdus este incorect !");
        return null;
    }

    public boolean register() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Username (Minim 3 caractere) :");
        String username = scanner.nextLine();

        for(int i = 0; i < users.size(); i++) {
            if (username.equals(users.get(i).getUsername())) {
                System.out.println(System.lineSeparator().repeat(50));
                System.out.println("Numele de utilizator introdus este folosit !");
                return false;
            }
        }

        if (username.length() < 3) {
            System.out.println(System.lineSeparator().repeat(50));
            System.out.println("Numele de utilizator trebuie sa contina minim 3 caractere");
            return false;
        }

        System.out.println("Password (Minim 7 caractere) :");
        String password = scanner.nextLine();

        if (password.length() < 7) {
            System.out.println(System.lineSeparator().repeat(50));
            System.out.println("Parola trebuie sa contina minim 7 caractere");
            return false;
        }

        users.add(new UserWithRole(username, password, false));

        System.out.println(System.lineSeparator().repeat(50));
        System.out.println("Ati fost inregistrat cu succes !");
        return true;
    }

    public boolean registerAsAdmin() {
        Scanner scanner = new Scanner(System.in);
        String secretPassw = "Secpa55";

        System.out.println("Username (Minim 3 caractere) :");
        String username = scanner.nextLine();

        for(int i = 0; i < users.size(); i++) {
            if (username.equals(users.get(i).getUsername())) {
                System.out.println(System.lineSeparator().repeat(50));
                System.out.println("Numele de utilizator introdus este folosit !");
                return false;
            }
        }

        if (username.length() < 3) {
            System.out.println(System.lineSeparator().repeat(50));
            System.out.println("Numele de utilizator trebuie sa contina minim 3 caractere");
            return false;
        }

        System.out.println("Password (Minim 7 caractere) :");
        String password = scanner.nextLine();

        if (password.length() < 7) {
            System.out.println(System.lineSeparator().repeat(50));
            System.out.println("Parola trebuie sa contina minim 7 caractere");
            return false;
        }

        System.out.println("Secret password :");
        String secPassw = scanner.nextLine();

        if(!secPassw.equals(secretPassw)) {
            System.out.println(System.lineSeparator().repeat(50));
            System.out.println("Parola admin introdusa este gresita!");
            return false;
        }

        users.add(new UserWithRole(username, password, false));

        System.out.println(System.lineSeparator().repeat(50));
        System.out.println("Ati fost inregistrat cu succes !");
        return true;
    }

    public void addUser(User user) {
        UserWithRole userAux = new UserWithRole(user, false);
        users.add(userAux);
    }

    public void addUser(UserWithRole user) {
        users.add(user);
    }

    public void deleteUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduceti numarul utilizatorului dorit :");

        int id = scanner.nextInt();

        if(id > 0 && id <= users.size()) {
            UserWithRole user = users.get(id);

            if(!user.isAdmin()) {
                users.remove(id - 1);
                System.out.println(System.lineSeparator().repeat(50));
                System.out.println("Utilizatorul a fost sters cu succes!");
                return;
            }
            else {
                System.out.print("Accesul interzis! Utilizatorul este admin!");
                return;
            }
        }

        System.out.println(System.lineSeparator().repeat(50));
        System.out.println("Utilizatorul introdus nu exista!");
    }

    public void showUsers() {
        int k = 1;
        for (UserWithRole aux : users) {
            System.out.print(k);
            System.out.print(") Username : ");
            System.out.print(aux.getUsername());
            System.out.print("\nAdmin : ");
            System.out.print(aux.isAdmin());
            System.out.println();
            k += 1;
        }
    }
}
