package lingo_quest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

import org.json.simple.parser.ParseException;

public class DictionaryManager {
    private ArrayList<Dictionary> dictionaries;
    private static DictionaryManager managerObject;
    private final UUID spanishDictionary = UUID.fromString("3a8be850-f88e-443a-a130-df157f779ac0");

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
        if (managerObject == null) {
            managerObject = new DictionaryManager(); // Assign the instance to the static field
        }
        return managerObject;
    }

    /**
     * @author cade
     * @param d
     * add a dictionary to the arraylist
     */
    public void addDictionary(Dictionary d) {
        dictionaries.add(d);
        //System.out.println("Adding: " + d.getID().toString() + "in actual list");
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
        for(Dictionary d : dictionaries) {
            if(d.getID().equals(id)) {
                dictionaries.remove(d);
                return;
            }
        }
    }

    /**
     * @author cade
     * calls to the dataloader and lets it do the work
     */
    public void loadDictionaries() {
        try {
            //this.dictionaries = DataLoader.loadDictionaries(DataLoader.getDictionaryFile());
            ArrayList<Dictionary> list = DataLoader.loadDictionaries(DataLoader.getDictionaryFile());
            //System.out.println("this many dictionaries: "+list.size());
            for(Dictionary d : list) {
                //System.out.println("Adding " + d.getID() + " " + d.getNumberOfWords());
                this.addDictionary(d);
            }
            //System.out.println("ADDRESS OF DICTIONARY ARRAY" + this.dictionaries);
            //for(Dictionary d : this.dictionaries) {
            //    System.out.println("ALLLLLKJDLKFJDSKLJFLKSDHGKL" + d.getID()+ " " + d.getNumberOfWords());
            //}
        } catch (IOException | ParseException e) {
            // TODO Auto-generated catch block
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
        //System.out.println("ADDRESS 2: " + this.dictionaries);
        for(Dictionary d : this.dictionaries) {
            //System.out.println("TLSDJGLKSJLKSDJLK  " + d.getID());
            if(d.getID().equals(id))
                return d;
        }
        System.out.println(id.toString()+ ": Dictionary doesn't exist.");
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
        if(id != null && getDictionaryByID(id) != null) {
            for(Word w : getDictionaryByID(id).getWords()) {
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
