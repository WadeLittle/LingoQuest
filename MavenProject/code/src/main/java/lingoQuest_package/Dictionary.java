package lingoQuest_package;
import java.util.HashMap;

class Dictionary {
    private HashMap<Word, Word> fromEnglish;
    private HashMap<Word, Word> toEnglish;
    private int numberOfWords;

    public Dictionary() {
        fromEnglish = new HashMap<>();
        toEnglish = new HashMap<>();
        numberOfWords = 0;
    }

    public void addWord(Word english, Word otherLanguage) {
        fromEnglish.put(english, otherLanguage);
        toEnglish.put(otherLanguage, english);
        numberOfWords++;
    }

    public void removeWord(Word english, Word otherLanguage) {
        fromEnglish.remove(english);
        toEnglish.remove(otherLanguage);
        numberOfWords--;
    }

    public void printDictionary(HashMap<Word, Word> map) {
        for (Word key : map.keySet()) {
            System.out.println(key + " -> " + map.get(key));
        }
    }

    public boolean contains(Word word) {
        return fromEnglish.containsKey(word) || toEnglish.containsKey(word);
    }

    public int getNumberOfWords() {
        return numberOfWords;
    }

    public void loadDictionary() {
    }

    public void saveDictionary() {
    }
}

