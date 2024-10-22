package lingo_quest;

import java.util.ArrayList;
import java.util.UUID;

public class DictionaryManager {
    private ArrayList<Dictionary> dictionaries;
    private static DictionaryManager managerObject;

    /**
     * @author cade
     * private constructor for singleton
     */
    private DictionaryManager() {
        this.dictionaries = new ArrayList<>();
    }
    
    /**
     * @author cade
     * @return the instance of the class
     */
    public static DictionaryManager getInstance() {
        if(managerObject == null)
            return new DictionaryManager();
        else
            return managerObject;
    }

    /**
     * @author cade
     * @param d
     * add a dictionary to the arraylist
     */
    public void addDictionary(Dictionary d) {
        dictionaries.add(d);
    }

    /**
     * @author cade
     * @param id
     */
    public void removeDictionary(UUID id) {
        for(Dictionary d : dictionaries) {
            if(d.getID().equals(id)) {
                dictionaries.remove(d);
                return;
            }
        }
    }

    /**
     * @author cade
     * @param id
     * @return
     */
    public Dictionary getDictionaryByID(UUID id) {
        for(Dictionary d : dictionaries) {
            if(d.getID().equals(id))
                return d;
        }
        System.out.println("Dictionary doesn't exist.");
        return null;
    }
}
