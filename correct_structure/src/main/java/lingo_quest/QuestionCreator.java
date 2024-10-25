package lingo_quest;

import java.util.ArrayList;

public class QuestionCreator {

    
    private ArrayList<Word> wordsInLesson;

    // Constructor to initialize DictionaryManager
    public QuestionCreator(ArrayList<Word> wordsInLesson) {
        this.wordsInLesson = wordsInLesson;
    }
    
    public Question createQuestion(Word word) {
        // Retrieve a word from the dictionary to use in the question
        int wordPoint = word.getPoints();
        if (wordPoint <= 0) {
            return new TrueOrFalse(word, null, null);
        } else if (wordPoint == 100) {
            return new MultipleChoice(anotherWord, null, null);
        } else if (wordPoint >= 200) {
            return new FillInTheBlank(anotherWord, null);
        } else if (wordPoint >= 300) {
            return new Matching(null);
        }
        throw new IllegalArgumentException("Invalid wordPoint value");
    }
}