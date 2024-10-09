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
