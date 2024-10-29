package lingo_quest;

import java.util.ArrayList;
import java.util.UUID;

/**
 * The Dictionary class provides functionality for storing and managing word
 * translations
 * between English and another language. It maintains two HashMaps for
 * bidirectional translation.
 * 
 * 10/22 We have changed the design of the Word class, meaning that dictionary
 * will now be restructured as an ArrayList of words
 */
class Dictionary {
    private ArrayList<Word> words;
    private UUID dictionaryID;
    private int numberOfWords;

    /**
     * Constructs an empty Dictionary with no words.
     * creates empty arraylist
     * 
     * @author Preston Willis
     */
    public Dictionary() {
        this.words = new ArrayList<Word>();
        this.dictionaryID = UUID.randomUUID();
        numberOfWords = 0;
    }

    /**
     * @author cade
     * tests default constructor
     */
    public void testDefaultConstructor() {
        // dont save d to dictionary manager
        Dictionary d = new Dictionary();
        System.out.println(d.getNumberOfWords() + " " + d.getID() + " Are words null:" + d.getWords() == null);
    }

    /**
     * @author cade
     * @param words
     */
    public void setWords(ArrayList<Word> words) {
        this.words = words;
    }

    /**
     * @author cade
     * @param i
     */
    public void setNumberOfWords(int i) {
        this.numberOfWords = i;
    }

    /**
     * @author cade
     * @return the arraylist of words
     */
    public ArrayList<Word> getWords() {
        return this.words;
    }

    /**
     * @author Cade
     * @return the dictionary's id
     */
    public UUID getID() {
        return this.dictionaryID;
    }

    /**
     * @author cade
     * @param id
     */
    public void setID(UUID id) {
        this.dictionaryID = id;
    }

    /**
     * @author cade
     * @param maxPointsInclusive
     * @return list of words that are equal to or below the specified number
     *         of points
     */
    public ArrayList<Word> getWordsByUnderstanding(double maxUnderstandingInclusive) {
        ArrayList<Word> words = new ArrayList<>();
        for (Word w : this.words) {
            if (w.getPoints() <= maxUnderstandingInclusive)
                words.add(w);
        }
        return words;
    }

    public void testGetWordsByUnderstanding1() {
        // make an array and add some words with different understanding levels
        ArrayList<Word> testWords = new ArrayList<>();
        Word w1 = new Word(Languages.SPANISH, "perro", "dog", UUID.randomUUID(), UUID.randomUUID());
        w1.setUserUnderstanding(20.0);
        Word w2 = new Word(Languages.SPANISH, "gato", "cat", UUID.randomUUID(), UUID.randomUUID());
        w2.setUserUnderstanding(80.0);
        Word w3 = new Word(Languages.SPANISH, "rana", "frog", UUID.randomUUID(), UUID.randomUUID());
        w3.setUserUnderstanding(40.0);
        Word w4 = new Word(Languages.SPANISH, "rana", "frog", UUID.randomUUID(), UUID.randomUUID());
        w4.setUserUnderstanding(70.0);
        // add the words
        testWords.add(w1);
        testWords.add(w2);
        testWords.add(w3);
        testWords.add(w4);
        // make a dictionary and add the words to it
        Dictionary d = new Dictionary();
        d.setWords(testWords);
        // get the words by understanding and print them
        ArrayList<Word> testWordsUnderstanding = d.getWordsByUnderstanding(50.0);
        for(Word w : testWordsUnderstanding) {
            System.out.println(w.toString());
        }
    }

    public void testGetWordsByUnderstanding2() {
        // make an array and add some words with different understanding levels
        ArrayList<Word> testWords = new ArrayList<>();
        Word w1 = new Word(Languages.SPANISH, "perro", "dog", UUID.randomUUID(), UUID.randomUUID());
        w1.setUserUnderstanding(20.0);
        Word w2 = new Word(Languages.SPANISH, "gato", "cat", UUID.randomUUID(), UUID.randomUUID());
        w2.setUserUnderstanding(80.0);
        Word w3 = new Word(Languages.SPANISH, "rana", "frog", UUID.randomUUID(), UUID.randomUUID());
        w3.setUserUnderstanding(40.0);
        Word w4 = new Word(Languages.SPANISH, "rana", "frog", UUID.randomUUID(), UUID.randomUUID());
        w4.setUserUnderstanding(70.0);
        // add the words
        testWords.add(w1);
        testWords.add(w2);
        testWords.add(w3);
        testWords.add(w4);
        // make a dictionary and add the words to it
        Dictionary d = new Dictionary();
        d.setWords(testWords);
        // get the words by understanding and print them
        // this version should print NO words
        ArrayList<Word> testWordsUnderstanding = d.getWordsByUnderstanding(10.0);
        for(Word w : testWordsUnderstanding) {
            System.out.println(w.toString());
        }
    }

    public void testGetWordsByUnderstanding3() {
        // make an array and add some words with different understanding levels
        ArrayList<Word> testWords = new ArrayList<>();
        Word w1 = new Word(Languages.SPANISH, "perro", "dog", UUID.randomUUID(), UUID.randomUUID());
        w1.setUserUnderstanding(20.0);
        Word w2 = new Word(Languages.SPANISH, "gato", "cat", UUID.randomUUID(), UUID.randomUUID());
        w2.setUserUnderstanding(80.0);
        Word w3 = new Word(Languages.SPANISH, "rana", "frog", UUID.randomUUID(), UUID.randomUUID());
        w3.setUserUnderstanding(40.0);
        Word w4 = new Word(Languages.SPANISH, "rana", "frog", UUID.randomUUID(), UUID.randomUUID());
        w4.setUserUnderstanding(70.0);
        // add the words
        testWords.add(w1);
        testWords.add(w2);
        testWords.add(w3);
        testWords.add(w4);
        // make a dictionary and add the words to it
        Dictionary d = new Dictionary();
        d.setWords(testWords);
        // get the words by understanding and print them
        // this version should print ALL words
        ArrayList<Word> testWordsUnderstanding = d.getWordsByUnderstanding(100.0);
        for(Word w : testWordsUnderstanding) {
            System.out.println(w.toString());
        }
    }

    /**
     * @author cade
     * @param id
     */
    public void setID(String id) {
        this.dictionaryID = UUID.fromString(id);
    }

    /**
     * Constructs a Dictionary with predefined word mappings and a word count.
     *
     * @param word1         HashMap for translating from English to another
     *                      language.
     * @param word2         HashMap for translating from another language to
     *                      English.
     * @param numberOfWords Number of words initially present in the dictionary.
     */
    public Dictionary(ArrayList<Word> words, int numberOfWords) {
        this.words = words;
        this.numberOfWords = numberOfWords;
    }

    public void testParamConstructor() {
        // make an arraylist and add some words to it
        ArrayList<Word> testWords = new ArrayList<>();
        Word w1 = new Word(Languages.SPANISH, "perro", "dog", UUID.randomUUID(), UUID.randomUUID());
        w1.setUserUnderstanding(20.0);
        Word w2 = new Word(Languages.SPANISH, "gato", "cat", UUID.randomUUID(), UUID.randomUUID());
        w2.setUserUnderstanding(80.0);
        Word w3 = new Word(Languages.SPANISH, "rana", "frog", UUID.randomUUID(), UUID.randomUUID());
        w3.setUserUnderstanding(40.0);
        Word w4 = new Word(Languages.SPANISH, "rana", "frog", UUID.randomUUID(), UUID.randomUUID());
        w4.setUserUnderstanding(70.0);
        // add the words
        testWords.add(w1);
        testWords.add(w2);
        testWords.add(w3);
        testWords.add(w4);
        // create a dictionary and add the word list
        Dictionary d = new Dictionary(testWords,4);
        // print out the dictionary to test if they were added
        d.printDictionary();
    }

    /**
     * Adds a new word translation to the dictionary.
     * Updates both the fromEnglish and toEnglish maps and increments the word
     * count.
     *
     * @param english       The Word object representing the English word.
     * @param otherLanguage The Word object representing the translation in another
     *                      language.
     */
    public void addWord(Word word) {
        if(word != null) {
            this.words.add(word);
            numberOfWords++;
        }
    }

    /**
     * @author cade
     * test adding a valid word
     */
    public void testAddWord1() {
        Word w4 = new Word(Languages.SPANISH, "rana", "frog", UUID.randomUUID(), UUID.randomUUID());
        w4.setUserUnderstanding(70.0);
        // create a dictionary
        Dictionary d = new Dictionary();
        // add the word
        d.addWord(w4);
        // print the dictionary
        d.printDictionary();
    }

    /**
     * @author cade
     * test adding a null word
     */
    public void testAddWord2() {
        // create a dictionary
        Dictionary d = new Dictionary();
        // add null
        d.addWord(null);
        // print the dictionary
        d.printDictionary();
    }

    /**
     * Removes a word translation from the dictionary.
     * Deletes entries from both fromEnglish and toEnglish maps and decrements the
     * word count.
     *
     * @param word The string representing the word to be removed.
     */
    public void removeWord(String word) {
        for (Word w : this.words) {
            if (w.getWordinLanguage().equalsIgnoreCase(word)) {
                this.words.remove(w);
                this.numberOfWords--;
                return;
            }
        }
    }

    /**
     * Prints the contents of the given HashMap representing word translations.
     * 
     * @param map A HashMap representing a dictionary for translation (either from
     *            or to English).
     */
    public void printDictionary() {
        for (Word w : this.words) {
            System.out.println(w.toString());
        }
    }

    public void testPrintDictionaryWithWords() {
        Dictionary dictionary = new Dictionary();
        
        // Add words to the dictionary
        Word word1 = new Word(Languages.SPANISH, "rana", "frog", UUID.randomUUID(), UUID.randomUUID());
        Word word2 = new Word(Languages.SPANISH, "calor", "hot", UUID.randomUUID(), UUID.randomUUID());
        dictionary.addWord(word1);
        dictionary.addWord(word2);

        // Call the method
        dictionary.printDictionary();
    }

    public void testPrintDictionaryWithNoWords() {
        Dictionary dictionary = new Dictionary();
        // Call the method with no words in dictionary
        dictionary.printDictionary();
    }

    /**
     * Checks if the dictionary contains a specific word in either the fromEnglish
     * or toEnglish maps.
     *
     * @param word The String of the word to check for in the dictionary.
     * @return true if the word exists in the dictionary, false otherwise.
     *         edited by cade
     */
    public boolean contains(String word) {
        for (Word w : this.words) {
            if (w.getWordinLanguage().equalsIgnoreCase(word)) {
                return true;
            }
        }
        return false;
    }

    /**
     * @author cade
     * test the contains method with words present
     */
    public void testContainsWordPresent() {
        Dictionary dictionary = new Dictionary();

        // Add a word to the dictionary
        Word word1 = new Word(Languages.SPANISH, "perro", "dog", UUID.randomUUID(), UUID.randomUUID());
        dictionary.addWord(word1);

        // Check if dictionary contains the word "perro"
        boolean result = dictionary.contains("perro");

        if (result) {
            System.out.println("testContainsWordPresent PASSED");
        } else {
            System.out.println("testContainsWordPresent FAILED");
        }
    }

    /**
     * @author cade
     * test method for contains method
     * checking for a word that doesn't exist in the dictionary
     */
    public void testContainsWordAbsent() {
        Dictionary dictionary = new Dictionary();

        // Add a different word
        Word word1 = new Word(Languages.SPANISH, "gato", "cat", UUID.randomUUID(), UUID.randomUUID());
        dictionary.addWord(word1);

        // Check if dictionary contains the word "perro" which is absent
        boolean result = dictionary.contains("perro");

        if (!result) {
            System.out.println("testContainsWordAbsent PASSED");
        } else {
            System.out.println("testContainsWordAbsent FAILED");
        }
    }

    /**
     * @author cade
     * test to see if the case will affect the contains method
     */
    public void testContainsWordCaseInsensitive() {
        Dictionary dictionary = new Dictionary();

        // Add a word to the dictionary with lowercase
        Word word1 = new Word(Languages.SPANISH, "perro", "dog", UUID.randomUUID(), UUID.randomUUID());
        dictionary.addWord(word1);

        // Check if dictionary contains "PERRO" in uppercase
        boolean result = dictionary.contains("PERRO");

        if (result) {
            System.out.println("testContainsWordCaseInsensitive PASSED");
        } else {
            System.out.println("testContainsWordCaseInsensitive FAILED");
        }
    }

    /**
     * @author cade
     * testing contains on an empty dictionary
     */
    public void testContainsWordEmptyDictionary() {
        Dictionary dictionary = new Dictionary();

        // Check if dictionary contains any word in an empty dictionary
        boolean result = dictionary.contains("perro");

        if (!result) {
            System.out.println("testContainsWordEmptyDictionary PASSED");
        } else {
            System.out.println("testContainsWordEmptyDictionary FAILED");
        }
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
     * @author cade
     * @param id
     * @return list of words in that lesson
     */
    public ArrayList<Word> getWordsByTopicID(UUID id) {
        ArrayList<Word> ret = new ArrayList<>();
        for (Word w : this.words) {
            if (w.getLessonID().equals(id))
                ret.add(w);
        }
        return ret;
    }

    public void testGetWordsByTopicIDWithMatchingWords() {
        Dictionary dictionary = new Dictionary();

        // topicIDs are actually lessonIDs
        // Create a topic ID and add words with this topic ID
        UUID topicID = UUID.randomUUID();
        Word word1 = new Word(Languages.SPANISH, "perro", "dog", UUID.randomUUID(), topicID);
        Word word2 = new Word(Languages.SPANISH, "gato", "cat", UUID.randomUUID(), topicID);
        dictionary.addWord(word1);
        dictionary.addWord(word2);

        // Check if getWordsByTopicID returns words with the specified topic ID
        ArrayList<Word> result = dictionary.getWordsByTopicID(topicID);

        if (result.size() == 2 && result.contains(word1) && result.contains(word2)) {
            System.out.println("testGetWordsByTopicIDWithMatchingWords PASSED");
        } else {
            System.out.println("testGetWordsByTopicIDWithMatchingWords FAILED");
        }
    }

    /**
     * test looking for words by topic id when there are no matches
     */
    public void testGetWordsByTopicIDWithNoMatchingWords() {
        Dictionary dictionary = new Dictionary();

        // Create a topic ID that no words will have
        UUID topicID = UUID.randomUUID();
        
        // Add words with a different topic ID
        Word word1 = new Word(Languages.SPANISH, "perro", "dog", UUID.randomUUID(), UUID.randomUUID());
        Word word2 = new Word(Languages.SPANISH, "gato", "cat", UUID.randomUUID(), UUID.randomUUID());
        dictionary.addWord(word1);
        dictionary.addWord(word2);

        // Check if getWordsByTopicID returns an empty list for a non-matching topic ID
        ArrayList<Word> result = dictionary.getWordsByTopicID(topicID);

        if (result.isEmpty()) {
            System.out.println("testGetWordsByTopicIDWithNoMatchingWords PASSED");
        } else {
            System.out.println("testGetWordsByTopicIDWithNoMatchingWords FAILED");
        }
    }

    /**
     * @author Cade
     * @param word
     * @return the word object
     *         changed this to work with the new way we are using words (got rid of
     *         hashmaps)
     */
    public Word getWordByString(String word) {
        for (Word w : this.words) {
            if (word.equalsIgnoreCase(w.getWordinLanguage())) {
                return w;
            }
        }
        return null;
    }

    public Word getWordByUUID(UUID uuid) {
        for (Word w : this.words) {
            if (w.getWordUUID().equals(uuid)) {
                return w;
            }
        }
        return null;
    }

}
