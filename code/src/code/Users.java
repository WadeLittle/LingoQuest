package code;

import java.util.ArrayList;
import java.util.UUID;

public class Users {
    private ArrayList<User> users;
    private User guestUser;
    private static Users usersObject;

    private Users() {

    }

    public static Users getInstance() {

        return usersObject;
    }

    public User getUser(String username, String password) {

        return users.get(0);
    }

    public boolean createUser(String username, String password) {

        return true;
    }

    public boolean containsUsername(String username) {

        return true;
    }

    public void editUser(User user) {

    }

    public void loadUsers() {

    }

    public UUID generateUUID() {
        
        return users.get(0).userID;
    }



}
