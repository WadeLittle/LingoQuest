package lingo_quest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.text.ParseException;
import java.util.ArrayList;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.annotations.SerializedName;

import software.amazon.awssdk.regions.servicemetadata.ThinclientServiceMetadata;

public class DataLoader {

    public static ArrayList<User> loadUsers(String file) throws FileNotFoundException, IOException, ParseException, org.json.simple.parser.ParseException {
        JSONParser jsonparse = new JSONParser();

        // parsing the content of the JSON file
        JSONObject jsonObject = (JSONObject) jsonparse.parse(new FileReader(file));
        // reading the data
        System.out.println(jsonObject.toString());
        String id = (String) jsonObject.get("username");
        System.out.println("id" + id);
        User u = new User();
        u.setUsername(id);
        ArrayList<User> users = new ArrayList<User>();
        users.add(u);
        System.out.println(u.getUsername());
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