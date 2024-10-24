package lingo_quest;

import java.util.ArrayList;
import java.util.UUID;

public class Lesson {
    private UUID languageUUID;
    private int pointsEarned;
    private int totalPoints;
    private double lessonProgress;
    private ArrayList<Word> topicWords;
    private String lessonName;
    private UUID lessonUUID;
    public Question currentQuestion;

    public Lesson() {
        languageUUID = null;
        pointsEarned =0;
        totalPoints =0;
        lessonProgress = 0;
        topicWords = null;
        lessonName = "";
        lessonUUID = null;
    }

    public void updateProgress() {
         this.lessonProgress = this.pointsEarned/this.totalPoints;
    }

    public Lesson(UUID languageUUID, String lessonName, UUID lessonUUID) {
        this.languageUUID = languageUUID;
        pointsEarned = 0;
        totalPoints = getTotalPoints();
        lessonProgress = getLessonProgress();
        //MISSING TOPIC WORDS
        this.lessonName = lessonName;
        this.lessonUUID = lessonUUID;
    }

    public int getTotalPoints() {
        return topicWords.size() * 300; 
    }
    public int getPointsEarned() {
        return pointsEarned;
    }

    public void awardForCompletion(User user) {

    }
    public String getLanguageName() {
        return language.toString().toLowerCase();
    }
    /**
     * @author Wade Little
     * Gets the question at the specified question number from the questions list
     * @param questionNum The question number you want to get
     * @return A question
     */
    public Question getQuestion() {
        Question question = questions.get(questionNum);
        this.questionNum++;
        return question;
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

    /**
     * Creates a question from the list of words
     * @return
     */
    public Question createQuestion() {

    }
    /**
     * NOT SURE
     * @return
     */
    public String presentQuestion(Question question) {

    }
}

