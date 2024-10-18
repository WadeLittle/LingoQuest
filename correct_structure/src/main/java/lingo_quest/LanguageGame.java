package lingo_quest;

import java.util.ArrayList;

class LanguageGame {
    private Users userList;
    private User user;
    private ItemShop itemShop;
    private Dictionary userDictionary;
    private Language currentLanguage;
    private LanguageManager languageManager;
    private LeaderBoard leaderboard;
    private Section currentSection;
    private Lesson currentLesson;
    private Word userAnswer;

    public LanguageGame() {
        this.userList = Users.getInstance();
        userList.loadUsers();
        this.itemShop = ItemShop.getInstance();
        // work on other variables for constructor
    }

    public void createUser(String username, String password) {
        if(this.user != null) {
            System.out.println("Someone is already logged in");
            return;
        }
        User createdUser = new User(username,password);
        this.user = createdUser;
        userList.createUser(username, password);
        System.out.println("Successfully Created Account");
    }

    /**
     * @author cade stocker
     * @return whether there is a user stored in this.user
     */
    public boolean hasCurrentUser() {
        return (this.user != null);
    }

    public void getItemInformation() {
    }

    public void setCurrentLanguage(Language language) {
    }
    /**
     * @author Wade Little
     * Checks the userlist for the entered username and password and returns a valid user or null user
     * @param username The username that the user is trying to login with
     * @param password The password the user is trying to login with
     * @return A valid User or null if it isn't a valid user
     */
    public void login(String username, String password) {
        // will load users in constructor
        //userList.loadUsers();
        this.user = userList.getUser(username, password);
    }

    public void logout() {
        this.userList.saveUsers();
        // set current user to null
        this.user = null;
        System.out.println("Successfully logged out");
    }

    public Dictionary getLanguageDictionary(String language) {
        return null;
    }

    public ArrayList<Language> getAllLanguages() {
        return null;
    }

    public boolean openSection(Section section) {
        return false;
    }

    public boolean startLesson(Lesson lesson) {
        return false;
    }

    public boolean startPlacementTest(PlacementTest test) {
        return false;
    }

    /**
     * @author cade stocker
     * @param lesson
     * @return
     */
    public double getLessonProgress(Lesson lesson) {
        return lesson.getLessonProgress();
    }

    public ArrayList<Lesson> getBookMarkedLessons(User user) {
        return null;
    }

    public ArrayList<Section> getAvailableSections() {
        return null;
    }

    public ArrayList<Lesson> getAvailableLessons() {
        return null;
    }

    public void setUserAnswer(Word userAnswer) {
        this.userAnswer = userAnswer;
    }

    public boolean answerQuestion() {
        return false;
    }

    public User getUser() {
        return this.user;
    }
/**
 * @author Wade Little
 * This class runs itemshop.displayItemShop() to view the item shop.
 */
    public void checkItemShop() {
        itemShop.displayItemShop();;
    }
}
