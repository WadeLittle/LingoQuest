package dataloader_package;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class DataLoader {
    // Method to load data from JSON into ArrayList of User2 objects
    public static ArrayList<User2> loadData(String filePath) {
        ArrayList<User2> dataList = new ArrayList<>();
        Gson gson = new Gson();

        // Debugging: Print message before file reading
        System.out.println("Attempting to read the JSON file: " + filePath);

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
                // Define the type for the list of User2 objects
                Type listType = new TypeToken<ArrayList<User2>>() {}.getType();

                // Debugging: Print message before deserialization
                System.out.println("Starting deserialization...");

                // Perform deserialization
                dataList = gson.fromJson(newReader, listType);

                // Debugging: Print message after deserialization
                System.out.println("Deserialization complete. Loaded data:");
                for (User2 user : dataList) {
                    System.out.println(user.getUserID()+ " " + user.getUsername()+ " "+user.getPassword());  // Print each User2 object
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return dataList;
    }

    public static void main(String[] args) {
        // Example usage
        String filePath = "/Users/cadestocker/Desktop/Fall 24/247/Group Project/LingoQuest/DataLoader/dataloader/src/main/java/dataloader_package/Users.json"; // JSON file containing User2 objects
        ArrayList<User2> users = loadData(filePath);

        // Print loaded data
        System.out.println("Final user list:");
        for (User2 user : users) {
            System.out.println(user.toString());
        }
    }
}
