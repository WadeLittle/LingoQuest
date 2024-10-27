package lingo_quest;

import java.io.File;
import java.util.ArrayList;

public class FillInTheBlank extends Question{
    private String language;
    private Word correctAnswer;
    private int coinValue;
    private int pointValue;
    public String userAnswer;
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
    public void setUserAnswer(String userAnswer) {
        this.userAnswer = userAnswer;
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
    public boolean isCorrect( User user) {
        if(userAnswer.toLowerCase().trim().equals(correctAnswer.getWordinLanguage().toLowerCase().trim())) {
          user.getUserDictionary().getWordByUUID(correctAnswer.getWordUUID()).wordPresented(true);
            return true;
        } else {
            user.getUserDictionary().getWordByUUID(correctAnswer.getWordUUID()).wordPresented(false);
            return false;
        }
    }
}

