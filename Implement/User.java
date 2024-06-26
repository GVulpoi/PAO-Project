package Implement;

import Service.UserService;

public class User implements UserService {
    private String username;
    private String password;

    public User() {
    }

    public User(String auxUsername, String auxPassword) {
        username = auxUsername;
        password = auxPassword;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
