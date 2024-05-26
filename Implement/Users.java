package Implement;

import Database.Database;
import Implement.User;
import Service.UsersService;

import javax.xml.crypto.Data;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Users implements UsersService {
    private List<UserWithRole> users;

    public Users() throws SQLException {
        users = new ArrayList<>();
        Database db = Database.getInstance();
        ResultSet resultSet = db.execQuery("SELECT * FROM USERS;");

        while (resultSet.next()) {
            users.add(new UserWithRole(resultSet.getString("username"), resultSet.getString("password"), resultSet.getBoolean("is_admin")));
        }
    }

    public UserWithRole login() throws SQLException {
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

    public boolean register() throws SQLException {
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

        Database database = Database.getInstance();
        database.execUpdate("INSERT INTO USERS (username, password, is_admin) VALUES ('" + username + "', '" + password + "', false);" );

        System.out.println(System.lineSeparator().repeat(50));
        System.out.println("Ati fost inregistrat cu succes !");
        return true;
    }

    public boolean registerAsAdmin() throws SQLException {
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

        users.add(new UserWithRole(username, password, true));
        Database database = Database.getInstance();
        database.execUpdate("INSERT INTO USERS (username, password, is_admin) VALUES ('" + username + "', '" + password + "', true);" );
        System.out.println(System.lineSeparator().repeat(50));
        System.out.println("Ati fost inregistrat cu succes !");
        return true;
    }

    public void addUser(User user) throws SQLException {
        UserWithRole userAux = new UserWithRole(user, false);
        Database database = Database.getInstance();
        database.execUpdate("INSERT INTO USERS (username, password, is_admin) VALUES ('" + userAux.getUsername() + "', '" + userAux.getPassword() + "', "+ userAux.isAdmin() + ");" );

        users.add(userAux);
    }

    public void addUser(UserWithRole user) throws SQLException {
        Database database = Database.getInstance();
        database.execUpdate("INSERT INTO USERS (username, password, is_admin) VALUES ('" + user.getUsername() + "', '" + user.getPassword() + "', "+ user.isAdmin() + ");" );

        users.add(user);
    }

    public void modificaUser() throws SQLException {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduceti numarul utilizatorului dorit :");

        int id = scanner.nextInt();

        if(id > 0 && id <= users.size()) {
            UserWithRole user = users.get(id - 1);

            if(!user.isAdmin()) {
                System.out.println("1. Schimba username");
                System.out.println("2. Schimba parola");
                int opt = scanner.nextInt();

                switch (opt){
                    case 1: {
                        System.out.println("Introduceti noul username:");
                        Scanner scanner1 = new Scanner(System.in);
                        String username = scanner1.nextLine();

                        Database database = Database.getInstance();
                        database.execUpdate("UPDATE users " +
                                "SET username = '" + username + "' " +
                                "WHERE username IN (SELECT username FROM users WHERE username = '" + user.getUsername() + "');");
                    }
                        break;
                    case 2: {
                        System.out.println("Introduceti noua parola:");
                        Scanner scanner1 = new Scanner(System.in);
                        String parola = scanner1.nextLine();

                        Database database = Database.getInstance();
                        database.execUpdate("UPDATE users " +
                                "SET password = '" + parola + "' " +
                                "WHERE username IN (SELECT username FROM users WHERE password = '" + user.getPassword() + "');");
                    }
                        break;
                    default:
                        System.out.println("Optiunea introdusa este invalida!");
                }

                System.out.println(System.lineSeparator().repeat(50));
                System.out.println("Utilizatorul a fost modificat cu succes!");
                return;
            }
            else {
                System.out.println("Accesul interzis! Utilizatorul este admin!");
                return;
            }
        }

        System.out.println(System.lineSeparator().repeat(50));
        System.out.println("Utilizatorul introdus nu exista!");
    }

    public void deleteUser() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduceti numarul utilizatorului dorit :");

        int id = scanner.nextInt();

        if(id > 0 && id <= users.size()) {
            UserWithRole user = users.get(id - 1);

            if(!user.isAdmin()) {
                Database database = Database.getInstance();
                database.execUpdate("DELETE FROM users WHERE username = '" + user.getUsername() + "' ;");
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
