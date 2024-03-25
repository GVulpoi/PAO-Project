package User;

public class UserWithRole extends User {
    private boolean admin;

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
