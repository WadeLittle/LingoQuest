package lingo_quest;

import java.util.ArrayList;
import java.util.Collections;

/**
 * The Leaderboard class maintains a list of users and their rankings based on points.
 * It supports adding/removing users and sorting the leaderboard by the user's total points.
 */
public class Leaderboard {
    
    // List to store users
    private ArrayList<User> users;
    private static Leaderboard leaderboardInstance;

    /**
     * Private constructor for the Leaderboard class.
     * Initializes the list of users.
     */
    private Leaderboard() {
        users = new ArrayList<>();
    }

    /**
     * Returns the singleton instance of the Leaderboard.
     *
     * @return The singleton Leaderboard instance.
     */
    public static Leaderboard getInstance() {
        if (leaderboardInstance == null) {
            leaderboardInstance = new Leaderboard();
        }
        return leaderboardInstance;
    }

    /**
     * Adds a user to the leaderboard.
     *
     * @param user The user to be added to the leaderboard.
     */
    public void addUser(User user) {
        users.add(user);
    }

    /**
     * Removes a user from the leaderboard.
     *
     * @param user The user to be removed from the leaderboard.
     */
    public void removeUser(User user) {
        users.remove(user);
    }

    /**
     * Sorts the leaderboard based on the users' total points in descending order.
     */
    public void sortLeaderboard() {
       
    }

    /**
     * Prints the leaderboard in a formatted way, showing the username and total points of each user.
     */
    public void printLeaderboard() {
        System.out.println("Leaderboard:");
        for (int i = 0; i < users.size(); i++) {
            System.out.println((i + 1) + ". " + users.get(i).getUsername() + " - " + users.get(i).getTotalPoints() + " points");
        }
    }

    /**
     * Gets the list of users in the leaderboard.
     *
     * @return The list of users in the leaderboard.
     */
    public ArrayList<User> getUsers() {
        return users;
    }
}
