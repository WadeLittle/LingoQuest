package code;

public class Word {
   private int timesPresented;
   private String word;
   private int timesCorrect;
   private double userUnderstanding;
   
   public Word() {

   }

   public Word(String word) {

   }

   public void setWord(String word) {

   }

   public String toString() {

    return " ";
   }

   public int getTimesPresented() {

    return 0;
   }

   public int getTimesCorrect() {

    return 0;
   }

   public double getUserUnderstanding() {

    return 0;
   }

   public void wordPresented(boolean correct) {

   }

   private void updateTimesCorrect() {

   }

   private void updateTimesPresented() {

   }

   private void updateUserUnderstanding() {

   }

   /**
    * @author Cade Stocker 
    * @return the string of the word
    */
   public String getWord() {
      return this.word;
   }

   /**
    * @author Cade Stocker
    * @param word
    * @return boolean of whether or not the two words are the same
    * Method is needed because the '==' operator will just compare the addresses of two words regardless of uppercase or lowercase
    */
   public boolean isEqualTo(Word word) {
      return word.getWord().equalsIgnoreCase(this.word);
   }


}
