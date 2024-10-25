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
    public boolean isCorrect(Word languageWord, Word englishWord) {
       return languageWord.getWordUUID().equals(englishWord.getWordUUID());
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("Match the following words");
        for(int i = 0; i < words.size();i++) {
            result.append(i+1).append(". ").append(words.get(i).getWordinLanguage()).append("\n");
        }
        Collections.shuffle(words);
        for(int i = 0; i < words.size();i++) {
            result.append(i+5).append(". ").append(words.get(i).getEnglishVersion()).append("\n");
        }
        return result.toString();
    }
}
