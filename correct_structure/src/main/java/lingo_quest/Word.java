package lingo_quest;

import java.util.UUID;

/**
 * The {@code Word} class represents a word and tracks how many times it has
 * been presented and answered correctly by a user. It also calculates the
 * user's understanding based on their performance.
 * 
 * @author Alok Patel
 */
public class Word {
    private int timesPresented;
    private String word;
    private int timesCorrect;
    private double userUnderstanding;
    private Languages language;
    private String englishVersion;
    private UUID wordUUID;
    private UUID lessonUUID;

    /**
     * Default constructor that initializes the word and other fields to default
     * values.
     */
    public Word() {
        this.word = "";
        this.timesPresented = 0;
        this.timesCorrect = 0;
        this.userUnderstanding = 0.0;
        this.language = Languages.DEFAULT;
        this.englishVersion = "";
        this.wordUUID = UUID.randomUUID();
        this.lessonUUID = UUID.randomUUID();
    }

    /**
     * Constructor that initializes the word and sets other fields to default
     * values.
     * 
     * @param word the word to initialize
     */
    public Word(Languages language, String word, String englishVersion, UUID lessonUUID, UUID wordUUID) {
        this.language = language;
        this.word = word;
        this.englishVersion = englishVersion;
        this.timesPresented = 0;
        this.timesCorrect = 0;
        this.userUnderstanding = 0.0;
        this.lessonUUID = lessonUUID;
        this.wordUUID = wordUUID;
    }

    /**
     * Sets the word.
     * 
     * @param word the word to set
     */
    public void setWord(String word) {
        this.word = word;
    }

    /**
     * @author cade
     * @return englishWord
     */
    public String getEnglishVersion() {
        return this.englishVersion;
    }

    /**
     * @author
     * @param englishWord
     */
    public void setEnglishVersion(String englishWord) {
        this.englishVersion = englishWord;
    }

    /**
     * @author cade
     * @param times
     */
    public void setTimesPresented(int times) {
        this.timesPresented = times;
    }

    /**
     * @author cade
     * @param times
     */
    public void setTimesCorrect(int times) {
        this.timesCorrect = times;
    }

    /**
     * @author cade
     * @param understanding
     */
    public void setUserUnderstanding(double understanding) {
        this.userUnderstanding = understanding;
    }

    /**
     * Gets the number of times the word has been presented to the user.
     * 
     * @return the number of times the word has been presented
     */
    public int getTimesPresented() {
        return timesPresented;
    }

    /**
     * Gets the number of times the word has been answered correctly by the user.
     * 
     * @return the number of correct answers
     */
    public int getTimesCorrect() {
        return timesCorrect;
    }

    /**
     * Gets the user's understanding of the word based on their performance.
     * 
     * @return the user's understanding as a percentage
     */
    public double getUserUnderstanding() {
        return userUnderstanding;
    }

    /**
     * Updates the word's presentation status and whether the user answered it
     * correctly. Also updates the user's understanding.
     * 
     * @param correct a boolean indicating whether the user's response was correct
     */
    public void wordPresented(boolean correct) {
        updateTimesPresented(); // Increment times presented
        if (correct) {
            System.out.println("You are correct");
            updateTimesCorrect(); // Increment times correct if answered correctly
        } else {
            System.out.println("You are incorrect");
        }
        updateUserUnderstanding(); // Update user understanding
    }

    /**
     * Increments the count of how many times the word has been presented.
     */
    private void updateTimesPresented() {
        this.timesPresented++;
    }

    /**
     * Increments the count of how many times the word has been answered correctly.
     */
    private void updateTimesCorrect() {
        this.timesCorrect++;
    }

    /**
     * Updates the user's understanding of the word as a percentage of correct
     * answers over total presentations.
     */
    private void updateUserUnderstanding() {
        if (timesPresented > 0) {
            this.userUnderstanding = ((double) timesCorrect / timesPresented) * 100;
        } else {
            this.userUnderstanding = 0.0;
        }
    }

    /**
     * Returns a string representation of the word, showing how many times it was
     * presented, answered correctly, and the user's understanding.
     * 
     * @return a string with details of the word
     */
    @Override
    public String toString() {
        return "Word: " + word + ", Presented: " + timesPresented + ", Correct: " + timesCorrect + ", Understanding: " + userUnderstanding + "%";
    }

    /**
     * Gets the word as a string.
     * 
     * @return the word
     */
    public String getWord() {
        return this.word;
    }


    /**
     * Compares this word to another word, ignoring case.
     * 
     * @param otherWord the word to compare with
     * @return {@code true} if the words are equal (case-insensitive),
     *         {@code false} otherwise
     */
    public boolean isEqualTo(Word otherWord) {
        return this.word.equalsIgnoreCase(otherWord.getWord());
    }

    /**
     * @author CADE STOCKER
     * @return the language the word belongs to
     */
    public Languages getLanguage() {
        return this.language;
    }

    public void setLanguage(Languages language) {
        this.language = language;
    }

    /*public void toString() {
        System.out.println(this.word+ " "+this.timesCorrect+ " "+
        this.timesPresented+ " "+ this.userUnderstanding);
    }*/
}

