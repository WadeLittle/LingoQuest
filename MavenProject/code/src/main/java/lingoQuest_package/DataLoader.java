package lingoQuest_package;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class DataLoader {
    // Method to load data from JSON into ArrayList of User objects
    public static ArrayList<User> loadUsers(String filePath) {
        ArrayList<User> userList = new ArrayList<>();
        Gson gson = new Gson();

        // Debugging: Print message before file reading
        //System.out.println("Attempting to read the JSON file: " + filePath);

        try (FileReader reader = new FileReader(filePath);
             BufferedReader bufferedReader = new BufferedReader(reader)) {
            
            // Debugging: Print content of the file before deserialization
            //System.out.println("JSON content being read from file:");
            //String line;
            //while ((line = bufferedReader.readLine()) != null) {
                //System.out.println(line);  // Print each line from the file
            //}
            
            // Re-open the reader to avoid having to re-read the file (reset)
            try (FileReader newReader = new FileReader(filePath)) {
                // Define the type for the list of User objects
                Type listType = new TypeToken<ArrayList<User>>() {}.getType();

                // Debugging: Print message before deserialization
                System.out.println("Starting deserialization...");

                // Perform deserialization
                userList = gson.fromJson(newReader, listType);

                // Debugging: Print message after deserialization
                System.out.println("Deserialization complete. Loaded data:");
                for (User user : userList) {
                    System.out.println(user.toString());  // Print each User object
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return userList;
    }

    public static void main(String[] args) {
        // Example usage
        String filePath = "C:\\Users\\wdlit\\OneDrive\\Desktop\\CSCE247\\LingoQuest\\LingoQuest\\DataLoader\\dataloader\\src\\main\\java\\dataloader_package\\Users.json"; // JSON file containing User2 objects
        ArrayList<User2> users = loadData(filePath);

        // Print loaded data
        System.out.println("Final user list:");
        for (User user : users) {
            System.out.println(user.toString());
        }
    }
}
