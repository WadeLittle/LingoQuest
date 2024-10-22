package lingo_quest;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class DataLoader {
    public static ItemShop itemShop = ItemShop.getInstance();
    public static Users userList = Users.getInstance();
    public static LanguageManager languageManager = LanguageManager.getInstance();
    public static String userFile = "/Users/cadestocker/Desktop/Fall 24/247/Group Project/LingoQuest/correct_structure/src/json/Users.json";
    public static String itemFile = "/Users/cadestocker/Desktop/Fall 24/247/Group Project/LingoQuest/correct_structure/src/json/ItemShop.json";
    public static String placementFile = "/Users/cadestocker/Desktop/Fall 24/247/Group Project/LingoQuest/correct_structure/src/json/PlacementTest.json";
    public static String wordFile = "/Users/cadestocker/Desktop/Fall 24/247/Group Project/LingoQuest/correct_structure/src/json/Word.json";

    /**
     * @author cade
     * @return file path
     */
    public static String getUserFile() {
        return userFile;
    }

    /**
     * @author cade
     * @return file path
     */
    public static String getWordFile() {
        return wordFile;
    }

    /**
     * @author cade
     * @return string of file path
     */
    public static String getItemFile() {
        return itemFile;
    }

    /**
     * @author cade
     * @return string of file path
     */
    public static String getPlacementFile() {
        return placementFile;
    }

    /**
     * @author CADE STOCKER
     * @param file
     * @return
     * @throws FileNotFoundException
     * @throws IOException
     * @throws ParseException
     * @throws org.json.simple.parser.ParseException
     * REFACTORED VERSION OF COMMENTED CODE ABOVE
     */
    public static ArrayList<User> loadUsers(String file) 
        throws FileNotFoundException, IOException, ParseException, org.json.simple.parser.ParseException {

    ArrayList<User> users = new ArrayList<>();
    JSONParser jsonParser = new JSONParser();

    // Parse the JSON file
    JSONObject jsonObject = (JSONObject) jsonParser.parse(new FileReader(file));
    JSONArray usersArray = (JSONArray) jsonObject.get("users");

    // Iterate through each user object in the JSON array
    for (Object obj : usersArray) {
        JSONObject userJson = (JSONObject) obj;

        // Extract basic user data
        String userID = (String) userJson.get("userID");
        String username = (String) userJson.get("username");
        String password = (String) userJson.get("password");
        long coinsEarned = (long) userJson.get("coinsEarned");
        long coinBalance = (long) userJson.get("coinBalance");

        // Extract lists from JSON
        ArrayList<String> friendsList = extractStringList((JSONArray) userJson.get("friendsList"));
        ArrayList<Item> items = extractItems((JSONArray) userJson.get("items"));

        // Make the word of the day
        Word wordObject = new Word();
        JSONObject wordOfDay = (JSONObject) jsonObject.get("wordOfTheDay");
        if(wordOfDay != null)
            wordObject = makeWord(wordOfDay);
        // Make the languages the user has stored
        ArrayList<String> languages = extractStringList((JSONArray) userJson.get("languages"));
        
        // Languages are stored in json as UUID
        // Language should then be loaded in from the Languages json file by its UUID
        String currentLanguage = (String) userJson.get("currentLanguage");

        // Create and configure User object
        User user = createUser(userID, username, password, coinsEarned, coinBalance, friendsList, 
                               items, null, wordObject.getWord(), languages, currentLanguage);
        user.setWordOfTheDay(wordObject);
        users.add(user); // Add the fully created user to the list
    }

    return users;
}

/**
 * @author CADE STOCKER
 * @param jsonArray
 * @return
 * helper method
 */
private static ArrayList<String> extractStringList(JSONArray jsonArray) {
    ArrayList<String> list = new ArrayList<>();
    for (Object obj : jsonArray) {
        list.add((String) obj);
        //System.out.println((String) obj);
    }
    return list;
}

/**
 * @author CADE STOCKER
 * @param itemsJson
 * @return
 * helper method
 */
private static ArrayList<Item> extractItems(JSONArray itemsJson) {
    ArrayList<Item> items = new ArrayList<>();
    for (Object itemObj : itemsJson) {
        JSONObject itemJson = (JSONObject) itemObj;
        String name = (String) itemJson.get("name");
        String description = (String) itemJson.get("description");
        long price = (long) itemJson.get("price");
        //System.out.println(new Item(name,description,(int)price).toString());
        items.add(new Item(name, description, (int) price));
    }
    return items;
}



/**
 * @author CADE STOCKER
 * @param language
 * @return
 * helper method
 */
private static Languages mapLanguage(String language) {
    language = language.toLowerCase();
    switch (language) {
        case "spanish": return Languages.SPANISH;
        case "french": return Languages.FRENCH;
        case "german": return Languages.GERMAN;
        case "japanese": return Languages.JAPANESE;
        case "korean": return Languages.KOREAN;
        default:
            System.out.println("Error reading language: " + language);
            return Languages.DEFAULT;
    }
}

/**
 * @author CADE STOCKER
 * @param userID
 * @param username
 * @param password
 * @param coinsEarned
 * @param coinBalance
 * @param friendsList
 * @param items
 * @param userProgress
 * @param wordOfTheDay
 * @param languages
 * @param currentLanguage
 * @return
 * helper method for creating the user once you've found all of their data
 */
private static User createUser(String userID, String username, String password, 
                               long coinsEarned, long coinBalance, ArrayList<String> friendsList,
                               ArrayList<Item> items, HashMap<Languages, Double> userProgress,
                               String wordOfTheDay, ArrayList<String> languages, 
                               String currentLanguage) {

    User user = new User(username, password);
    user.setID(UUID.fromString(userID));
    user.setCoinsEarned((int) coinsEarned);
    user.setCoinBalance((int) coinBalance);
    user.setFriendsList(friendsList);
    user.setItems(items);
    user.setUserProgress(userProgress);
    user.setWordOfTheDay(new Word(wordOfTheDay));

    ArrayList<UUID> languagesUUID = new ArrayList<>();
    for (String lang : languages) {
        languagesUUID.add(UUID.fromString(lang));
    }
    user.setLanguages(languagesUUID);

    user.setCurrentLanguage(mapLanguage(currentLanguage));
    System.out.println(user.toString());
    return user;
}

    /**
     * @author CADE STOCKER
     * @return arraylist of items
     * @param String of the file's name
     * loads all items into the item shop
     */
    public static ArrayList<Item> loadItemShop(String file) 
        throws FileNotFoundException, IOException, ParseException, org.json.simple.parser.ParseException {

        ArrayList<Item> items = new ArrayList<>();
        JSONParser jsonParser = new JSONParser();

        // Parse the JSON file
        JSONObject jsonObject = (JSONObject) jsonParser.parse(new FileReader(file));
        JSONArray itemsArray = (JSONArray) jsonObject.get("items");

        // Iterate through each user object in the JSON array
        for (Object obj : itemsArray) {
            JSONObject userJson = (JSONObject) obj;

            // Extract basic user data
            String name = (String) userJson.get("name");
            String description = (String) userJson.get("description");
            long price = (long) userJson.get("price");

            // Create and configure User object
            Item item = new Item(name, description, (int)price);
            //System.out.println(item.toString());
            items.add(item); // Add the fully created user to the list
        }

        return items;
    }

    /**
     * @author CADE STOCKER
     * @param file
     * @return
     * @throws FileNotFoundException
     * @throws IOException
     * @throws ParseException
     * @throws org.json.simple.parser.ParseException
     * read multiple words and turn them into an arraylist
     */
    public static ArrayList<Word> loadWords(String file) 
        throws FileNotFoundException, IOException, ParseException, org.json.simple.parser.ParseException {

        ArrayList<Word> words = new ArrayList<>();
        JSONParser jsonParser = new JSONParser();

        // Parse the JSON file
        JSONObject jsonObject = (JSONObject) jsonParser.parse(new FileReader(file));
        JSONArray wordsArray = (JSONArray) jsonObject.get("words");

        // Iterate through each user object in the JSON array
        for (Object obj : wordsArray) {
            JSONObject wordJson = (JSONObject) obj;

            // Extract basic user data
            String language = (String) wordJson.get("language");
            Languages lang = mapLanguage(language);
            long timesPresented = (long) wordJson.get("timesPresented");
            long timesCorrect = (long) wordJson.get("timesCorrect");
            String word = (String) wordJson.get("word");
            double userUnderstanding = (double) wordJson.get("userUnderstanding");

            // Create and configure User object
            Word createdWord = new Word(word);
            createdWord.setTimesCorrect((int)timesCorrect);
            createdWord.setTimesPresented((int)timesPresented);
            createdWord.setUserUnderstanding(userUnderstanding);
            createdWord.setLanguage(lang);

            words.add(createdWord); // Add the fully created user to the list
        }
        return words;
    }

    /**
     * @author CADE STOCKER
     * @param file
     * @return a hashmap of languages
     * @throws Exception
     */
    public static HashMap<String, Language> loadLanguages(String file) throws Exception {
        HashMap<String, Language> languages = new HashMap<>();
        JSONParser parser = new JSONParser();
        JSONObject root = (JSONObject) parser.parse(new FileReader(file));

        for (Object key : root.keySet()) {
            String languageName = (String) key;
            JSONObject languageJson = (JSONObject) root.get(languageName);

            Language language = parseLanguage(languageJson, languageName);
            languages.put(languageName, language);
            //System.out.println(language.toString());
        }
        return languages;
    }

    /**
     * @author CADE STOCKER
     * @param languageJson
     * @param languageName
     * @return language object
     * read a single language object
     */
    private static Language parseLanguage(JSONObject languageJson, String languageName) {
        UUID userID = UUID.fromString((String) ((JSONObject) languageJson.get("User")).get("userID"));
        String placementTest = (String) languageJson.get("PlacementTest");
        int pointsEarned = ((Long) languageJson.get("pointsEarned")).intValue();
        int totalPoints = ((Long) languageJson.get("totalPoints")).intValue();
        double progress = (double) languageJson.get("progress");
        int placementScore = ((Long) languageJson.get("placementScore")).intValue();

        ArrayList<Section> sections = parseSections((JSONArray) languageJson.get("sections"));
        Dictionary dictionary = parseDictionary((JSONObject) languageJson.get("dictionary"));

        int answerStreak = ((Long) languageJson.get("answerStreak")).intValue();
        String langName = (String) languageJson.get("languageName");

        ArrayList<String> sectionsComplete = new ArrayList<>((JSONArray) languageJson.get("sectionsComplete"));
        HashMap<String, Boolean> sectionAccess = parseSectionAccess((JSONObject) languageJson.get("sectionAccess"));

        Language lang = new Language(userList.getUserByUUID(userID));

        PlacementTest pt = new PlacementTest();
        pt.setID(UUID.fromString(placementTest));
        lang.setPlacementTest(pt);

        lang.setPointsEarned(pointsEarned);
        lang.setTotalPoints(totalPoints);
        lang.setUserProgress(progress);
        lang.setPlacementScore(placementScore);

        return lang;
    }

    /**
     * @author CADE STOCKER
     * @param sectionsJson
     * @return arraylist of sections
     * make an arraylist of section objects
     */
    private static ArrayList<Section> parseSections(JSONArray sectionsJson) {
        ArrayList<Section> sections = new ArrayList<>();

        for (Object obj : sectionsJson) {
            JSONObject sectionJson = (JSONObject) obj;
            String sectionName = (String) sectionJson.get("sectionName");
            boolean userAccess = (boolean) sectionJson.get("userAccess");
            double sectionProgress = (double) sectionJson.get("sectionProgress");
            int pointsEarned = ((Long) sectionJson.get("pointsEarned")).intValue();
            int totalPoints = ((Long) sectionJson.get("totalPoints")).intValue();
            int coinValue = ((Long) sectionJson.get("coinValue")).intValue();
            boolean sectionComplete = (boolean) sectionJson.get("sectionComplete");

            ArrayList<Lesson> lessons = parseLessons((JSONArray) sectionJson.get("lessons"));

            Section sec = new Section(lessons,coinValue);
            sec.setSectionProgress(sectionProgress);
            sec.setUserAccess(userAccess);
            sec.setPointsEarned((int)pointsEarned);
            sec.setTotalPoints(totalPoints);
            sec.setSectionComplete(sectionComplete);
        }
        return sections;
    }

    /**
     * @author CADE STOCKER
     * @param lessonsJson
     * @return arraylist of lessons
     * make a list of lesson objects
     */
    private static ArrayList<Lesson> parseLessons(JSONArray lessonsJson) {
        ArrayList<Lesson> lessons = new ArrayList<>();

        for (Object obj : lessonsJson) {
            JSONObject lessonJson = (JSONObject) obj;
            int pointsEarned = ((Long) lessonJson.get("pointsEarned")).intValue();
            int totalPoints = ((Long) lessonJson.get("totalPoints")).intValue();
            int coinValue = ((Long) lessonJson.get("coinValue")).intValue();
            double lessonProgress = (double) lessonJson.get("lessonProgress");

            Dictionary topicDictionary = parseDictionary((JSONObject) lessonJson.get("topicDictionary"));
            ArrayList<Question> questions = parseQuestions((JSONArray) lessonJson.get("questions"));

            Lesson les = new Lesson(coinValue,totalPoints);
            les.setPointsEarned((int)pointsEarned);
            les.setLessonProgress(lessonProgress);
        }

        return lessons;
    }

    /**
     * @author CADE STOCKER
     * @param dictionaryJson
     * @return dictionary
     * read a dictionary object
     */
    private static Dictionary parseDictionary(JSONObject dictionaryJson) {
        HashMap<Word, Word> fromEnglish = new HashMap<>();
        HashMap<Word, Word> toEnglish = new HashMap<>();

        JSONObject fromEnglishJson = (JSONObject) dictionaryJson.get("fromEnglish");
        for (Object key : fromEnglishJson.keySet()) {
            Word keyWord = new Word();
            keyWord.setWord((String)key);
            Word valueWord = new Word();
            valueWord.setWord((String)fromEnglishJson.get(key));
            fromEnglish.put(keyWord, valueWord);
        }

        JSONObject toEnglishJson = (JSONObject) dictionaryJson.get("toEnglish");
        for (Object key : toEnglishJson.keySet()) {
            Word valueWord = new Word();
            valueWord.setWord((String)key);
            Word keyWord = new Word();
            keyWord.setWord((String)fromEnglishJson.get(key));
            toEnglish.put(keyWord, valueWord);
        }

        int numberOfWords = ((Long) dictionaryJson.get("numberOfWords")).intValue();
        return new Dictionary(fromEnglish, toEnglish, numberOfWords);
    }

    /**
     * @author CADE STOCKER
     * @param questionsJson
     * @return ArrayList of questions
     * make an arraylist of question objects
     */
    private static ArrayList<Question> parseQuestions(JSONArray questionsJson) {
        ArrayList<Question> questions = new ArrayList<>();

        for (Object obj : questionsJson) {
            JSONObject questionJson = (JSONObject) obj;
            //String question = (String) questionJson.get("question");
            //ArrayList<String> answerChoices = new ArrayList<>((JSONArray) questionJson.get("answerChoices"));
            //String userAnswer = (String) questionJson.get("userAnswer");
            int pointValue = ((Long) questionJson.get("pointValue")).intValue();
            int coinValue = ((Long) questionJson.get("coinValue")).intValue();
            String questionType = (String) questionJson.get("questionType");
            questionType = questionType.toLowerCase();
            //String correctAnswer;


            /* 
            // get this working 10/21
            switch(questionType){
                case("matching"):
                    
                    HashMap<Word,Word> correctMatches = new HashMap();
                    for(int i = 0; i < correctMatches.size(); i++) {
                        
                    }
                    //correctMatches.put(key, value)
                    break;
                case("multiplechoice"):
                    //Do these strings need to be words?
                    correctAnswer = (String) questionJson.get("correctAnswer");
                    break;
                case("fillintheblank"):
                    correctAnswer = (String) questionJson.get("correctAnswer");
                    break;
            }
            Media media = parseMedia((JSONObject) questionJson.get("media"));
            Question quest = new Question();
            //quest.setAnswerChoices(questionsJson);

        }

        return questions;
    }
        */

    // Need to talk about this with team to get it sorted before reading
    /**
     * @author CADE STOCKER
     * @param media
     * @return Media
     * read an individual media object
     */

     
    private static Media parseMedia(JSONObject media) {
        String name = (String) media.get("name");
        String description = (String) media.get("description");
        String fileName = (String) media.get("fileName");
        //Media med = new Media();
        //return med;
        String test = "test";
        return null;
    }

    /**
     * @author CADE STOCKER
     * @param sectionAccessJson
     * @return
     * Read whether the user has access to each section in the json
     */
    private static HashMap<String, Boolean> parseSectionAccess(JSONObject sectionAccessJson) {
        HashMap<String, Boolean> sectionAccess = new HashMap<>();
        // iterate through the sections and determine the access boolean
        for (Object key : sectionAccessJson.keySet()) {
            sectionAccess.put((String) key, (boolean) sectionAccessJson.get(key));
        }

        return sectionAccess;
    }

    public static Word makeWord(JSONObject obj) {
        Languages language = mapLanguage((String) obj.get("language"));
        int timesPresented = (int) obj.get("timesPresented");
        String word = (String) obj.get("word");
        int timesCorrect = (int) obj.get("timesCorrect");
        double userUnderstanding = (double) obj.get("userUnderstanding");
        Word wordReturn = new Word();
        wordReturn.setWord(word);
        wordReturn.setLanguage(language);
        wordReturn.setTimesCorrect(timesCorrect);
        wordReturn.setUserUnderstanding(userUnderstanding);
        wordReturn.setTimesPresented(timesPresented);
        return wordReturn;
    }

    /**
     * @author CADE STOCKER
     * This method will call all of the methods that actually
     * do the work.
     */
    public static void loadData() {
        try {
            userList.loadUsers();
            
            itemShop.loadItems(loadItemShop("/Users/cadestocker/Desktop/Fall 24/247/Group Project/LingoQuest/correct_structure/src/json/ItemShop.json"));
            
            //not yet sure where words will go once loaded in
            loadWords("/Users/cadestocker/Desktop/Fall 24/247/Group Project/LingoQuest/correct_structure/src/json/Word.json");
            try {
                loadLanguages("/Users/cadestocker/Desktop/Fall 24/247/Group Project/LingoQuest/correct_structure/src/json/language.json");
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            
        } catch (IOException | ParseException | org.json.simple.parser.ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * @author CADE STOCKER
     * @param progressJson
     * @return
     * helper method for user progress
     */
    /*private static HashMap<Languages, Long> extractUserProgress(JSONObject progressJson) {
        HashMap<Languages, Long> userProgress = new HashMap<>();
        String language = ((String) progressJson.get("language")).toLowerCase();

        Languages keyLang = mapLanguage(language);
        long points = ((Number) progressJson.get("points")).longValue();
        userProgress.put(keyLang, points);

        return userProgress;
    }*/
}