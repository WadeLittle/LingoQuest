package lingo_quest;

import java.util.ArrayList;

public class Lesson {
    private int pointsEarned;
    private int totalPoints;
    private int coinValue;
    private double lessonProgress;
    private Dictionary topicDictionary;
    private ArrayList<Question> questions;

    public Lesson() {

    }

    public void updateProgress() {
        this.lessonProgress = this.pointsEarned/this.totalPoints;
    }

    public Lesson(int coinValue, int totalPoints) {

    }

    public void awardForCompletion(User user) {

    }
    /**
     * @author Wade Little
     * Gets the question at the specified question number from the questions list
     * @param questionNum The question number you want to get
     * @return A question
     */
    public Question getQuestion(int questionNum) {

        return questions.get(questionNum);
    }

    public void halfwayCompleteReward() {

    }

    /**
     * @author cade stocker
     * @return lesson's coin value
     */
    public int getCoinValue() {
        return this.coinValue;
    }

    /**
     * @author cade
     * @param points
     */
    public void setPointsEarned(int points) {
        this.pointsEarned = points;
        this.updateProgress();
    }

    /**
     * @author cade stocker
     * @param points
     */
    public void setTotalPoints(int points) {
        this.totalPoints = points;
        this.updateProgress();
    }

    /**
     * @author cade stocker
     * @return the total points you can earn in the lesson
     */
    public int getTotalPoints() {
        return this.totalPoints;
    }

    /**
     * set the lesson's progress
     * @param progress
     */
    public void setLessonProgress(double progress) {
        this.lessonProgress = progress;
    }

    /**
     * @author cade stocker
     * @return the lesson progress
     */
    public double getLessonProgress(){
        this.updateProgress();
        return this.lessonProgress;
    }
}

