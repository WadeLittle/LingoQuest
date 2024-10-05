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
    public HashMap<Language , Integer> userProgress;
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

    public void addBookmarkedLesson(Lesson lesson) {
        
    }
    
    public Word getWordOfTheDay() {

        return wordOfTheDay;
    }

    public int getCoins() {

        return 0;
    }

    public User searchFriends(User target) {

        return target;
    }

    public void setCoins(int coins) {

    }

    public String getUsername() {

        return username;
    }

    public boolean setUsername(String username) {

        return true;
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
