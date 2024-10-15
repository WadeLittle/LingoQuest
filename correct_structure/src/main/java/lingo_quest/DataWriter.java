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

    public void writeData(File fileName) {
    }

    public void userLogout() {
    }

    public static void writeUsers(ArrayList<User> users, String file) {
        JSONObject root = new JSONObject();
        JSONArray usersArray = new JSONArray();

        for (User user : users) {
            usersArray.add(serializeUser(user));
        }

        root.put("users", usersArray);

        try (FileWriter writer = new FileWriter(file)) {
            writer.write(root.toJSONString());
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static JSONObject serializeUser(User user) {
        JSONObject userJson = new JSONObject();
        userJson.put("userID", user.getUUID().toString());
        userJson.put("username", user.getUsername());
        userJson.put("password", user.getPassword());
        userJson.put("coinsEarned", user.getCoinsEarned());
        userJson.put("coinBalance", user.getCoinBalance());

        // Friends List
        JSONArray friendsArray = new JSONArray();
        for (UUID friendID : user.getFriendsList()) {
            friendsArray.add(friendID.toString());
        }
        userJson.put("friendsList", friendsArray);

        // Items
        JSONArray itemsArray = new JSONArray();
        for (Item item : user.getItems()) {
            JSONObject itemJson = new JSONObject();
            itemJson.put("name", item.getName());
            itemJson.put("description", item.getDescription());
            itemJson.put("price", item.getPrice());
            itemsArray.add(itemJson);
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
        userJson.put("wordOfTheDay", user.getWordOfTheDay());

        // Languages
        JSONArray languagesArray = new JSONArray();
        for (UUID languageID : user.getLanguages()) {
            languagesArray.add(languageID.toString());
        }
        userJson.put("languages", languagesArray);

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

    private static JSONObject serializeWord(Word word) {
        JSONObject wordJson = new JSONObject();
        wordJson.put("language", word.getLanguage().toString());
        wordJson.put("timesPresented", word.getTimesPresented());
        wordJson.put("word", word.getWord());
        wordJson.put("timesCorrect", word.getTimesCorrect());
        wordJson.put("userUnderstanding", word.getUserUnderstanding());

        return wordJson;
    }

    public static void writePlacementTest(PlacementTest test, String file) {
        JSONObject root = new JSONObject();
        root.put("spanishPlacementTest", serializePlacementTest(test));

        try (FileWriter writer = new FileWriter(file)) {
            writer.write(root.toJSONString());
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static JSONObject serializePlacementTest(PlacementTest test) {
        JSONObject testJson = new JSONObject();
        JSONArray questionsArray = new JSONArray();

        for (Question question : test.getQuestions()) {
            questionsArray.add(serializeQuestion(question));
        }

        testJson.put("questions", questionsArray);
        testJson.put("correctAnswers", test.getCorrectAnswers());
        testJson.put("score", test.getScore());

        return testJson;
    }

    private static JSONObject serializeQuestion(Question question) {
        JSONObject questionJson = new JSONObject();
        //questionJson.put("questionType", question.getQuestionType());
        questionJson.put("question", question.getQuestion());
        ArrayList<Word> answerChoices = question.getAnswerChoices();
        ArrayList<String> stringAnswerChoices = new ArrayList();
        for(Word w : answerChoices) {
            stringAnswerChoices.add(w.getWord());
        }
        questionJson.put("answerChoices", stringAnswerChoices);
        questionJson.put("correctAnswer", question.getCorrectAnswer());
        questionJson.put("userAnswer", question.getUserAnswer());
        questionJson.put("pointValue", question.getPointValue());
        questionJson.put("coinValue", question.getCoinValue());

        /*if (question.getQuestionType().equals("Matching")) {
            questionJson.put("answers", new JSONObject(question.getAnswers()));
            questionJson.put("userAnswer", new JSONObject(question.getUserAnswer()));
        }*/

        return questionJson;
    }

    public static void main(String[] args) {
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
        
    }
}