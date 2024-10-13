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

    public static ArrayList<User> loadUsers(String file) throws FileNotFoundException, IOException, ParseException, org.json.simple.parser.ParseException {
        
        ArrayList<User> users = new ArrayList<User>();
        
        JSONParser jsonparse = new JSONParser();
        // parsing the content of the JSON file
        JSONObject jsonObject = (JSONObject) jsonparse.parse(new FileReader(file));
        // reading the data
        JSONArray usersArray = (JSONArray) jsonObject.get("users");
        for(Object obj : usersArray) {
            JSONObject userJson = (JSONObject) obj;
            String userID = (String) userJson.get("userID");
            String username = (String) userJson.get("username");
            String password = (String) userJson.get("password");
            long coinsEarned = (long) userJson.get("coinsEarned");
            long coinBalance = (long) userJson.get("coinBalance");
        
            // Extract friends list
            JSONArray friendsListJson = (JSONArray) userJson.get("friendsList");
            ArrayList<String> friendsList = new ArrayList<>();
            for (Object friend : friendsListJson) {
                friendsList.add((String) friend);
            }

            // Extract items
            JSONArray itemsJson = (JSONArray) userJson.get("items");
            ArrayList<Item> items = new ArrayList<>();
            for (Object itemObj : itemsJson) {
                JSONObject itemJson = (JSONObject) itemObj;
                String itemName = (String) itemJson.get("name");
                String description = (String) itemJson.get("description");
                long price = (long) itemJson.get("price");
                //items.add(new Item(itemName, description, price, owned));
                Item item = new Item(itemName,description,(int)price);
                //System.out.println(item.toString());
            }

            // EXTRACTING THE USER'S PROGRESS
            // Extract progress as a HashMap<String, Long>
            JSONObject progressJson = (JSONObject) userJson.get("userProgress");
            
            HashMap<Languages, Long> userProgress = new HashMap<>();

            // Loop through each entry in the userProgress JSON object
            for (Object key : progressJson.keySet()) {
                Object Olanguage = progressJson.get("language");
                String language = Olanguage.toString();
                //System.out.println("language at top of switch" + language);
                Languages keyLang = Languages.DEFAULT;
                language = language.toLowerCase();
                switch(language) {
                    case "spanish":
                        keyLang = Languages.SPANISH;
                        break;
                    case "french":
                        keyLang = Languages.FRENCH;
                        break;
                    case "german":
                        keyLang = Languages.GERMAN;
                        break;
                    case "japanese":
                        keyLang = Languages.JAPANESE;
                        break;
                    case "korean":
                        keyLang = Languages.KOREAN;
                        break;
                    default:
                        System.out.println("error reading language");
                        break;
                }
                // For points, I had to convert them to a string, and thn to a long
                Object points = progressJson.get("points");
                
                // Ensure the points value is properly cast to Long
                if (points instanceof Number) {
                    long lPoints = ((Number) points).longValue(); // Safe conversion to long
                    userProgress.put(keyLang, lPoints);
                    //System.out.println(points);
                } else {
                    System.out.println("Invalid points value for language: " + key);
                }
            }

            // Extract other fields
            String wordOfTheDay = (String) userJson.get("wordOfTheDay");
            JSONArray languagesJson = (JSONArray) userJson.get("languages");
            ArrayList<String> languages = new ArrayList<>(languagesJson);
            String currentLanguage = (String) userJson.get("currentLanguage");

            // Create User object and add to the list
            //User user = new User(userID, username, password, coinsEarned, coinBalance, friendsList,
            //                    items, userProgress, wordOfTheDay, languages, currentLanguage);
            User user = new User(username,password);
            UUID id = UUID.fromString(userID);
            user.setID(id);
            user.setCoinsEarned((int)coinsEarned);
            user.setCoinBalance((int)coinBalance);

            //users.add(user);
        }
        
        return users;
    }
    public static void main(String[] args) {
        try {
            loadUsers("LingoQuest/correct_structure/src/json/Users.json");
        } catch (IOException | ParseException | org.json.simple.parser.ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}