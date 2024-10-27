package lingo_quest;

import java.util.ArrayList;

abstract class Question {
  protected String language;
  protected String userAnswer;
  protected Word correctAnswer;

  public Question(String language) {
    this.language = language;
  }

  public abstract boolean isCorrect(User user);

  public abstract String toString();

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

<<<<<<< HEAD

  public Question(String language) {
    if(language == null)
      this.language = "Spanish";
    else
      this.language = language;
  }

  public abstract boolean isCorrect(User user);

  public abstract String toString();
   
=======
>>>>>>> db21abb0812c7f447acaaa10f9ad40d3ff824548
}
