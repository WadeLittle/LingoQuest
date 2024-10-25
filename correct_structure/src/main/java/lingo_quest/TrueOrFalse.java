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
    }
    public void setUserAnswer(String userAnswer) {
        this.userAnswer = userAnswer;
    }

    public String toString() {
    StringBuilder result = new StringBuilder();
    Random rand = new Random();  
    boolean chooseFirstWord = rand.nextBoolean(); 

    if (chooseFirstWord) {
        result.append("Is " + aWord.getWordinLanguage() + " the " + language + " word for " + aWord.getEnglishVersion() + "?");
        answer = "true";
        correctWord = aWord;
    } else {
        result.append("Is " + anotherWord.getWordinLanguage() + " the " + language + " word for " + anotherWord.getEnglishVersion() + "?");
        answer = "false";
        correctWord = anotherWord;
    }
    
    return result.toString();
    }

    public boolean isCorrect( User user) {
        if(userAnswer.toLowerCase().trim().equals(answer)) {
          user.getUserDictionary().getWordByUUID(correctWord.getWordUUID()).wordPresented(true);
            return true;
        } else {
            user.getUserDictionary().getWordByUUID(correctWord.getWordUUID()).wordPresented(false);
            return false;
        }
    }
}
