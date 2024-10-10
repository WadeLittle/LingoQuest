package lingoQuest_package;

import java.util.ArrayList;
import java.util.UUID;

public class Users {
    private ArrayList<User> users;
    private User guestUser;
    private static Users usersObject;

    private Users() {
        users = new ArrayList<User>();
    }
/**
 * @author Wade Little
 * Returns the single instance of the Users class (Singleton)
 * @return the Users class
 */
    public static Users getInstance() {
        if(usersObject == null) {
            usersObject = new Users();
        }
        return usersObject;
    }
/**
 * @author Wade Little
 * This returns the user that has the matching username and password. If there is no match then it returns null and prints an error message.
 * @param username The username of the user you are getting
 * @param password The password of the user you are getting
 * @return The user with the matching username and password. Or null if the user can't be found
 */
    public User getUser(String username, String password) {
        User user = null;
        for(int i=0;i < users.size();i++) {
            if(users.get(i).getUsername().equals(username) && users.get(i).getPassword().equals(password)) {
                user = users.get(i);
                break;
            }
        }
        if(user == null) {
            System.out.println("Username or password invalid");
        }
        return user;
    }
   /**
    * @author Wade Little
    * Searches through the userlist for the specified UUID
    * @param userId the userid you are looking for
    * @return Null if the user isn't found, or the user with the matching UUID
    */
    public User getUserByUUID(UUID userId) {
        for(User user : users) {
            if(user.getUUID().equals(userId)) {
                return user;
            }
        }       
        System.out.println("User not found");
        return null;
    }
    /**
     * Creates a user if they provide a valid username and password
     * @param username The users desired username
     * @param password The users desired password
     * @return True if the user is created and added to userlist. False if the user has invalid credentials.
     */
    public boolean createUser(String username, String password) {
        User user = new User();
        if(user.setUsername(username) && user.setPassword(password)) {
            users.add(user);
            return true;
        } else {
            return false;
        }
    }

    public boolean containsUsername(String username) {

        return true;
    }

    public void editUser(User user) {

    }

    public void loadUsers() {

    }

    /**
     * @author Cade Stocker
     * @return a UUID
     * Originally debated between turning the UUID into a string,
     * but decided that the UUID class offers a lot of methods that may
     * be useful.
     */
    public UUID generateUUID() {
        return UUID.randomUUID();
    }
}
