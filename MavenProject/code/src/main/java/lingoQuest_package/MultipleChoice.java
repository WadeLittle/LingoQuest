package lingoQuest_package;

import java.util.ArrayList;

public class MultipleChoice extends Question {
    
    // Default constructor
    public MultipleChoice() {
        super();
    }
    
    // Constructor that accepts answer choices
    public MultipleChoice(ArrayList<Word> answerChoices, Word correctAnswer) {
        super();
        this.answerChoices = answerChoices;
    }
}
