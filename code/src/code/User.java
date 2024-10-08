package code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public class User {
    public UUID userID;
    private Dictionary userDictionary;
    private int coinsEarned;
    private int coinBalance;
    private ArrayList<User> friendsList;
    private String username;
    private String password;
    private ArrayList<Item> items;
    private ArrayList<Lesson> bookmarkedLessons;
    public HashMap<Language, Integer> userProgress;
    private Word wordOfTheDay;
    private ArrayList<Language> languages;
    public Language currentLanguage;

    public User() {

    }

    public User(String username, String password, UUID userID) {

    }

    public String sendReferralLink() {

        return "";
    }

    /**
     * @author Wade Little
     *         Adds the bookmarked lesson to the bookmarked lessons array list if it
     *         isn't there. Removes the lesson if it's already added. This creates a
     *         toggle feature to easily add and remove bookmarked lessons.
     * @param lesson The lesson you want to add/remove from the bookmarked lessons
     *               list
     */
    public void addBookmarkedLesson(Lesson lesson) {
        boolean contains = false;
        for (int i = 0; i < bookmarkedLessons.size(); i++) {
            if (bookmarkedLessons.get(i).equals(lesson)) {
                contains = true;
                break;
            }
        }
        if (contains) {
            bookmarkedLessons.remove(lesson);
        } else {
            bookmarkedLessons.add(lesson);
        }
    }
    /**
     * @author Wade Little
     * Gets the Word of the day
     * @return Word of the Day
     */
    public Word getWordOfTheDay() {
        return wordOfTheDay;
    }

    public int getCoins() {

        return 0;
    }
    /**
     * @author Wade Little
     * Searches the users friends list and returns the friend if they are on the list or null if the user can't be found
     * @param username The user you are searching for's username
     * @return The user with the username if they are on the list or null if the username can't be found
     */
    public User searchFriends(String username) {
        for(int i = 0; i < friendsList.size();i++) {
            if(friendsList.get(i).getUsername().equals(username)) {
            return friendsList.get(i);
            }
        }
        return null;
    }
    /**
     * @author Wade Little
     * Gets the User ID
     * @return the User ID
     */
    public UUID getUUID() {
        return userID;
    }
    /**
     * @author Wade Little
     * Sets the coin balance to the paramater entered;
     * @param coins The coin balance you want to set the users coin balance to
     */
    public void setCoinBalance(int coins) {
        this.coinBalance = coins;
    }
    /**
     * @author Wade Little
     * This adds the parameters coins to the coin balance and coins earned user variables
     * @param coins The amount of coins you are adding
     */
    public void addCoins(int coins) {
        coinBalance +=coins;
        coinsEarned += coins;
    }
    /**
     * @author Wade Little
     * This spends coins from the coin balance
     * @param coins the amount of coins you are spending
     */
    public void spendCoins(int coins) {
        coinBalance -= coins;
    }
    /**
     * @author Wade Little
     * Gets the Users username
     * @return The username as a string
     */
    public String getUsername() {
        return username;
    }
    /**
     * @author Wade Little
     * The desired username is checked against the userList to ensure there isn't 2 people with the same username. If the username is valid then the Users username is changed.
     * @param username The desired username
     * @return Whether or not the username goes through/is set
     */
    public boolean setUsername(String username) {
        Users userList = Users.getInstance();

        if(username == null || username.trim().isEmpty()) {
            System.out.println("Username cannot be empty or null");
            return false;
        }else if(userList.containsUsername(username)) {
            System.out.println("* Username already Taken *");
            return false;
        } else if (username.length() < 4) {
            System.out.println("* Your username must be at least 4 characters *");
            return false;
        }else {
            this.username = username;
            return true;
        }
    }

    public String getPassword() {

        return password;
    }

    public boolean setPassword(String password) {

        return true;
    }

    public void sendFriendRequest(User friend) {

    }

    public void acceptFriendRequest(boolean accept) {

    }

    public void addWordToDictionary(Word word) {

    }

    public boolean knowsWord(Word word, Dictionary otherLanguage) {

        return true;
    }

    public void equipItem(Item item) {

    }

    public void setCurrentLanguage(Language language) {

    }

    public Language getCurrentLanguage() {

        return currentLanguage;
    }

    public void saveUser() {

    }

}
