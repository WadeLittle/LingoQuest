package lingo_quest;

import java.util.ArrayList;

public class DictionaryManager {
    private ArrayList<Dictionary> dictionaries;
    private static DictionaryManager managerObject;

    private DictionaryManager() {
        this.dictionaries = new ArrayList<>();
    }
    
    public static DictionaryManager getInstance() {
        if(managerObject == null)
            return new DictionaryManager();
        else
            return managerObject;
    }

    public void addDictionary(Dictionary d) {
        dictionaries.add(d);
    }
}
