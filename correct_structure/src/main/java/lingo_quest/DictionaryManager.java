package lingo_quest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

import org.json.simple.parser.ParseException;

public class DictionaryManager {
    private ArrayList<Dictionary> dictionaries;
    private static DictionaryManager managerObject;
    private final UUID spanishDictionary = UUID.fromString("eeaaed42-a1be-4477-bc7c-2f6f2be2993b");

    /**
     * @author cade
     *         private constructor for singleton
     */
    private DictionaryManager() {
        this.dictionaries = new ArrayList<>();
        loadDictionaries();
    }

    /**
     * @author cade
     * @return the instance of the class
     */
    public static DictionaryManager getInstance() {
        if (managerObject == null) {
            managerObject = new DictionaryManager(); // Assign the instance to the static field
        }
        return managerObject;
    }

    /**
     * @author cade
     * @param d
     *          add a dictionary to the arraylist
     */
    public void addDictionary(Dictionary d) {
        dictionaries.add(d);
    }

    /**
     * @author cade
     * @return the uuid of the master spanish dictionary
     */
    public UUID getSpanishDictionary() {
        return this.spanishDictionary;
    }

    /**
     * @author cade
     * @param id
     */
    public void removeDictionary(UUID id) {
        for (Dictionary d : dictionaries) {
            if (d.getID().equals(id)) {
                dictionaries.remove(d);
                return;
            }
        }
    }

    /**
     * @author cade
     *         calls to the dataloader and lets it do the work
     */
    public void loadDictionaries() {
        try {
            ArrayList<Dictionary> list = DataLoader.loadDictionaries(DataLoader.getDictionaryFile());
            for (Dictionary d : list) {
                if (!dictionaries.contains(d)) {
                    this.addDictionary(d);
                }
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }

    public void saveDictionary() {
        DataWriter.writeDictionaries(dictionaries, DataWriter.getDictionaryFile());
    }

    /**
     * @author cade
     * @param id
     * @return
     */
    public Dictionary getDictionaryByID(UUID id) {
        for (Dictionary d : this.dictionaries) {
            if (d.getID().equals(id))
                return d;
        }
        System.out.println(id.toString() + ": Dictionary doesn't exist.");
        return null;
    }

    /**
     * @author cade
     * @param u
     * @return the user's dictionary
     */
    public Dictionary getDictionaryByUser(User u) {
        return getDictionaryByID(u.getUserDictionaryID());
    }

    /**
     * @author cade
     * @param id
     * @return the duplicated dictionary
     */
    public Dictionary duplicateDictionary(UUID id) {
        Dictionary ret = new Dictionary();
        if (id != null && getDictionaryByID(id) != null) {
            for (Word w : getDictionaryByID(id).getWords()) {
                ret.addWord(w);
            }
            dictionaries.add(ret);
            System.out.println("\n\n\nTEST added dictionary\n\n\n");
            return ret;
        }
        System.out.println("Dictionary not found");
        return null;
    }
}
