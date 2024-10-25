package lingo_quest;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;
import java.util.HashMap;

class LanguageGame {
    private Users userList;
    private User user;
    private ItemShop itemShop;
    private DictionaryManager dictionaryMan;
    private Dictionary userDictionary;
    private Language currentLanguage;
    private LanguageManager languageManager;
    private LeaderBoard leaderboard;
    private Word userAnswer;

    // test comment
    public LanguageGame() throws Exception {
        this.userList = Users.getInstance();
        this.dictionaryMan = DictionaryManager.getInstance();
        //userList.loadUsers();
        this.itemShop = ItemShop.getInstance();
        this.languageManager = LanguageManager.getInstance();
        this.loadAll();
        // work on other variables for constructor
    }

    public void createUser(String username, String password) {
        if(this.user != null) {
            System.out.println("Someone is already logged in");
            return;
        }
        if(this.userList.containsUsername(username)) {
            System.out.println("Username already exists.");
            return;
        }
        User createdUser = new User(username,password);
        this.user = createdUser;
        userList.createUser(username, password);
        System.out.println("Successfully Created Account");
    }

    /**
     * @author cade
     * load all of our singletons
     * @throws Exception 
     */
    public void loadAll() throws Exception {
        dictionaryMan.loadDictionaries();
        System.out.println("done with load dictionaries");
        userList.loadUsers();
        System.out.println("done with loadusers");
        languageManager.loadLanguages();
        System.out.println("done with load languages");
        itemShop.loadItems();

        // load object the user needs by their UUIDs
        for(User u : userList.getUsers()) {
            // use the UUID's to access the language from languagemanager
            u.setCurrentLanguage(languageManager.getLanguageByID(u.getCurrentLanguageID()));
            u.setUserDictionary(dictionaryMan.getDictionaryByID(u.getUserDictionaryID()));
        }

        
    }

    /**
     * @author cade
     * @return
     * 
     * making this function to generate the progress screen for the scenario 10/25
     * needs to show language progress, current lesson, and words that the user needs to work on
     */
    public HashMap<String,Double> getProgressInfo() {
        if(this.user == null) {
            System.out.println("No current user in LanguageGame.");
            return null;
        }
        HashMap<String,Double> progress = new HashMap<>();
        if(this.user.getCurrentLanguage() != null) {
            progress.put("Current Language Progress", this.user.getCurrentLanguage().getProgress());
            //for(Section s : this.user.getCurrentLanguage().get
        }
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

    /**
     * @author Wade Little
     * Sets the language games current language as well as the languagemanagers
     * @param language THe language you want to work on
     */
    public void setCurrentLanguage(Language language) {
        this.currentLanguage = language;
        languageManager.setCurrentLangauge(language);
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
    /**
     * @author Wade Little
     * Saves the users and sets the user to null
     */
    public void logout() {
        this.userList.saveUsers();
        // set current user to null
        this.user = null;
        System.out.println("Successfully logged out");
    }

    public Dictionary getLanguageDictionary(String languageUUID) {
        return languageManager.getLanguageByID(UUID.fromString(languageUUID)).getDictionary();
    }

    public ArrayList<Language> getAllLanguages() {
        return languageManager.getLanguages();
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

    /**
     * Sets the user answer
     * @param userAnswer
     */
    public void setUserAnswer(Word userAnswer) {
        this.userAnswer = userAnswer;
    }

    public Word getUserAnswer() {
        return this.userAnswer;
    }

    /**
     * @author Wade Little
     * Sets the current question and goes through the process of getting user input as well as updating the data of the word and the correct answer.
     */
    public void answerQuestionInSpanish() {
        Question currentQuestion = languageManager.getCurrentLesson().getQuestion();
        System.out.println(currentQuestion.toString());
        // can replace with a print method in this class or another
        Scanner keyboard = new Scanner(System.in);
        String userInput = keyboard.nextLine().trim();

        // changed to getWordByString - cade
        currentQuestion.setUserAnswer(userDictionary.getWordByString(userInput));
        currentQuestion.getCorrectAnswer().wordPresented(currentQuestion.isCorrect());
    }

    public User getUser() {
        return user;
    }

    public LanguageManager getLanguageManager() {
        return this.languageManager;
    }

/**
 * @author Wade Little
 * This class runs itemshop.displayItemShop() to view the item shop.
 */
    public void checkItemShop() {
        itemShop.displayItemShop();;
    }

    public void pickALanguage(Language language) {
        user.currentLanguage = language;
    }

    public void pickASection(Section section) {
        user.currentSection = section;
    }
    public void pickALesson(Lesson lesson) {
        user.currentLesson = lesson;
    }



}
