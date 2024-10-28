package lingo_quest;

import java.util.ArrayList;

/**
 * Abstract base class for defining different types of questions in a language learning context.
 * This class provides a framework that includes language details, the user's answer, and the correct answer.
 */
abstract class Question {
    protected String language;     // The language associated with this question.
    protected String userAnswer;   // The answer provided by the user.
    protected Word correctAnswer;  // The correct answer to the question.

<<<<<<< HEAD
  public Question(String language) {
    if(language == null)
      this.language = "Spanish";
    else
      this.language = language;
  }

  /**
   * @author cade
   * @return the correct answer
   */
  public Word getCorrectAnswer() {
    return this.correctAnswer;
  }

  /**
   * @author
   * @param w word
   */
  public void setUserAnswer(String userAnswer) {
    this.userAnswer = userAnswer;
  }

=======
    /**
     * Constructor to initialize a Question with a specific language.
     *
     * @param language The language in which the question is presented.
     */
    public Question(String language) {
        this.language = language;
    }

    /**
     * Abstract method to determine if the user's answer is correct.
     *
     * @param user The user object that contains user-specific information which might influence the answer check.
     * @return true if the user's answer is correct, false otherwise.
     */
    public abstract boolean isCorrect(User user);

    /**
     * Abstract method to return a string representation of the question.
     *
     * @return A string that represents the question.
     */
    @Override
    public abstract String toString();

    /**
     * Retrieves the correct answer for the question.
     *
     * @return The Word object that represents the correct answer.
     */
    public Word getCorrectAnswer() {
        return this.correctAnswer;
    }

    /**
     * Sets the user's answer for the question.
     *
     * @param userAnswer The string answer provided by the user.
     */
    public void setUserAnswer(String userAnswer) {
        this.userAnswer = userAnswer;
    }
    
<<<<<<< HEAD

  public Question(String language) {
    if(language == null)
      this.language = "Spanish";
    else
      this.language = language;
  }

>>>>>>> f2065de5c43c6be5a1bbe898ec17631746a83b63
  public abstract boolean isCorrect(User user);

  public abstract String toString();
}
