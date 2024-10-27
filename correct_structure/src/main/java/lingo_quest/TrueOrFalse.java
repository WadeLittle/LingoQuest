package lingo_quest;

import java.util.Random;

public class TrueOrFalse extends Question {
    private String language;
    private Word displayedWord;
    private String answer;
    private Word correctWord;
    private int coinValue = 100;
    private int pointValue = 100;
    public String userAnswer;

    public TrueOrFalse(String language, Word aWord, Word anotherWord) {
        super(language);
        this.language = language;

        Random rand = new Random();
        if (rand.nextBoolean()) {
            this.displayedWord = aWord;
            this.correctWord = aWord;
            this.answer = "true";
        } else {
            this.displayedWord = anotherWord;
            this.correctWord = aWord; // correct answer remains aWord
            this.answer = "false";
        }
    }

    public void setUserAnswer(String userAnswer) {
        this.userAnswer = userAnswer;
    }

    @Override
    public String toString() {
        return "Is " + displayedWord.getWordinLanguage() + " the " + language + " word for " + correctWord.getEnglishVersion() + "? (true/false)";
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
