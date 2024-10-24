package lingo_quest;

import java.util.ArrayList;
import java.util.UUID;

public class Section {
    private ArrayList<Lesson> lessons;
  //  private boolean userAccess;
    private double sectionProgress;
    private int pointsEarned;
    private int totalPoints;
    private int coinValue;
   // private boolean sectionComplete;
    private UUID ID;
  //  private int pointRequirement;

    // Constructors
    public Section() {
        lessons = new ArrayList<Lesson>();
        userAccess = false;
        sectionProgress = 0;
        pointsEarned = 0;
        totalPoints = 0;
        coinValue = 0;
        sectionComplete = false;
    }

    public Section(ArrayList<Lesson> lessons, UUID ID) {
        this.lessons = lessons;
        this.sectionProgress = getSectionProgress();
        this.pointsEarned = getPointsEarned();
        this.totalPoints = getTotalPoints();
        this.coinValue = 1000;
        this.ID = ID; 
        
    }
    public int getTotalPoints() {
        int totalPoints = 0;
        for(Lesson lesson:lessons) {
            totalPoints += lesson.getTotalPoints();
        }
        return totalPoints;
    }

    public int getPointsEarned() {
        int pointsEarned = 0;
        for(Lesson lesson: lessons) {
            pointsEarned += lesson.getPointsEarned();
        }
        return pointsEarned;
    }

    public void setSectionProgress() {
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

    public Lesson getLesson(Lesson lesson) {        
        return lesson;
    }

    public ArrayList<Lesson> getAllLessons() {
       
        return null;
    }

    public ArrayList<Lesson> getAvailableLessons() {
        
        return null;
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

    private void awardForCompletion(User user) {
        
    }

    public void setSectionComplete(boolean complete) {
        this.sectionComplete = complete;
    }


}

