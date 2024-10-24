package lingo_quest;

import java.io.File;
import java.util.ArrayList;

public class MultipleChoice extends Question  {
    private String language;
    private ArrayList<Word> answerChoices;
    private Word correctAnswer;
    private int coinValue; 
    private int pointValue;

    public MultipleChoice(String language, ArrayList<Word> answerChoices, Word correctAnswer) {
        super(language);
        this.answerChoices = answerChoices;
        this.correctAnswer = correctAnswer;
        coinValue = 100;
        pointValue = 100;
    }

    /**
     * @author Wade Little
     * Gives  the question as well as the answer choices
     * @return The string value of the Question and its answer choices in an easy to read format 
     */
    public String toString() {
        StringBuilder result = new StringBuilder("The " + language + " word for " + correctAnswer.getEnglishVersion() + " is _______" + "\nPlease select your answer choice:\n");
        for(int i = 0; i < answerChoices.size();i++) {
            result.append(i+1).append(". ").append(answerChoices.get(i).getWordinLanguage()).append("\n");
        }
        return result.toString();
    }
}