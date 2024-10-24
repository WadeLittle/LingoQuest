package lingo_quest;

public class QuestionCreator {

    private DictionaryManager dictionaryManager;

    // Constructor to initialize DictionaryManager
    public QuestionCreator(DictionaryManager dictionaryManager) {
        this.dictionaryManager = dictionaryManager;
    }
    
    public Question createQuestion(int wordPoint) {
        // Retrieve a word from the dictionary to use in the question
        String word = dictionaryManager.getRandomWord(); 

        if (wordPoint <= 0) {
            return new MultipleChoice(word);
        } else if (wordPoint == 100) {
            return new FillInTheBlank(word);
        } else if (wordPoint >= 200) {
            return new Matching(word);
        }
        throw new IllegalArgumentException("Invalid wordPoint value");
    }
}