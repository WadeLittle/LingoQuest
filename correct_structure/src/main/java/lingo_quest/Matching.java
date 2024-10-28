package lingo_quest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Random;

public class Matching extends Question {
    String language;
    ArrayList<Word> words;
    int answerIndex;


    public Matching(String language, ArrayList<Word> answerChoices) {
        super(language);
        this.words = answerChoices;
        this.generateQuestion();
    }
    
    private void generateQuestion() {
        Random r = new Random();
        this.answerIndex = r.nextInt(words.size());
    }

    public boolean isCorrect(int i, User user) {
       boolean isCorrect = answerIndex == (i-1);
       if(isCorrect) {
        user.getUserDictionary().getWordByUUID(words.get(answerIndex).getWordUUID()).wordPresented(true);
        System.out.println("You are Correct");
       } else {
        user.getUserDictionary().getWordByUUID(words.get(answerIndex).getWordUUID()).wordPresented(false);
        System.out.println("You are incorrect");
       }
       return isCorrect;
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("Match the English word " + words.get(answerIndex).getEnglishVersion() + " to one of the following words\n");
        for(int i = 0; i < words.size();i++) {
            result.append(i+1).append(". ").append(words.get(i).getWordinLanguage()).append("\n");
        }
        //Collections.shuffle(words);
        /*for(int i = 0; i < words.size();i++) {
            //result.append(i+5).append(". ").append(words.get(i).getEnglishVersion()).append("\n");
            
        }*/
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
