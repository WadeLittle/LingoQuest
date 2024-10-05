package code;

import java.io.File;
import java.util.ArrayList;

public class Question {
    
    private int pointValue;
    private int coinValue;
    private String question;
    private ArrayList<Word> answerChoices;
    private Word correctAnswer;
    private Word userAnswer;
    private File media;

    public void updateWord(Word word) {

    }

    public void increasePointValue() {

    }
    public void displayMedia() {

    }

    public String getQuestion(String questionType) {

        return "";
    }

    public ArrayList<Word> getAnswerChoices() {

        return answerChoices;
    }

    public Word getCorrectAnswer() {

        return correctAnswer;
    }

    public void setQuestion(String Question) {

    }

    public void setAnswerChoices(ArrayList<Word> choices) {

    }

    public void setCorrectAnswer(Word answer) {

    }

    public void setUserAnswer(Word userAnswer) {

    }

    public boolean isCorrect() {

        return true;
    }

    public String toString() {
        
        return "";
    }
}
