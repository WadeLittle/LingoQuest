package code;

import java.util.ArrayList;
import java.util.HashMap;

public class Language {
    private User user;
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

    public void setTotalPoints(int points) {
        
    }

    public int getTotalPoints() {
        
        return 0;
    }

    public double getProgress() {
        
        return 0.0;
    }

    public Languages getLanguageName() {
        
        return null;
    }

    public void increaseAnswerStreak() {
        
    }

    public void resetAnswerStreak() {
        
    }

    public int getAnswerStreak() {
        
        return 0;
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
