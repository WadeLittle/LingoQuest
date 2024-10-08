package code;

import java.util.ArrayList;
import java.util.HashMap;

public class Language {
    private User user;
    private String UUID;
    private PlacementTest placementTest;
    private int pointsEarned;
    private int totalPoints;
    private double progress;
    private int placementScore;
    private ArrayList<Section> sections;
    private Dictionary dictionary;
    private int answerStreak;
    private Languages languageName;
    private ArrayList<Section> sectionsComplete;
    private HashMap<Section, Boolean> sectionAccess;

    // Constructors
    public Language() {
        
    }

    public Language(User user) {
        this.user = user;
        
    }

    // Methods
    public boolean hasAccessToSection(Section section) {
        
        return false;
    }

    /**
     * @author Cade Stocker
     * @param UUID that will be added to the language
     * UUID will be used to access the user who owns this object of language
     * UUID should be used to find the user in the Users class
     */
    public void setUUID(String UUID) {
        this.UUID = UUID;
    }

    public void setTotalPoints(int points) {
        if(points >= 0)
            this.totalPoints = points;
    }

    public int getTotalPoints() {
        return this.totalPoints;
    }

    public double getProgress() {
        return this.progress;
    }

    public Languages getLanguageName() {
        return this.languageName;
    }

    public void increaseAnswerStreak() {
        this.answerStreak++;
    }

    public void resetAnswerStreak() {
        this.answerStreak = 0;
    }

    /**
     * @author Cade Stocker
     * @return the current answer streak of the user
     */
    public int getAnswerStreak() {
        return this.answerStreak;
    }

    public void updateProgress(int pointsEarned) {
    
    }

    public ArrayList<Section> getSectionsComplete() {
        return this.sectionsComplete;
    }

    // Private method??
    private void setSectionsComplete() {
        
    }

    public boolean takenPlacementTest() {
        
        return false;
    }

    public ArrayList<Lesson> getAvailableLessons() {
        
        return null;
    }

    public ArrayList<Section> getAvailableSections() {
        
        return null;
    }
}
