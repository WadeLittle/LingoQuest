package code;

import java.util.ArrayList;
import java.util.UUID;

public class Section {
    private ArrayList<Lesson> lessons;
    private boolean userAccess;
    private double sectionProgress;
    private int pointsEarned;
    private int totalPoints;
    private int coinValue;
    private boolean sectionComplete;
    private UUID ID;

    // Constructors
    public Section() {
        lessons = new ArrayList<Lesson>();
        userAccess = false;
        sectionProgress = 0;
        pointsEarned = 0;
        totalPoints = 1000;
        coinValue = 1000;
        sectionComplete = false;
    }

    public Section(ArrayList<Lesson> lessons, int coinValue) {
        this.lessons = lessons;
        this.coinValue = coinValue;
        
    }

 
    public double getSectionProgress() {
        return this.sectionProgress;
    }
   
    public int getPointsEarned() {
        return this.pointsEarned;
    }

    public int getTotalPoints() {
        return this.totalPoints;
    }

    public boolean getUserAccess() {
        return this.userAccess;
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

    // Private Methods
    // Do these need to be private? (are they called from within the class?) - cade
    private void setSectionProgress(double progress) {
        this.sectionProgress = progress;
    }

    private void setPointsEarned(int pointsEarned) {
        this.pointsEarned = pointsEarned;
    }

    private void setTotalPoints(int totalPoints) {
        this.totalPoints = totalPoints;
    }

    private void setUserAccess(boolean userAccess) {
        this.userAccess = userAccess;
    }

    private void awardForCompletion(User user) {
        
    }

    private void setSectionComplete() {
        this.sectionComplete = true;
    }


}
