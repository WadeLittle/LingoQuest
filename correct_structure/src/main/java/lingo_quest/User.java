package lingo_quest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public class User {
    public UUID userID;
    private Dictionary userDictionary;
    private UUID userDictionaryID;
    private int coinsEarned;
    private int coinBalance;

    // changed to UUID because you can access friend by their uuid
    private ArrayList<UUID> friendsList;
    private String username;
    private String password;
    private ArrayList<Item> items;
    private ArrayList<Lesson> bookmarkedLessons;

    // Changed userProgress key to Languages (enum) - cade
    public HashMap<Languages, Double> userProgress;
    private Word wordOfTheDay;
    private ArrayList<UUID> languages;

    // Changed this to Languages so that we can just use the enum we made - cade
    public Language currentLanguage;
    public Section currentSection;
    public Lesson currentLesson;

    /**
     * @author Wade Little
     *         Default constructor for the User class.
     *         Initializes a new User object with default values:
     *         - Generates a new UUID for the user.
     *         - Initializes the user's dictionary, friends list, items, bookmarked
     *         lessons, and language progress.
     *         - Sets coins earned and balance to 0.
     *         - Sets username and password to empty strings.
     *         - Sets currentLanguage and wordOfTheDay to null.
     */
    public User() {
        userID = Users.getInstance().generateUUID();
        userDictionary = new Dictionary();
        userDictionaryID = userDictionary.getID();
        coinsEarned = 0;
        coinBalance = 0;
        friendsList = new ArrayList<UUID>();
        username = null;
        password = null;
        items = new ArrayList<Item>();
        bookmarkedLessons = new ArrayList<Lesson>();
        userProgress = new HashMap<Languages, Double>();
        wordOfTheDay = null;
        languages = new ArrayList<UUID>();
        currentLanguage = null;
    }
/**
 * @author Wade Little
 * Pararamaterized constructor that throws an error if there isn't a valid username or password
 * @param username Desired users username
 * @param password Desired users password
 */
    public User(String username, String password) {
        if (!setUsername(username) || !setPassword(password)) {
            throw new IllegalArgumentException("Failed to create user: invalid username or password");
        }

        // If validation passes, initialize remaining fields
        this.userID = Users.getInstance().generateUUID();
        this.userDictionary = new Dictionary();
        this.userDictionaryID = this.userDictionary.getID();
        this.coinsEarned = 0;
        this.coinBalance = 0;
        this.friendsList = new ArrayList<>();
        this.items = new ArrayList<>();
        this.bookmarkedLessons = new ArrayList<>();
        this.userProgress = new HashMap<>();
        this.wordOfTheDay = null;
        this.languages = new ArrayList<>();
        this.currentLanguage = null;
    }

    /**
     * @author cade
     * @param d
     */
    public void setUserDictionary(Dictionary d) {
        if(d != null) {
            this.userDictionary = d;
            this.userDictionaryID = d.getID();
            return;
        }
        System.out.println("null dictionary attempted to be added setUserDictionary in User.java");
    }

    /**
     * @author cade
     * @return
     */
    public Dictionary getUserDictionary() {
        return this.userDictionary;
    }

    /**
     * @author cade
     * @return
     */
    public UUID getUserDictionaryID() {
        return this.userDictionaryID;
    }

    /**
     * @author cade
     * @param id
     */
    public void setUserDictionaryID(UUID id) {
        this.userDictionaryID = id;
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
     *         Gets the Word of the day
     * @return Word of the Day
     */
    public Word getWordOfTheDay() {
        return wordOfTheDay;
    }
    
/**
 * @author Wade Little
 * Gets the amount of coins earned
 * @return The users amount of coins earned
 */
    public int getCoinsEarned() {
        return coinsEarned;
    }
/**
 * @author Wade Little
 * Gets the users coin balance
 * @return The users coin balance
 */
    public int getCoinBalance() {
        return coinBalance;
    }

    public ArrayList<Item> getItems() {
        return this.items;
    }

    public ArrayList<UUID> getLanguages() {
        return this.languages;
    }

    /**
     * @author Wade Little
     *         Searches the users friends list and returns the friend if they are on
     *         the list or null if the user can't be found
     * @param username The user you are searching for's username
     * @return The user with the username if they are on the list or null if the
     *         username can't be found
     */
    public User searchFriends(UUID id) {
        for (int i = 0; i < friendsList.size(); i++) {
            if (friendsList.get(i).equals(id)) {
                return Users.getInstance().getUserByUUID(friendsList.get(i));
            }
        }
        return null;
    }

    public HashMap<Languages,Double> getUserProgress() {
        return this.userProgress;
    }

    /**
     * @author Wade Little
     *         Gets the User ID
     * @return the User ID
     */
    public UUID getUUID() {
        return userID;
    }

    /**
     * @author Wade Little
     *         Sets the coin balance to the paramater entered;
     * @param coins The coin balance you want to set the users coin balance to
     */
    public void setCoinBalance(int coins) {
        this.coinBalance = coins;
    }

    /**
     * @author Wade Little
     *         This adds the parameters coins to the coin balance and coins earned
     *         user variables
     * @param coins The amount of coins you are adding
     */
    public void addCoins(int coins) {
        coinBalance += coins;
        coinsEarned += coins;
    }

    /**
     * @author Wade Little
     *         This spends coins from the coin balance
     * @param coins the amount of coins you are spending
     */
    public void spendCoins(int coins) {
        coinBalance -= coins;
    }

    /**
     * @author Wade Little
     *         Gets the Users username
     * @return The username as a string
     */
    public String getUsername() {
        return username;
    }

    /**
     * @author Wade Little
     *         The desired username is checked against the userList to ensure there
     *         isn't 2 people with the same username. If the username is valid then
     *         the Users username is changed.
     * @param username The desired username
     * @return Whether or not the username goes through/is set
     */
    public boolean setUsername(String username) {
        Users userList = Users.getInstance();

        if (username == null || username.trim().isEmpty()) {
            System.out.println("Username cannot be empty or null");
            return false;
        } //else if (userList.containsUsername(username)) {
            //System.out.println("* Username already Taken *");
            //return false;
        //} 
        else if (username.length() < 4) {
            System.out.println("* Your username must be at least 4 characters *");
            return false;
        } else {
            this.username = username;
            return true;
        }
    }

    /**
     * @author Wade Little
     *         Gets the users password
     * @return The users password as a string
     */
    public String getPassword() {
        return password;
    }

    /**
     * @author Wade Little
     *         Sets the password if it is longer than 8 characters
     * @param password The desired user password
     * @return Whether or not the password is set
     */
    public boolean setPassword(String password) {
        if (password == null || password.trim().isEmpty()) {
            System.out.println("* Password can't have spaces");
            return false;
        } else if (password.length() < 8) {
            System.out.println("* Your password must be 8 characters long *");
            return false;
        } else {
            this.password = password;
            return true;
        }
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
    /**
     * @author Wade Little
     * Sets the current language to a new language
     * @param language The current language the user wants to switch to
     */
    public void setCurrentLanguage(Languages language) {
        this.currentLanguage = language;
    }

    /**
     * @author Wade Little
     * Gets the users current langauge
     * @return The users current language
     */
    public Languages getCurrentLanguage() {
        return currentLanguage;
    }

    public void saveUser() {

    }

    /**
     * @author Cade Stocker
     * @param item
     * @return whether the user has the item
     *         This method allows us to see if a user has already purchased an item,
     *         and removes
     *         the need for the "owned" variable inside of class Item
     */
    public boolean ownsItem(Item item) {
        return items.contains(item);
    }
    /**
     * @author Wade Little
     * Allows the user to buy an item if they don't already own it and they have enough coins to buy it
     * @param item The item the user wants to purchase
     * @return true if the user successfully buys the item, false if they already own it or they don't have enough coins to purchase it
     */
    public boolean buyItem(Item item) {
        synchronized(this) {
            if(this.ownsItem(item)) {
                System.out.println("User already owns this item");
                return false;
            } else if(item.getPrice() > this.coinBalance) {
                System.out.println("You don't have enough coins to purchase this item.");
                return false;
            }else {
                this.coinBalance -= item.getPrice();
                this.items.add(item);
                return true;
            }
        }
    }

    /**
     * @author CADE STOCKER
     *         created this method to test my dataloader for users
     * @return String of all the user's variables
     */
    public String toString() {
        return "User{" + "\n" +
                "userID=" + userID + "\n" +
                "password=" + password + "\n" +
                "username='" + username + '\'' + "\n" +
                "coinBalance=" + coinBalance + "\n" +
                "coinsEarned=" + coinsEarned + "\n" +
                "currentLanguage=" + currentLanguage + "\n" +
                "numberOfFriends=" + (friendsList != null ? friendsList.size() : 0) + "\n" +
                "numberOfItems=" + (items != null ? items.size() : 0) + "\n" +
                "numberOfBookmarkedLessons=" + (bookmarkedLessons != null ? bookmarkedLessons.size() : 0) + "\n" +
                "wordOfTheDay=" + (wordOfTheDay != null ? wordOfTheDay.toString() : "None") + "\n" +
                "languages=" + (languages != null ? languages.toString() : "None") + "\n" +
                '}';
    }

    /**
     * @author Cade Stocker
     * setID method will take in a string, turn it into a UUID,
     * then will set it if there isn't already a UUID.
     * 
     * CHANGED TO SET THE ID REGARDLESS IF ONE ALREADY EXISTS
     * NEEDED THIS CHANGE FOR DATALOADER
     * @param UUID
     */
    public void setID(UUID id) {
        this.userID = id;
    }

    /**
     * @author CADE STOCKER
     * @param coins
     */
    public void setCoinsEarned(int coins) {
        this.coinsEarned = coins;
    }

    /**
     * @author CADE STOCKER
     * @param list
     * used for dataloader purposes
     */
    public void setFriendsList(ArrayList<String> list) {
        ArrayList<UUID> friends = new ArrayList<UUID>();
        for (String friend : list) {
            UUID friendID = UUID.fromString(friend);
            //User u = Users.getInstance().getUserByUUID(friendID); // causing error (reading friends before all users loaded in)
            //friends.add(u);
            friends.add(friendID);
        }
    }

    public ArrayList<UUID> getFriendsList() {
        return this.friendsList;
    }

    /**
     * @author CADE STOCKER
     * @param ArrayList<Item>
     * used for dataloader
     */
    public void setItems(ArrayList<Item> items) {
        if(items != null)
            this.items = items;
    }

    /**
     * @author CADE STOCKER
     * @param HashMap<Languages,int>
     * used for dataloader
     * Had to do some parsing to get this method right.
     */
    public void setUserProgress(HashMap<Languages,Double> progress) {
        /*if(progress != null) {
            HashMap<Languages,Double> map = new HashMap();
            for (Languages key : progress.keySet()) {
                map.put(key, map.get(key));
            }
            this.userProgress = map;
        }*/
        this.userProgress = progress;
    }

    /**
     * @author CADE STOCKER
     * @param word
     * used for dataloader
     */
    public void setWordOfTheDay(Word word) {
        this.wordOfTheDay = word;
    }

    /**
     * @author CADE STOCKER
     * @param list
     * used for dataloader
     * changed languages to be stored as uuid
     */
    public void setLanguages(ArrayList<UUID> list) {
        for(UUID id : list)
            this.languages.add(id);
    }

}
