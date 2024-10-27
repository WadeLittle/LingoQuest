package lingo_quest;

import java.util.ArrayList;
import java.util.Random;

public class TrueOrFalse extends Question {
    private String language;
    private Word aWord;
    private Word anotherWord;
    private String answer;
    private Word correctWord;
    private int coinValue;
    private int pointValue;
    public String userAnswer;
    public TrueOrFalse(String language, Word aWord, Word anotherWord ) {
       super(language);
        this.aWord = aWord;
        this.anotherWord = anotherWord;
        answer = "";
        coinValue = 100;
        pointValue = 100;

        Random rand = new Random();
        if(rand.nextBoolean()) {
            this.answer = "true";
            this.correctWord = aWord;
        } else {
            this.answer = "false";
            this.correctWord = anotherWord;
        }
    }
    public void setUserAnswer(String userAnswer) {
        this.userAnswer = userAnswer;
    }

    public String toString() {
    return "Is " + correctWord.getWordinLanguage() + " the " + language + " word for " + correctWord.getEnglishVersion() + "?";

    }
    

    public boolean isCorrect(User user) {
        if (userAnswer != null && userAnswer.toLowerCase().trim().equals(answer)) {
            user.getUserDictionary().getWordByUUID(correctWord.getWordUUID()).wordPresented(true);
            return true;
        } else {
            user.getUserDictionary().getWordByUUID(correctWord.getWordUUID()).wordPresented(false);
            return false;
        }
    }
}
