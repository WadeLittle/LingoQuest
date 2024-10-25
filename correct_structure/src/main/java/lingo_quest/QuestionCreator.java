package lingo_quest;

public class QuestionCreator {

    // Constructor
    public QuestionCreator() {
    }
    
    public Question createQuestion(Lesson lesson) {
        Word word = lesson.getRandomWord();
        int wordPoint = word.getPoints();
        
        if (wordPoint >= 300) {
            return new Matching(lesson.getLanguageName(), lesson.getWords(word, 4));
        } else if (wordPoint >= 200) {
            return new FillInTheBlank(lesson.getLanguageName(), word);
        } else if (wordPoint == 100) {
            return new MultipleChoice(lesson.getLanguageName(), lesson.getWords(word, 4), word);
        } else if (wordPoint <= 0) {
            Word anotherWord;
            do {
                anotherWord = lesson.getRandomWord();
            } while (anotherWord.equals(word));
            return new TrueOrFalse(lesson.getLanguageName(), word, anotherWord);
        }
        
        throw new IllegalArgumentException("Unsupported wordPoint value: " + wordPoint);
    }
}
