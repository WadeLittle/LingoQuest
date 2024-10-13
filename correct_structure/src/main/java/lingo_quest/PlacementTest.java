package lingo_quest;

import java.util.ArrayList;
import java.util.UUID;

public class PlacementTest {
    private UUID testID;
    private ArrayList<Question> questions;
    private int correctAnswers;
    private int score;
    private boolean taken;

    /**
     * @author CADE STOCKER
     * default constructor for PlacementTest
     */
    public PlacementTest() {
        this.questions = new ArrayList<Question>();
        this.taken = false;
        // If the test was just created, then it has not been taken yet.
    }

    public void setID(UUID id) {
        this.testID = id;
    }

    /**
     * @author CADE STOCKER
     * @return the score of the placement test
     */
    public int getScore() {
        return this.score;
    }

    /**
     * @author CADE STOCKER
     * @return whether or not the placement test has been taken
     */
    public boolean getTaken() {
        return this.taken;
    }

    /**
     * @author Cade Stocker
     * @return ArrayList of questions
     * I left an issue on our scrum board asking how we will handle
     * questions being generated for the placement test #223
     */
    public ArrayList<Question> getQuestions() {
        return this.questions;
    }

    public int getCorrectAnswers() {
        
        return correctAnswers;
    }

}

