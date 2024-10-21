package lingo_quest;

import java.io.File;
import java.util.ArrayList;

public class MultipleChoice extends Question {
    
    /**
     * @author Wade Little
     * Created the constructor that calls on the Questions super constructor
     */
    public MultipleChoice() {
        super();
    }

    
    public MultipleChoice(int pointValue, int coinValue, String question, ArrayList<Word> answerChoices, Word correctAnswer, File media) {
        super(pointValue, coinValue, question, answerChoices, correctAnswer, media);
    }
}