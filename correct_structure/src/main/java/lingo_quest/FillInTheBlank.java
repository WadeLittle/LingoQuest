package lingo_quest;

import java.io.File;
import java.util.ArrayList;

public class FillInTheBlank extends Question{
    /**
     * @author Wade Little
     * Uses the super constructor to create a fill in the blank question
     */
    public FillInTheBlank() {
        super();
    }
    
    /**
     * @author Wade Little
     * Created the paramaterized constructor based off the Super Class Question
     * @param pointValue The point value of the question
     * @param coinValue THe coin value of the question
     * @param question The String of the question
     * @param answerChoices The array list of answer Choices
     * @param correctAnswer The correct answer to the question
     * @param media The media associated to the question
     */
    public FillInTheBlank(int pointValue, int coinValue, String question, ArrayList<Word> answerChoices, Word correctAnswer, File media) {
        super(pointValue, coinValue, question, answerChoices, correctAnswer, media);
    }
}
