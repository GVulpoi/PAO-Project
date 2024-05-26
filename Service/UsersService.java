package Service;

import Implement.User;
import Implement.UserWithRole;

import java.sql.SQLException;
import java.util.Scanner;

public interface UsersService {
    public UserWithRole login() throws SQLException;

    public boolean register() throws SQLException;

    public boolean registerAsAdmin() throws SQLException;

    public void addUser(User user) throws SQLException;

    public void addUser(UserWithRole user) throws SQLException;

    public void modificaUser() throws SQLException;

    public void deleteUser() throws SQLException;

    public void showUsers();
}
