package code;
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
    public Hashmap<Language , Integer> userProgress;
    private Word wordOfTheDay;
    private ArrayList<Language> languages; 
    public Language currentLanguage;

    public User() {

    }

    public User(String username, String password, UUID userID) {

    }

    public String sendReferralLink() {

    }

    public void addBookmarkedLesson(Lesson lesson) {
        
    }
    
    public Word getWordOfTheDay() {

    }

    public int getCoins() {

    }

    public User searchFriends(User target) {

    }

    public void setCoins(int coins) {

    }

    public String getUsername() {

    }

    public boolean setUsername(String username) {

    }

    public String getPassword() {

    }

    public boolean setPassword(String password) {

    }

    public void sendFriendRequest(User friend) {

    }

    public void acceptFriendRequest(boolean accept) {

    }

    public void addWordToDictionary(Word word) {

    }

    public boolean knowsWord(Word word, Dictionary otherLanguage) {

    }

    public void equipItem(Item item) {

    }

    public void setCurrentLanguage(Language language) {

    }

    public Language getCurrentLanguage() {

    }

    public void saveUser() {
        
    }



}
