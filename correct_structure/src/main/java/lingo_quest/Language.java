package lingo_quest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public class Language {
    private User user;
    private UUID languageID;
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

    /**
     * @author Cade Stocker
     * Default constructor for language
     * initializes all of the ArrayLists and HashMaps
     */
    public Language() {
        this.sections = new ArrayList<Section>();
        this.sectionsComplete = new ArrayList<Section>();
        this.sectionAccess = new HashMap<Section, Boolean>();
    }

    /**
     * Parameterized constructor for language
     * each language needs a user so that the user can make progress as they complete questions
     * @param user The user who is learning this language
     */
    public Language(User user) {
        // We need to decide how the language will be constructed when the user logs in
        // How will we recreate a language object with the JSON Data?
        this.sections = new ArrayList<Section>();
        this.sectionsComplete = new ArrayList<Section>();
        this.sectionAccess = new HashMap<Section, Boolean>();
        this.user = user;
    }

    // Methods

    /**
     * @author CADE STOCKER
     * @param section
     * @return whether or not the user has access to a specific section
     * sections should be locked based on points (a user must have accumulated a certain amount 
     * of points to gain access to a section)
     */
    public boolean hasAccessToSection(Section section) {
        return section.getUserAccess();
    }

    /**
     * @author Cade Stocker
     * @param UUID that will be added to the language
     * UUID will be used to access the user who owns this object of language
     * UUID should be used to find the user in the Users class
     */
    public void setUUID(UUID id) {
        this.languageID = id;
    }

    /**
     * @author Cade
     * @param points
     */
    public void setPointsEarned(int points) {
        this.pointsEarned = points;
    }

    /**
     * @author Cade Stocker
     * @return String of the Language's UUID
     * UUID is the unique identifier of this object of language
     */
    public UUID getUUID() {
        return this.languageID;
    }

    /**
     * 
     * @param points (total number of points possible in the language)
     */
    public void setTotalPoints(int points) {
        if(points >= 0)
            this.totalPoints = points;
    }

    /**
     * @author Cade Stocker
     * @return the total points held within the language
     */
    public int getTotalPoints() {
        return this.totalPoints;
    }

    /**
     * @author Cade Stocker
     * @return the progress the user has made in the language
     */
    public double getProgress() {
        this.updateProgress();
        return this.progress;
    }

    /**
     * @author Cade Stocker
     * @return the enumeration of language (the type of language being learned)
     */
    public Languages getLanguageName() {
        return this.languageName;
    }

    public void setPlacementTest(PlacementTest pt) {
        if(pt != null)
            this.placementTest = pt;
    }

    /**
     * @author Cade Stocker
     * increase the user's answer streak if they get a problem correct.
     */
    public void increaseAnswerStreak() {
        this.answerStreak++;
    }

    /**
     * @author Cade Stocker
     * Set the answer streak to 0 if the user gets a problem wrong.
     */
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

    /**
     * @author Cade Stocker
     * finds the current progress by dividing the points earned
     * by the total amount of points of the language
     */
    private void updateProgress() {
        this.progress = this.pointsEarned/this.totalPoints;
    }

    /**
     * @author Cade Stocker
     * @return the arraylist of sections that have been completed
     */
    public ArrayList<Section> getSectionsComplete() {
        return this.sectionsComplete;
    }

    /**
     * @author CADE STOCKER
     * goes through sections and adds them to completed if they need to be
     * Also returns if either of the lists hasn't been initialized.
     */
    public void setSectionsComplete() {
        if (this.sections == null || this.sectionsComplete == null) {
            return;
            //throw new IllegalStateException("Sections or sectionsComplete is not initialized.");
        }
        
        for (Section section : this.sections) {
            // If the section is complete and isnt in the completed list, add it to completed list
            if (section.getSectionComplete() && !this.sectionsComplete.contains(section)) {
                this.sectionsComplete.add(section);
            }
        }
    }

    /**
     * @author CADE STOCKER
     * @return whether or not the placement test has been taken.
     */
    public boolean takenPlacementTest() {
        return this.placementTest.getTaken();
    }

    public ArrayList<Lesson> getAvailableLessons() {
        
        return null;
    }

    public ArrayList<Section> getAvailableSections() {
        
        return null;
    }
}

