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

    /**
     * Created the paramaterized constructor based off of the Question super constructor
     * @param pointValue The point value of the question
     * @param coinValue The coin value of the question
     * @param question The Question as a String
     * @param answerChoices The arrayList of answer Choices
     * @param correctAnswer The correct answer
     * @param media The media for the question
     */
    public MultipleChoice(int pointValue, int coinValue, String question, ArrayList<Word> answerChoices, Word correctAnswer, File media) {
        super(pointValue, coinValue, question, answerChoices, correctAnswer, media);
    }
    /**
     * @author Wade Little
     * Gives  the question as well as the answer choices
     * @return The string value of the Question and its answer choices in an easy to read format 
     */
    public String toString() {
        StringBuilder result = new StringBuilder(this.getQuestion() + "\nPlease select your answer choice:\n");
        for(int i = 0; i < this.getAnswerChoices().size();i++) {
            result.append(i+1).append(". ").append(this.getAnswerChoices().get(i)).append("\n");
        }
        return result.toString();
    }
}