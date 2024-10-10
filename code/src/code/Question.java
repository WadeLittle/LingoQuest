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

    // Constructor with basic attributes
    public Question() {
        this.pointValue = 0;
        this.coinValue = 0;
        this.question = "";
        this.answerChoices = new ArrayList<>();
        this.correctAnswer = null;
        this.userAnswer = null;
        this.media = null;
    }

    // Constructor with parameters
    public Question(int pointValue, int coinValue, String question, ArrayList<Word> answerChoices, Word correctAnswer, File media) {
        this.pointValue = pointValue;
        this.coinValue = coinValue;
        this.question = question;
        this.answerChoices = answerChoices;
        this.correctAnswer = correctAnswer;
        this.userAnswer = null;
        this.media = media;
    }

    // Method to update a word in the question or answer choices
    public void updateWord(Word word) {
        // ???
    }

    // Increases the point value of the question
    public void increasePointValue() {
        this.pointValue += 1;
    }

    // Displays media associated with the question (if applicable)
    public void displayMedia() {
        if (media != null) {
            System.out.println("Displaying media: " + media.getName());
        } else {
            System.out.println("No media associated with this question.");
        }
    }

    // Retrieves the question text based on the type (e.g., formatted or plain text)
    public String getQuestion(String questionType) {
        return this.question;
    }

    // Returns the list of answer choices
    public ArrayList<Word> getAnswerChoices() {
        return answerChoices;
    }

    // Returns the correct answer for the question
    public Word getCorrectAnswer() {
        return correctAnswer;
    }

    // Sets a new question
    public void setQuestion(String question) {
        this.question = question;
    }

    // Sets a new list of answer choices
    public void setAnswerChoices(ArrayList<Word> choices) {
        this.answerChoices = choices;
    }

    // Sets a new correct answer for the question
    public void setCorrectAnswer(Word answer) {
        this.correctAnswer = answer;
    }

    // Sets the user's answer for the question
    public void setUserAnswer(Word userAnswer) {
        this.userAnswer = userAnswer;
    }

    // Checks if the user's answer is correct
    public boolean isCorrect() {
        if (userAnswer != null) {
            return userAnswer.equals(correctAnswer);
        }
        return false;
    }

    // Provides a string representation of the question object
    public String toString() {
        return "Question: " + question + "\n" +
                "Point Value: " + pointValue + "\n" +
                "Coin Value: " + coinValue + "\n" +
                "Answer Choices: " + answerChoices + "\n" +
                "Correct Answer: " + correctAnswer + "\n" +
                "User Answer: " + (userAnswer != null ? userAnswer : "Not answered yet") + "\n" +
                "Media: " + (media != null ? media.getName() : "No media") + "\n";
    }
}

