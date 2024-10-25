package lingo_quest;

import java.util.ArrayList;
import java.util.UUID;

public class Section {
    private ArrayList<Lesson> lessons;
    private boolean userAccess;
    private double sectionProgress;
    private int pointsEarned;
    private int totalPoints;
    private int coinValue;
    private String sectionName;
    private boolean sectionComplete;
    private UUID ID;
    private int pointRequirement;

    // Constructors
    public Section() {
        lessons = new ArrayList<Lesson>();
        //userAccess = false;
        sectionProgress = 0;
        pointsEarned = 0;
        totalPoints = 0;
        coinValue = 0;
        //sectionComplete = false;
    }

    public Section(String sectionName, UUID sectionUUID, ArrayList<Lesson> lessons) {
        this.sectionName = sectionName;
        this.lessons = lessons;
        this.ID = sectionUUID;
        this.sectionProgress = getSectionProgress();
        this.pointsEarned = getPointsEarned();
        this.totalPoints = getTotalPoints();
        this.coinValue = 1000;
    }
    public int getTotalPoints() {
        int totalPoints = 0;
        for(Lesson lesson:lessons) {
            totalPoints += lesson.getTotalPoints();
        }
        return totalPoints;
    }

    /**
     * @author cade
     * @param n
     */
    public void setName(String n) {
        this.sectionName = n;
    }

    /**
     * @author cade
     * @return the sectionName
     */
    public String getName() {
        return this.sectionName;
    }

    public int getPointsEarned() {
        int pointsEarned = 0;
        for(Lesson lesson: lessons) {
            pointsEarned += lesson.getPointsEarned();
        }
        return pointsEarned;
    }

    /**
     * changed to be called updateSectionProgress
     */
    public void updateSectionProgress() {
        this.sectionProgress = getSectionProgress();
    }


 
    public double getSectionProgress() {
        int totalPoints = 0;
        int earnedPoints = 0;
        for(Lesson lesson : lessons) {
           totalPoints += lesson.getTotalPoints();
           earnedPoints += lesson.getPointsEarned();
        }
        return (earnedPoints/totalPoints) * 100;
    }

    /**
     * @author cade
     * @param int of coin balance
     */
    public void setCoinValue(int cb) {
        this.coinValue = cb;
    }

    /**
     * @author cade
     * @return the coin value
     */
    public int getCoinValue() {
        return this.coinValue;
    }


    public boolean getUserAccess() {
        return this.userAccess;
    }

    /**
     * @author cade
     * @param access
     */
    public void setUserAccess(boolean access) {
        this.userAccess = access;
    }

    public boolean userAccessRequirements(ArrayList<Section> sections) {
        
        return false;
    }

    public boolean getSectionComplete() {
        return this.sectionComplete;
    }

    // what is this method for? - cade
    public Lesson getLesson(Lesson lesson) {        
        return lesson;
    }

    /**
     * @author cade
     * @return the list of lessons
     */
    public ArrayList<Lesson> getAllLessons() {
        return this.lessons;
    }

    /**
     * @author cade
     * @param l
     */
    public void setLessons(ArrayList<Lesson> l) {
        if(l != null)
            this.lessons = l;
    }

    public ArrayList<Lesson> getAvailableLessons() {
        
        return null;
    }

    /**
     * @author cade
     * @param p
     */
    public void setSectionProgress(double p) {
        this.sectionProgress = p;
    }

    /**
     * @author Cade Stocker
     * @param id the UUID to be set
     * if the id needs to be a new UUID, the new UUID will be
     * created in another class and then sent here to be set.
     */
    public void setID(UUID id) {
        this.ID = id;
    }

    /**
     * @author Cade Stocker
     * @return the UUID of the section
     */
    public UUID getID() {
        return this.ID;
    }

    // Private Methods
    // Do these need to be private? (are they called from within the class?) - cade

    public void setPointsEarned(int pointsEarned) {
        this.pointsEarned = pointsEarned;
    }

    public void setTotalPoints(int totalPoints) {
        this.totalPoints = totalPoints;
    }

    public void awardForCompletion(User user) {
        
    }

    public void setSectionComplete(boolean complete) {
        this.sectionComplete = complete;
    }


}

