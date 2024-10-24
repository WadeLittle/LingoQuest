package lingo_quest;


import java.util.ArrayList;

abstract class Question {
    protected String language;
    

    public Question(String language) {
      this.language = language;
    }

    public abstract String toString();
   
}


