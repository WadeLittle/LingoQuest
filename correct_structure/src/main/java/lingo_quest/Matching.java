package lingo_quest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Matching extends Question {
    String language;
    ArrayList<Word> words;
    
    // ArrayList<String> englishWords;
    // ArrayList<String> languageWords;


    public Matching(String language, ArrayList<Word> answerChoices) {
        super(language);
        this.words = answerChoices;
    }

    public boolean isCorrect(Word languageWord, Word englishWord, User user) {
       boolean isCorrect = languageWord.getWordUUID().equals(englishWord.getWordUUID());
       if(isCorrect) {
        user.getUserDictionary().getWordByUUID(languageWord.getWordUUID()).wordPresented(true);
       } else {
        user.getUserDictionary().getWordByUUID(languageWord.getWordUUID()).wordPresented(false);
       }
       return isCorrect;
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("Match the following words\n");
        for(int i = 0; i < words.size();i++) {
            result.append(i+1).append(". ").append(words.get(i).getWordinLanguage()).append("\n");
        }
        Collections.shuffle(words);
        for(int i = 0; i < words.size();i++) {
            result.append(i+5).append(". ").append(words.get(i).getEnglishVersion()).append("\n");
        }
        return result.toString();
    }
    @Override
    public boolean isCorrect(User user) {
        /*try {
            int userAnswerIndex = Integer.parseInt(userAnswer.trim());
            boolean isCorrect = (userAnswerIndex == correctAnswerIndex);

            user.getUserDictionary().getWordByUUID(correctAnswer.getWordUUID()).wordPresented(isCorrect);
            return isCorrect;
        } catch (NumberFormatException e) {
            // Handle invalid user input
            user.getUserDictionary().getWordByUUID(correctAnswer.getWordUUID()).wordPresented(false);
            return false;
        }*/
        return true;
    }
}
