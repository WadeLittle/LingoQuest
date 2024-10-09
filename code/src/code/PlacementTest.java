package code;

import java.util.ArrayList;

public class PlacementTest {
    private ArrayList<Question> questions;
    private int correctAnswers;
    private int score;

    public PlacementTest() {

    }

    /**
     * @author CADE STOCKER
     * @return the score of the placement test
     */
    public int getScore() {
        return this.score;
    }

    public ArrayList<Question> getQuestions() {

        return questions;
    }

    public int getCorrectAnswers() {
        
        return correctAnswers;
    }

}
