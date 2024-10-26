package lingo_quest;


import java.util.ArrayList;

abstract class Question {
  protected String language;
  protected String userAnswer;
  protected Word correctAnswer;
  
  
  /**
   * @author cade
   * @return the user's answer
   */
  public Word getUserAnswer() {
    return this.userAnswer;
  }

  /**
   * @author cade
   * @return the correct answer
   */
  public Word getCorrectAnswer() {
    return this.correctAnswer;
  }

  /**
   * @author cade
   * @param w word
   */
  public void setCorrectAnswer(Word w) {
    if(w != null)
      this.correctAnswer = w;
  }

  /**
   * @author
   * @param w word
   */
  public void setUserAnswer(String userAnswer) {
      this.userAnswer = userAnswer;
  }


  public Question(String language) {
    this.language = language;
  }

  public abstract boolean isCorrect(User user);

  public abstract String toString();
   
}


