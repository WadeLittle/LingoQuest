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

  public boolean isCorrect() {
    // if the string of "correct answer" and the string of "user answer" match
    if(this.correctAnswer.getWordinLanguage().equalsIgnoreCase(this.userAnswer.getWordinLanguage()))
      return true;
    else
      return false;
  }

  public abstract String toString();
   
}


