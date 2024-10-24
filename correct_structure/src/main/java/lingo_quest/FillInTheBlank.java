package lingo_quest;

import java.io.File;
import java.util.ArrayList;

public class FillInTheBlank extends Question{
    private String language;
    private ArrayList<Word> answerChoices;
    private Word correctAnswer;
    private int coinValue;
    private int pointValue;
    /**
     * @author Wade Little
     * Uses the super constructor to create a fill in the blank question
     */
    public FillInTheBlank(String language,  Word correctAnswer) {
        super(language);
        this.correctAnswer = correctAnswer;
        coinValue = 100;
        pointValue = 100;
    }
    
    /* 
     * @author Wade Little
     * Concatanates the question and answer choices into an easy to read format
     * @return the question and its answer choices as a string
     */
    public String toString() {
        StringBuilder result = new StringBuilder("The " + language + " word for " + correctAnswer.getEnglishVersion() + " is ______" + "\nType your answer below\n");
        return result.toString();
    }
}

