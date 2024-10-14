package lingo_quest;

import java.util.HashMap;

/**
 * The Dictionary class provides functionality for storing and managing word translations
 * between English and another language. It maintains two HashMaps for bidirectional translation.
 */
class Dictionary {
    private HashMap<Word, Word> fromEnglish;
    private HashMap<Word, Word> toEnglish;
    private int numberOfWords;

    /**
     * Constructs an empty Dictionary with no words.
     * Initializes two empty HashMaps for translation from and to English.
     * @author Preston Willis
     */
    public Dictionary() {
        fromEnglish = new HashMap<>();
        toEnglish = new HashMap<>();
        numberOfWords = 0;
    }

    /**
     * Constructs a Dictionary with predefined word mappings and a word count.
     *
     * @param word1 HashMap for translating from English to another language.
     * @param word2 HashMap for translating from another language to English.
     * @param numberOfWords Number of words initially present in the dictionary.
     */
    public Dictionary(HashMap<Word, Word> word1, HashMap<Word, Word> word2, int numberOfWords) {
        this.fromEnglish = word1;
        this.toEnglish = word2;
        this.numberOfWords = numberOfWords;
    }

    /**
     * Adds a new word translation to the dictionary.
     * Updates both the fromEnglish and toEnglish maps and increments the word count.
     *
     * @param english The Word object representing the English word.
     * @param otherLanguage The Word object representing the translation in another language.
     */
    public void addWord(Word english, Word otherLanguage) {
        fromEnglish.put(english, otherLanguage);
        toEnglish.put(otherLanguage, english);
        numberOfWords++;
    }

    /**
     * Removes a word translation from the dictionary.
     * Deletes entries from both fromEnglish and toEnglish maps and decrements the word count.
     *
     * @param english The Word object representing the English word.
     * @param otherLanguage The Word object representing the translation in another language.
     */
    public void removeWord(Word english, Word otherLanguage) {
        fromEnglish.remove(english);
        toEnglish.remove(otherLanguage);
        numberOfWords--;
    }

    /**
     * Prints the contents of the given HashMap representing word translations.
     * 
     * @param map A HashMap representing a dictionary for translation (either from or to English).
     */
    public void printDictionary(HashMap<Word, Word> map) {
        for (Word key : map.keySet()) {
            System.out.println(key + " -> " + map.get(key));
        }
    }

    /**
     * Checks if the dictionary contains a specific word in either the fromEnglish or toEnglish maps.
     *
     * @param word The Word object to check for in the dictionary.
     * @return true if the word exists in the dictionary, false otherwise.
     */
    public boolean contains(Word word) {
        return fromEnglish.containsKey(word) || toEnglish.containsKey(word);
    }

    /**
     * Gets the total number of words in the dictionary.
     *
     * @return The number of word translations stored in the dictionary.
     */
    public int getNumberOfWords() {
        return numberOfWords;
    }

    /**
     * Rebuilds the toEnglish map based on the current fromEnglish map, clearing the existing toEnglish map.
     * Updates the number of words in the dictionary to reflect the size of fromEnglish.
     */
    public void loadDictionary() {
        this.toEnglish.clear();  // Clear any existing mappings in toEnglish
    
        // Rebuild the toEnglish map based on fromEnglish
        for (Word englishWord : fromEnglish.keySet()) {
            Word otherLanguageWord = fromEnglish.get(englishWord);
            toEnglish.put(otherLanguageWord, englishWord);
        }   
        this.numberOfWords = fromEnglish.size();  // Update the number of words
    }

    /**
     * Saves the current fromEnglish map.
     * 
     * @return A new HashMap containing the translations from English to another language.
     */
    public HashMap<Word, Word> saveFromEnglishDictionary() {
        return new HashMap<>(fromEnglish);
    }

    /**
     * Saves the current toEnglish map.
     * 
     * @return A new HashMap containing the translations from another language to English.
     */
    public HashMap<Word, Word> saveToEnglishDictionary() {
        return new HashMap<>(toEnglish);
    }
}






