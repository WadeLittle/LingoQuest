package lingo_quest;

import java.util.ArrayList;

public class QuestionCreator {

    
    
    // Constructor to initialize DictionaryManager
    public QuestionCreator() {
    }
    
    public Question createQuestion(Lesson lesson) {
        Word word = lesson.getRandomWord();
        // Retrieve a word from the dictionary to use in the question
        int wordPoint = word.getPoints();
        if (wordPoint <= 0) {
            Word anotherWord = lesson.getRandomWord();
            return new TrueOrFalse(lesson.getLanguageName(), word, anotherWord);
        } else if (wordPoint == 100) {
            return new MultipleChoice(lesson.getLanguageName(), lesson.getWords(word, 4), word);
        } else if (wordPoint >= 200) {
            return new FillInTheBlank(lesson.getLanguageName(), lesson.getRandomWord());
        } else if (wordPoint >= 300) {
            return new Matching(lesson.getLanguageName(),lesson.getWords(word, 4));
        }
        throw new IllegalArgumentException("Invalid wordPoint value");
    }
}