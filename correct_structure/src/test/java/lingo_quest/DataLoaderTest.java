package lingo_quest;

import static org.junit.jupiter.api.Assertions.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import org.json.simple.parser.JSONParser;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DataLoaderTest {
    private Users users = Users.getInstance();
    private ArrayList<User> userList = users.getUsers();
    private DictionaryManager dictionaryManager = DictionaryManager.getInstance();
    private ArrayList<Dictionary> dictionaryList = dictionaryManager.getDictionaries();
    private LanguageManager languageManager = LanguageManager.getInstance();
    private ArrayList<Language> languageList = languageManager.getLanguages();
    private ItemShop itemShop = ItemShop.getInstance();
    private ArrayList<Item> itemList = itemShop.getItems();

    @BeforeEach
    void setup() {
        
    }

    @AfterEach
    void tearDown() {
        // Cleanup after each test
    }
}
