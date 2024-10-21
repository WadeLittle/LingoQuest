package lingo_quest;

import java.io.File;
import java.util.ArrayList;

/**
 * The Question class represents a question with point and coin values, answer choices,
 * and optional media content. It allows users to select an answer and check if their answer is correct.
 * It also supports displaying media and updating words in the question or answer choices.
 */
public class Question {

    private int pointValue;
    private int coinValue;
    private String question;
    private ArrayList<Word> answerChoices;
    private Word correctAnswer;
    private Word userAnswer;
    private File media;

    /**
     * Default constructor that initializes a question with default values.
     * Point and coin values are set to 0, the question text is empty, and answer choices,
     * correct answer, and user answer are set to null.
     * @author Preston Willis
     */
    public Question() {
        this.pointValue = 0;
        this.coinValue = 0;
        this.question = "";
        this.answerChoices = new ArrayList<>();
        this.correctAnswer = null;
        this.userAnswer = null;
        this.media = null;
    }

    /**
     * Constructor that initializes a question with specified parameters.
     * 
     * @param pointValue The point value for answering the question correctly.
     * @param coinValue The coin value for answering the question correctly.
     * @param question The question text.
     * @param answerChoices A list of Word objects representing the possible answer choices.
     * @param correctAnswer The correct answer to the question.
     * @param media A File object representing the associated media (e.g., image, audio, video).
     * @author Preston Willis
     */
    public Question(int pointValue, int coinValue, String question, ArrayList<Word> answerChoices, Word correctAnswer, File media) {
        this.pointValue = pointValue;
        this.coinValue = coinValue;
        this.question = question;
        this.answerChoices = answerChoices;
        this.correctAnswer = correctAnswer;
        this.userAnswer = null;
        this.media = media;
    }

    /**
     * @author Wade Little
     * Updates the words values based on if the user is correct
     * @param word The Word object that should be updated.
     */
    public void updateWord(Word word) {
        this.correctAnswer.wordPresented(isCorrect());
    }
    /**
     * @author Wade Little
     * Adds the coins to the users balance
     */
    public void addCoinValue() {
        this.user.addCoins(coinValue);
    }

    /**
     * Increases the point value of the question by 1.
     * @author Preston Willis
     */
    public void increasePointValue() {
        this.pointValue += 1;
    }

    /**
     * Displays the media associated with the question, if applicable.
     * Prints the name of the media file if it exists, otherwise indicates that no media is associated.
     * @author Preston Willis
     */
    public void displayMedia() {
        if (media != null) {
            System.out.println("Displaying media: " + media.getName());
        } else {
            System.out.println("No media associated with this question.");
        }
    }

    /**
     * Retrieves the question text.
     *
     * @return The question text as a String.
     * @author Preston Willis
     */
    public String getQuestion() {
        return this.question;
    }

    /**
     * Retrieves the list of answer choices.
     *
     * @return An ArrayList of Word objects representing the answer choices.
     * @author Preston Willis
     */
    public ArrayList<Word> getAnswerChoices() {
        return answerChoices;
    }

    /**
     * Retrieves the correct answer for the question.
     *
     * @return A Word object representing the correct answer.
     * @author Preston Willis
     */
    public Word getCorrectAnswer() {
        return correctAnswer;
    }

    /**
     * Sets a new question text.
     *
     * @param question The new question text to set.
     * @author Preston Willis
     */
    public void setQuestion(String question) {
        this.question = question;
    }

    /**
     * Sets a new list of answer choices.
     *
     * @param choices An ArrayList of Word objects representing the new answer choices.
     * @author Preston Willis
     */
    public void setAnswerChoices(ArrayList<Word> choices) {
        this.answerChoices = choices;
    }

    /**
     * Sets a new correct answer for the question.
     *
     * @param answer A Word object representing the new correct answer.
     * @author Preston Willis
     */
    public void setCorrectAnswer(Word answer) {
        this.correctAnswer = answer;
    }

    /**
     * Sets the user's selected answer for the question.
     *
     * @param userAnswer A Word object representing the user's selected answer.
     * @author Preston Willis
     */
    public void setUserAnswer(Word userAnswer) {
        this.userAnswer = userAnswer;
    }

    /**
     * Checks whether the user's selected answer is correct.
     * @author Preston Willis
     *
     * @return true if the user's answer is correct, false otherwise.
     */
    public boolean isCorrect() {
        if (userAnswer != null) {
            return userAnswer.equals(correctAnswer);
        }
        return false;
    }

    /**
     * Returns a string representation of the question object, including the question text,
     * point value, coin value, answer choices, correct answer, user answer, and media.
     * @author Preston Willis
     *
     * @return A formatted string representing the question.
     */
    public String toString() {
        return "Question: " + question + "\n" +
                "Point Value: " + pointValue + "\n" +
                "Coin Value: " + coinValue + "\n" +
                "Answer Choices: " + answerChoices + "\n" +
                "Correct Answer: " + correctAnswer + "\n" +
                "User Answer: " + (userAnswer != null ? userAnswer : "Not answered yet") + "\n" +
                "Media: " + (media != null ? media.getName() : "No media") + "\n";
    }

    /**
     * Retrieves the user's selected answer.
     *
     * @return A Word object representing the user's answer.
     */
    public Word getUserAnswer() {
        return this.userAnswer;
    }

    /**
     * Retrieves the point value of the question.
     *
     * @return The point value as an integer.
     */
    public int getPointValue() {
        return this.pointValue;
    }

    /**
     * Retrieves the coin value of the question.
     *      *
     * @return The coin value as an integer.
     */
    public int getCoinValue() {
        return this.coinValue;
    }
}


