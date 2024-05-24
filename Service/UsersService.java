package Service;

import Implement.User;
import Implement.UserWithRole;

import java.sql.SQLException;
import java.util.Scanner;

public interface UsersService {
    public UserWithRole login() throws SQLException;

    public boolean register();

    public boolean registerAsAdmin();

    public void addUser(User user);

    public void addUser(UserWithRole user);

    public void deleteUser();

    public void showUsers();
}
