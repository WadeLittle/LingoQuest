package lingo_quest;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

class DataWriter {
    private String filePath;
    private ItemShop itemShop;
    private Users users;
    private LanguageManager languageManager;
    public static String userFile = "/Users/cadestocker/Desktop/Fall 24/247/Group Project/LingoQuest/correct_structure/src/json/Users.json";
    public static String itemFile = "/Users/cadestocker/Desktop/Fall 24/247/Group Project/LingoQuest/correct_structure/src/json/ItemShop.json";
    public static String placementFile = "/Users/cadestocker/Desktop/Fall 24/247/Group Project/LingoQuest/correct_structure/src/json/PlacementTest.json";
    public static String wordFile = "/Users/cadestocker/Desktop/Fall 24/247/Group Project/LingoQuest/correct_structure/src/json/Word.json";
    public static String dictionaryFile = "/Users/cadestocker/Desktop/Fall 24/247/Group Project/LingoQuest/correct_structure/src/json/Dictionaries.json";

    /**
     * @author cade
     * @return file path
     */
    public static String getUserFile() {
        return userFile;
    }

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



    public void writeData(File fileName) {
    }

    /*public void userLogout() {
        
    }*/

    public static void writeUsers(ArrayList<User> users, String file) {
        // Object that holds everything
        JSONObject root = new JSONObject();
        // the array of users
        JSONArray usersArray = new JSONArray();

        // serialize each user in users class
        for (User user : users) {
            usersArray.add(serializeUser(user));
        }

        // put all of the serialized users into the array
        root.put("users", usersArray);

        // write the whole user json file
        try (FileWriter writer = new FileWriter(file)) {
            writer.write(root.toJSONString());
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // turns the user into a jsonObject
    private static JSONObject serializeUser(User user) {
        // make new json object
        JSONObject userJson = new JSONObject();
        // this should put these variables in order but isn't
        userJson.put("userID", user.getUUID().toString());
        userJson.put("username", user.getUsername());
        userJson.put("password", user.getPassword());
        userJson.put("coinsEarned", user.getCoinsEarned());
        userJson.put("coinBalance", user.getCoinBalance());

        // Friends List
        JSONArray friendsArray = new JSONArray();
        // turns the list of UUIDs into a list of strings to be stored in the json
        for (UUID friendID : user.getFriendsList()) {
            friendsArray.add(friendID.toString());
        }
        userJson.put("friendsList", friendsArray);

        userJson.put("dictionaryID", user.getUserDictionaryID().toString());

        // Items
        JSONArray itemsArray = new JSONArray();
        for (UUID item : user.getItems()) {
            itemsArray.add(item.toString());
            //JSONObject itemJson = new JSONObject();
            //itemJson.put("name", item.getName());
            //itemJson.put("description", item.getDescription());
            //itemJson.put("price", item.getPrice());
            //itemsArray.add(itemJson);
        }
        userJson.put("items", itemsArray);

        // Bookmarked Lessons
        //JSONArray lessonsArray = new JSONArray(user.getBookmarkedLessons());
        //userJson.put("bookmarkedLessons", lessonsArray);

        // User Progress
        //JSONObject progressJson = new JSONObject();

        // NEED TO EVALUATE WITH TEAM ABOUT HOW TO DEAL WITH PROGRESS (WE DON'T NEED
        //THIS FEATURE


        //progressJson.put("language", user.getUserProgress().getLanguage());
        //progressJson.put("points", user.getUserProgress().getPoints());
        //userJson.put("userProgress", progressJson);

        //userJson.put("answerStreak", user.getAnswerStreak());

        if(user.getWordOfTheDay() != null)
            userJson.put("wordOfTheDay", serializeWord(user.getWordOfTheDay()));

        // Languages
        JSONArray languagesArray = new JSONArray();
        for (UUID languageID : user.getLanguages()) {
            languagesArray.add(languageID.toString());
        }
        userJson.put("languages", languagesArray);

        if(user.getCurrentLanguage() != null)
            userJson.put("currentLanguage", user.getCurrentLanguage().toString());

        return userJson;
    }

    public static void writeWords(ArrayList<Word> words, String file) {
        JSONObject root = new JSONObject();
        JSONArray wordsArray = new JSONArray();

        for (Word word : words) {
            wordsArray.add(serializeWord(word));
        }

        root.put("words", wordsArray);

        try (FileWriter writer = new FileWriter(file)) {
            writer.write(root.toJSONString());
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * @author Cade Stocker
     * @param word
     * @return a jsonObject created from the word
     */
    private static JSONObject serializeWord(Word word) {
        JSONObject wordJson = new JSONObject();
        if(word.getLanguage() != null) {
            wordJson.put("language", word.getLanguage().toString());
            wordJson.put("timesPresented", word.getTimesPresented());
            wordJson.put("word", word.getWord());
            wordJson.put("timesCorrect", word.getTimesCorrect());
            wordJson.put("userUnderstanding", word.getUserUnderstanding());
            wordJson.put("englishVersion", word.getEnglishVersion());
        }
        return wordJson;
    }

    /**
     * @author Cade
     * @param test
     * @param file
     * turn a placement test object into json object
     */
    public static void writePlacementTest(PlacementTest test, String file) {
        JSONObject root = new JSONObject();
        root.put("PlacementTest", serializePlacementTest(test));

        try (FileWriter writer = new FileWriter(file)) {
            writer.write(root.toJSONString());
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * @author Cade
     * @param test
     * @return jsonObject created from a placement test
     */
    private static JSONObject serializePlacementTest(PlacementTest test) {
        JSONObject testJson = new JSONObject();
        JSONArray questionsArray = new JSONArray();

        // serialize each question in the test
        for (Question question : test.getQuestions()) {
            questionsArray.add(serializeQuestion(question));
        }

        // other data to be stored
        testJson.put("questions", questionsArray);
        testJson.put("correctAnswers", test.getCorrectAnswers());
        testJson.put("score", test.getScore());

        // return the json object
        return testJson;
    }

    /**
     * @author cade
     * @param question
     * @return jsonObject created from question object
     */
    private static JSONObject serializeQuestion(Question question) {
        JSONObject questionJson = new JSONObject();
        // NEED HELP FIGURING OUT QUESTIONTYPE TODO
        //questionJson.put("questionType", question.getQuestionType());
        questionJson.put("question", question.getQuestion());
        ArrayList<Word> answerChoices = question.getAnswerChoices();
        // ArrayList<String> stringAnswerChoices = new ArrayList();
        JSONArray answerChoicesArray = new JSONArray();
        // serialize each answer choice so that we can track their data
        for(Word w : answerChoices) {
            if(w != null)
                answerChoicesArray.add(serializeWord(w));
        }
        questionJson.put("answerChoices", answerChoicesArray);
        questionJson.put("correctAnswer", question.getCorrectAnswer());
        questionJson.put("userAnswer", question.getUserAnswer());
        questionJson.put("pointValue", question.getPointValue());
        questionJson.put("coinValue", question.getCoinValue());

        return questionJson;
    }

/*   public static void main(String[] args) {
        Word word = new Word("doctor");
        Word word2 = new Word("professor");
        word.setLanguage(Languages.SPANISH);
        word.setTimesCorrect(4);
        word.setTimesPresented(3);
        word.setUserUnderstanding(.3);

        word2.setLanguage(Languages.SPANISH);
        word2.setTimesCorrect(5);
        word2.setTimesPresented(1);
        word2.setUserUnderstanding(.9);

        ArrayList<Word> list = new ArrayList<>();
        list.add(word);
        list.add(word2);
        writeWords(list,"/Users/cadestocker/Desktop/Fall 24/247/Group Project/LingoQuest/correct_structure/src/json/wordtest.json");

        PlacementTest pt = new PlacementTest();
        pt.setID(UUID.randomUUID());
        writePlacementTest(pt, "/Users/cadestocker/Desktop/Fall 24/247/Group Project/LingoQuest/correct_structure/src/json/placementtestfile.json");


        User u1 = new User("joeshmasdfasdoe","a;lskjhjhjfjfJJJ*(8)");
        u1.setCoinBalance(5);
        u1.setCoinsEarned(2);
        u1.setCurrentLanguage(Languages.FRENCH);
        u1.setID(UUID.randomUUID());

        User u2 = new User("dodskfjasdfg","Abdfs134kjkj@");
        u2.setCoinBalance(5);
        u2.setCoinsEarned(3);
        u2.setCurrentLanguage(Languages.SPANISH);
        u2.setID(UUID.randomUUID());

        ArrayList<User> users = new ArrayList();
        users.add(u1);
        users.add(u2);
        writeUsers(users,"/Users/cadestocker/Desktop/Fall 24/247/Group Project/LingoQuest/correct_structure/src/json/usertest.json");

        Item item1 = new Item("hat","bluehat",2);
        Item item2 = new Item("shoe","big shoe",5);
        ArrayList<Item> itemList = new ArrayList();
        itemList.add(item1);
        itemList.add(item2);
        writeItems(itemList,"/Users/cadestocker/Desktop/Fall 24/247/Group Project/LingoQuest/correct_structure/src/json/itemTest.json");
    }
        */

    public static void writeItems(ArrayList<Item> items,String file) {
        JSONArray itemsArray = new JSONArray();
        for (Item item : items) {
            JSONObject itemJson = new JSONObject();
            itemJson.put("name", item.getName());
            itemJson.put("description", item.getDescription());
            itemJson.put("price", item.getPrice());
            itemsArray.add(itemJson);

            try (FileWriter writer = new FileWriter(file)) {
                writer.write(itemsArray.toJSONString());
                writer.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void writeLanguages(ArrayList<Language> languages, String file) {
        JSONArray langArray = new JSONArray();
        for(Language l : languages) {

        }
    }

    /**
     * @author cade
     * @param dictionaries
     * @param file
     */
    public static void writeDictionaries(ArrayList<Dictionary> dictionaries, String file) {
        // make the object that holds the whole file's content
        JSONObject root = new JSONObject();
        // make an array to hold each dictionary
        JSONArray jsonDictionaries = new JSONArray();
        // turn each dictionary into an object and add to array
        for(Dictionary d : dictionaries) {
            jsonDictionaries.add(serializeDictionary(d));
        }
        // put the array in root
        root.put("dictionaries", jsonDictionaries);
        // write to the file
        try (FileWriter writer = new FileWriter(file)) {
            writer.write(root.toJSONString());
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * @author cade
     * @param d
     * @return the dictionary jsonobject
     */
    public static JSONObject serializeDictionary(Dictionary d) {
        // dictionary object
        JSONObject root = new JSONObject();
        // array of words
        JSONArray wordArray = new JSONArray();
        // make each word into jsonobject then add to array
        for(Word w : d.getWords()) {
            JSONObject obj = serializeWord(w);
            wordArray.add(obj);
        }
        // put the array into the dictionary object
        root.put("words",wordArray);
        return root;
    }

}