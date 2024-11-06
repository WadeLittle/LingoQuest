package lingo_quest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Random;
/**
 * Represents a matching question where the user is asked to match a word with its translation or definition.
 * This class extends the abstract Question class and implements specific behaviors for matching questions.
 */
public class Matching extends Question {
    String language;
    ArrayList<Word> words;
    int answerIndex;
    /**
     * Constructs a Matching question with a specific language and a list of possible answer choices.
     * 
     * @param language The language for which the question is being created.
     * @param answerChoices A list of Word objects that are the possible choices for the question.
     */

    public Matching(String language, ArrayList<Word> answerChoices) {
        super(language);
        this.words = answerChoices;
        this.generateQuestion();
    }
    /**
     * Generates a random index to select the correct answer from the list of words, simulating the selection of a word to be matched.
     */
    void generateQuestion() {
        Random r = new Random();
        this.answerIndex = r.nextInt(words.size());
    }
    /**
     * Checks if the answer provided by the user is correct based on the index they selected.
     * 
     * @param i The index of the word chosen by the user, adjusted to be zero-based.
     * @param user The user object to which the game progress is attributed.
     * @return true if the selected word is the correct answer, false otherwise.
     */
    public boolean isCorrect(int i, User user) {
       boolean isCorrect = answerIndex == (i-1);
       if(isCorrect) {
        user.getUserDictionary().getWordByUUID(words.get(answerIndex).getWordUUID()).wordPresented(true);
        System.out.println("You are Correct");
       } else {
        user.getUserDictionary().getWordByUUID(words.get(answerIndex).getWordUUID()).wordPresented(false);
        System.out.println("You are incorrect");
       }
       return isCorrect;
    }
    /**
     * Provides a formatted string representing the question and its choices.
     * 
     * @return A string that lists the word to match along with all possible choices.
     */
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("Match the English word " + words.get(answerIndex).getEnglishVersion() + " to one of the following words\n");
        for(int i = 0; i < words.size();i++) {
            result.append(i+1).append(". ").append(words.get(i).getWordinLanguage()).append("\n");
        }
        //Collections.shuffle(words);
        /*for(int i = 0; i < words.size();i++) {
            //result.append(i+5).append(". ").append(words.get(i).getEnglishVersion()).append("\n");
            
        }*/
        return result.toString();
    }
    /**
     * This method is supposed to determine the correctness of the user's overall interaction in a more complex scenario.
     * It is currently overridden to always return true, but should ideally contain logic to verify user answers.
     * 
     * @param user The user object to which the game progress is attributed.
     * @return Always returns true in the current implementation.
     */
    @Override
    public boolean isCorrect(User user) {
        /*try {
            int userAnswerIndex = Integer.parseInt(userAnswer.trim());
            boolean isCorrect = (userAnswerIndex == correctAnswerIndex);

            user.getUserDictionary().getWordByUUID(correctAnswer.getWordUUID()).wordPresented(isCorrect);
            return isCorrect;
        } catch (NumberFormatException e) {
            // Handle invalid user input
            user.getUserDictionary().getWordByUUID(correctAnswer.getWordUUID()).wordPresented(false);
            return false;
        }*/
        return true;
    }
}
