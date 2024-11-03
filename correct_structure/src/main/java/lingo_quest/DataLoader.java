package lingo_quest;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class DataLoader {
    public final static ItemShop itemShop = ItemShop.getInstance();
    public final static Users userList = Users.getInstance();
    public final static LanguageManager languageManager = LanguageManager.getInstance();
    public static String userFileJunit = "/data/Users.json";
    public static String userFile = "correct_structure/src/main/resources/data/Users.json";
    public static String itemFileJunit = "/data/ItemShop.json";
    public static String itemFile = "correct_structure/src/main/resources/data/ItemShop.json";
    public static String placementFileJunit = "/data/PlacementTest.json";
    public static String placementFile = "correct_structure/src/main/resources/data/PlacementTest.json";
    public static String wordFileJunit = "/data/Word.json";
    public static String wordFile = "correct_structure/src/main/resources/data/Word.json";
    public static String dictionaryFileJunit = "/data/Dictionaries.json";
    public static String dictionaryFile = "correct_structure/src/main/resources/data/Dictionaries.json";
    public static String languageFileJunit = "/data/Languages2.json";
    public static String languageFile = "correct_structure/src/main/resources/data/Languages2.json";

    public static boolean isJUnitTest() {
        for(StackTraceElement element : Thread.currentThread().getStackTrace()) {
            if(element.getClassName().startsWith("org.junit.")) {
                return true;
            }
        }
        return false;
    }

    private static BufferedReader getReaderFromFile(String fileName, String jsonFileName) {
        try{
            if(isJUnitTest()) {
                InputStream inputStream = DataLoader.class.getResourceAsStream(jsonFileName);
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                return new BufferedReader(inputStreamReader);
            }
            else {
                FileReader reader = new FileReader(fileName);
                return new BufferedReader(reader);
            }
        } catch(Exception e) {
            System.out.println("Can't load");
            return null;
        }
    }

    /**
     * @author cade
     * @return file path
     */
    public static String getUserFile() {
        return userFile;
    }

    /**
     * @author cade
     * @return path of languagefile
     */
    public static String getLanguageFile() {
        return languageFile;
    }

    /**
     * @author cade
     * @return the dictionary filepath
     */
    public static String getDictionaryFile() {
        return dictionaryFile;
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
     * REFACTORED VERSION OF COMMENTED
     * CODE ABOVE
     */
    public static ArrayList<User> loadUsers(String file)
            throws FileNotFoundException, IOException, ParseException, org.json.simple.parser.ParseException {

        ArrayList<User> users = new ArrayList<>();
        //JSONParser jsonParser = new JSONParser();

        // PORTIA SHOWS THIS WAY ON THE YOUTUBE VIDEO FOR JUNIT
        //InputStream inputStream = DataLoader.class.getResourceAsStream(userFile);
        //InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        //BufferedReader reader = new BufferedReader(inputStreamReader);
        BufferedReader reader = getReaderFromFile(userFile, userFileJunit);
        JSONObject jsonObject = (JSONObject) new JSONParser().parse(reader);
        // get the array from the object
        JSONArray usersArray = (JSONArray) jsonObject.get("users");

        // Parse the JSON file
        //JSONObject jsonObject = (JSONObject) jsonParser.parse(new FileReader(file));

        // COMMENTED THIS OUT IN ATTEMPT TO GET JUNIT WORKING
        //JSONArray usersArray = (JSONArray) jsonObject.get("users");
        //JSONObject jsonObject = (JSONObject) jsonParser.parse(new FileReader(file));

        if(usersArray != null) {
        // Iterate through each user object in the JSON array
        for (Object obj : usersArray) {
            JSONObject userJson = (JSONObject) obj;

            // Extract basic user data
            String userID = (String) userJson.get("userID");
            String dictionaryID = (String) userJson.get("dictionaryID");
            String username = (String) userJson.get("username");
            String password = (String) userJson.get("password");
            long coinsEarned = (long) userJson.get("coinsEarned");
            long coinBalance = (long) userJson.get("coinBalance");
            String currentLanguageID = (String) userJson.get("currentLanguageID");

            // Extract lists from JSON
            ArrayList<String> friendsList = extractStringList((JSONArray) userJson.get("friendsList"));
            JSONArray itemsArray = (JSONArray) userJson.get("items");
            ArrayList<String> items = extractStringList(((JSONArray) userJson.get("items")));

            // Make the word of the day
            Word wordObject = new Word();
            JSONObject wordOfDay = (JSONObject) jsonObject.get("wordOfTheDay");
            if (wordOfDay != null)
                wordObject = makeWord(wordOfDay);
            // Make the languages the user has stored
            ArrayList<String> languages = extractStringList((JSONArray) userJson.get("languages"));

            // Languages are stored in json as UUID
            // Language should then be loaded in from the Languages json file by its UUID
            String currentLanguage = (String) userJson.get("currentLanguage");

            // Create and configure User object
            User user = createUser(userID, username, password, coinsEarned, coinBalance, friendsList,
                    items, null, languages, currentLanguage, dictionaryID);

            // Set the word of the day
            user.setWordOfTheDay(wordObject);
            if (currentLanguageID != null)
                user.setCurrentLangaugeID(UUID.fromString(currentLanguageID));

            users.add(user); // Add the fully created user to the list
        }
        reader.close();
        return users;
        }
        return null;
    }

    /**
     * @author CADE STOCKER
     * @param jsonArray
     * @return
     * Helper method
     */
    private static ArrayList<String> extractStringList(JSONArray jsonArray) {
        ArrayList<String> list = new ArrayList<>();
        for (Object obj : jsonArray) {
            list.add((String) obj);
        }
        return list;
    }

    /**
     * @author CADE STOCKER
     * @param itemsJson
     * @return
     * Helper method
     */
    private static ArrayList<Item> extractItems(JSONArray itemsJson) {
        ArrayList<Item> items = new ArrayList<>();
        for (Object itemObj : itemsJson) {
            JSONObject itemJson = (JSONObject) itemObj;
            String name = (String) itemJson.get("name");
            String description = (String) itemJson.get("description");
            long price = (long) itemJson.get("price");
            items.add(new Item(name, description, (int) price));
        }
        return items;
    }

    /**
     * @author CADE STOCKER
     * @param language
     * @return
     * Helper method
     */
    private static Languages mapLanguage(String language) {
        if (language == null)
            return Languages.DEFAULT;
        language = language.toLowerCase();
        switch (language) {
            case "spanish":
                return Languages.SPANISH;
            case "french":
                return Languages.FRENCH;
            case "german":
                return Languages.GERMAN;
            case "japanese":
                return Languages.JAPANESE;
            case "korean":
                return Languages.KOREAN;
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
     * Helper method for creating the user once you've found all of their
     * data
     */
    private static User createUser(String userID, String username, String password,
            long coinsEarned, long coinBalance, ArrayList<String> friendsList,
            ArrayList<String> items, HashMap<Languages, Double> userProgress,
            ArrayList<String> languages,
            String currentLanguage, String dictionaryID) {

        User user = new User(username, password);
        user.setID(UUID.fromString(userID));
        user.setCoinsEarned((int) coinsEarned);
        user.setCoinBalance((int) coinBalance);
        user.setUserDictionaryID(UUID.fromString(dictionaryID));

        // want to change to work by uuid TODO
        user.setFriendsList(friendsList);

        // want to change this to load items by UUIDs TODO
        ArrayList<UUID> finalItems = new ArrayList();
        for (String s : items) {
            finalItems.add(UUID.fromString(s));
        }
        user.setItems(finalItems);

        user.setUserProgress(userProgress);
        // Decided to handle word of the day in the loadUser class
        ArrayList<UUID> languagesUUID = new ArrayList<>();
        for (String lang : languages) {
            languagesUUID.add(UUID.fromString(lang));
        }
        user.setLanguages(languagesUUID);
        if (languages.size() > 0)
            user.setCurrentLangaugeID(languagesUUID.get(0));

        user.setLanguageType(mapLanguage(currentLanguage));
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
        // JSONParser jsonParser = new JSONParser();

        // Parse the JSON file
        //JSONObject jsonObject = (JSONObject) jsonParser.parse(new FileReader(file));
        //JSONArray itemsArray = (JSONArray) jsonObject.get("items");

        //InputStream inputStream = DataLoader.class.getResourceAsStream(itemFile);
        //InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        //BufferedReader reader = new BufferedReader(inputStreamReader);
        BufferedReader reader = getReaderFromFile(itemFile, itemFileJunit);
        JSONObject root = (JSONObject) new JSONParser().parse(reader);
        JSONArray itemsArray = (JSONArray) root.get("items");
        //JSONArray itemsArray = (JSONArray) new JSONParser().parse(reader);

        // Iterate through each user object in the JSON array
        for (Object obj : itemsArray) {
            JSONObject userJson = (JSONObject) obj;

            // Extract basic user data
            String name = (String) userJson.get("name");
            String description = (String) userJson.get("description");
            long price = (long) userJson.get("price");

            // Create and configure User object
            Item item = new Item(name, description, (int) price);
            items.add(item); // Add the fully created user to the list
        }
        reader.close();
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
     * Read multiple words and turn
     * them into an arraylist
     */
    public static ArrayList<Word> loadWords(String file)
            throws FileNotFoundException, IOException, ParseException, org.json.simple.parser.ParseException {

        ArrayList<Word> words = new ArrayList<>();
        //JSONParser jsonParser = new JSONParser();

        // Parse the JSON file
        //JSONObject jsonObject = (JSONObject) jsonParser.parse(new FileReader(file));
        //JSONArray wordsArray = (JSONArray) jsonObject.get("words");

        //InputStream inputStream = DataLoader.class.getResourceAsStream(wordFile);
        //InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        //BufferedReader reader = new BufferedReader(inputStreamReader);
        BufferedReader reader = getReaderFromFile(wordFile, wordFileJunit);
        JSONObject object = (JSONObject) new JSONParser().parse(reader);
        JSONArray wordsArray = (JSONArray) object.get("words");

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
            Word createdWord = new Word();
            // Had to change this because constructor for word was changed
            createdWord.setWord(word);
            createdWord.setTimesCorrect((int) timesCorrect);
            createdWord.setTimesPresented((int) timesPresented);
            createdWord.setUserUnderstanding(userUnderstanding);
            createdWord.setLanguage(lang);

            words.add(createdWord); // Add the fully created user to the list
        }
        reader.close();
        return words;
    }

    /**
     * @author CADE STOCKER
     * @param file
     * @return a hashmap of languages
     * @throws Exception
     */
    public static ArrayList<Language> loadLanguages(String file) throws Exception {
        ArrayList<Language> languages = new ArrayList<Language>();
        //JSONParser parser = new JSONParser();
        //JSONObject root = (JSONObject) parser.parse(new FileReader(file));
        //JSONArray list = (JSONArray) root.get("languages");

        // NEW WAY THAT SHOULD WORK WITH JUNIT
        //InputStream inputStream = DataLoader.class.getResourceAsStream(languageFile);
        //InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        //BufferedReader reader = new BufferedReader(inputStreamReader);
        BufferedReader reader = getReaderFromFile(languageFile, languageFileJunit);
        JSONObject root = (JSONObject) new JSONParser().parse(reader);
        // get the array from the object
        JSONArray list = (JSONArray) root.get("languages");
        //JSONArray list = (JSONArray) new JSONParser().parse(reader);

        for (Object key : list) {
            languages.add(parseLanguage((JSONObject) key));
        }
        reader.close();
        return languages;
    }

    /**
     * @author CADE STOCKER
     * @param languageJson
     * @param languageName
     * @return language object
     * Read a single language object
     */
    private static Language parseLanguage(JSONObject languageJson) {
        UUID userID = UUID.fromString((String) languageJson.get("userID"));
        String placementTest = (String) languageJson.get("PlacementTest");
        int pointsEarned = ((Long) languageJson.get("pointsEarned")).intValue();
        int totalPoints = ((Long) languageJson.get("totalPoints")).intValue();
        double progress = (double) languageJson.get("progress");
        UUID languageID = UUID.fromString((String) languageJson.get("languageID"));

        int answerStreak = ((Long) languageJson.get("answerStreak")).intValue();
        String langName = (String) languageJson.get("languageName");

        Language lang = new Language();
        // LOAD IN PT IN LOADUSERS
        lang.setPlacementTestID(UUID.fromString(placementTest));
        lang.setLanguageID(languageID);
        lang.setUserID(userID);
        lang.setPointsEarned(pointsEarned);
        lang.setTotalPoints(totalPoints);
        lang.setUserProgress(progress);
        lang.setAnswerStreak(answerStreak);
        lang.setLanguageName(mapLanguage(langName));
        ArrayList<Section> sec = parseSections((JSONArray) languageJson.get("sections"));
        lang.setSections(sec);
        return lang;
    }

    private static ArrayList<Section> parseSections(JSONArray sections) {
        ArrayList<Section> sec = new ArrayList<>();
        for (Object obj : sections) {
            JSONObject objJson = (JSONObject) obj;
            Section s = new Section();
            s.setName((String) objJson.get("sectionName"));
            s.setID(UUID.fromString((String) objJson.get("sectionUUID")));
            JSONArray lessons = (JSONArray) objJson.get("lessons");
            s.setLessons(parseLessons(lessons));
            sec.add(s);
        }
        return sec;
    }

    private static ArrayList<Lesson> parseLessons(JSONArray lessons) {
        ArrayList<Lesson> les = new ArrayList<>();
        for (Object obj : lessons) {
            JSONObject objJson = (JSONObject) obj;
            Lesson l = new Lesson();
            l.setLessonName((String) objJson.get("lessonName"));
            l.setLessonID(UUID.fromString((String) objJson.get("lessonUUID")));
            l.setLanguageID(UUID.fromString((String) objJson.get("languageID")));
            les.add(l);
            //System.out.println(l.getLessonName());
        }
        //System.out.println("TESTSDLKFJDSL:KGJ   " + (les == null));
        return les;
    }

    public static ArrayList<Dictionary> loadDictionaries(String file)
            throws FileNotFoundException, IOException, org.json.simple.parser.ParseException {
        
        ArrayList<Dictionary> dictionaries = new ArrayList<>();
        //JSONParser jsonParser = new JSONParser();

        // Parse the JSON file
        //JSONObject jsonObject = (JSONObject) jsonParser.parse(new FileReader(file));
        //JSONArray dictionaryArray = (JSONArray) jsonObject.get("dictionaries");

        // NEW WAY TO WORK WITH JUNIT
        //InputStream inputStream = DataLoader.class.getResourceAsStream(dictionaryFile);
        //InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        //BufferedReader reader = new BufferedReader(inputStreamReader);
        BufferedReader reader = getReaderFromFile(dictionaryFile, dictionaryFileJunit);
        JSONObject root = (JSONObject) new JSONParser().parse(reader);
        JSONArray dictionaryArray = (JSONArray) root.get("dictionaries");

        for (Object o : dictionaryArray) {
            JSONObject obj = (JSONObject) o;
            Dictionary d = parseDictionary(obj);
            dictionaries.add(d);
        }
        reader.close();
        return dictionaries;
    }

    /**
     * @author CADE STOCKER
     * @param dictionaryJson
     * @return dictionary
     *         read a dictionary object
     */
    private static Dictionary parseDictionary(JSONObject dictionaryJson) {
        ArrayList<Word> dictionary = new ArrayList<>();
        JSONArray words = (JSONArray) dictionaryJson.get("words");
        for (Object o : words) {
            JSONObject wordObj = (JSONObject) o;
            Word w = makeWord(wordObj);
            dictionary.add(w);
            //System.out.println(w.toString());
        }

        int numWords;
        if (dictionaryJson.get("numberOfWords") == null) {
            numWords = 0;
        } else {
            numWords = ((Long) dictionaryJson.get("numberOfWords")).intValue();
        }

        UUID id = UUID.fromString((String) dictionaryJson.get("dictionaryID"));
        Dictionary retDictionary = new Dictionary(dictionary, numWords);
        retDictionary.setID(id);

        return retDictionary;
    }

    // Need to talk about this with team to get it sorted before reading
    /**
     * @author CADE STOCKER
     * @param media
     * @return Media
     *         read an individual media object
     */

    /*private static Media parseMedia(JSONObject media) {
        String name = (String) media.get("name");
        String description = (String) media.get("description");
        String fileName = (String) media.get("fileName");
        // Media med = new Media();
        // return med;
        return null;
    }*/

    /**
     * @author CADE STOCKER
     * @param sectionAccessJson
     * @return
     *         Read whether the user has access to each section in the json
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
        String word = (String) obj.get("word");
        String englishVersion = (String) obj.get("englishVersion");
        UUID lessonID = UUID.fromString((String) obj.get("lessonUUID"));

        UUID wordID = UUID.fromString((String) obj.get("wordUUID"));

        int timesPresented;
        if (obj.get("timesPresented") == null) {
            timesPresented = 0;
        } else {
            timesPresented = ((Long) obj.get("timesPresented")).intValue();
        }

        int points;
        if (obj.get("points") == null) {
            points = 0;
        } else {
            points = ((Long) obj.get("points")).intValue();
        }

        int timesCorrect;
        if (obj.get("timesCorrect") == null) {
            timesCorrect = 0;
        } else {
            timesCorrect = ((Long) obj.get("timesCorrect")).intValue();
        }

        double userUnderstanding;
        if (obj.get("userUnderstanding") == null) {
            userUnderstanding = 0;
        } else {
            userUnderstanding = (double) obj.get("userUnderstanding");
        }

        Word w = new Word(language, word, englishVersion, lessonID, wordID);
        w.setTimesCorrect(timesCorrect);
        w.setPoints(points);
        w.setTimesPresented(timesPresented);
        w.setUserUnderstanding(userUnderstanding);
        return w;
    }
}