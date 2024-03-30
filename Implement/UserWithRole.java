package Implement;

import Implement.User;
import Service.UserWithRoleService;

public class UserWithRole extends User implements UserWithRoleService {
    private boolean admin;

    public UserWithRole(User user) {
        this.setUsername(user.getUsername());
        this.setPassword(user.getPassword());
        admin = false;
    }

    public UserWithRole(User user, boolean bool) {
        this.setUsername(user.getUsername());
        this.setPassword(user.getPassword());
        admin = bool;
    }

    public UserWithRole(String username, String password, boolean bool) {
        this.setUsername(username);
        this.setPassword(password);
        admin = bool;
    }

    public boolean isAdmin() {
        return admin;
    }
}
