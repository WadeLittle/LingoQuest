package lingoQuest_package;

import java.util.ArrayList;

class LanguageGame {
    private Users userList;
    private User user;
    private ItemShop itemShop;
    private Dictionary userDictionary;
    private Language currentLanguage;
    private LanguageManager languageManager;
    private Leaderboard leaderboard;
    private Section currentSection;
    private Lesson currentLesson;
    private Word userAnswer;

    public void getItemInformation() {
    }

    public void setCurrentLanguage(Language language) {
    }

    public void login(String username, String password) {
    }

    public void logout() {
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

    public double getLessonProgress(Lesson lesson) {
        return 0.0;
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

    public ArrayList<String> checkItemShop() {
        return null;
    }
}
