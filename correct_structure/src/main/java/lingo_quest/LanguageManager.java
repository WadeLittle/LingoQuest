package lingo_quest;

import java.util.ArrayList;
import java.util.UUID;

public class LanguageManager {
    private ArrayList<Language> languages;  // Corrected to match UML
    private static LanguageManager languageManager;

    // Singleton method
    public static LanguageManager getInstance() {
        if (languageManager == null) {
            languageManager = new LanguageManager();
        }
        return languageManager;
    }

    // Method to get the list of languages
    public ArrayList<Language> getLanguages() {
        return languages;  // Stub return to match expected behavior
    }

    // Method to add a section to a language
    public void addSection(Section section, Language language) {
        // Stub implementation
    }

    // Method to add a lesson to a section in a language
    public void addLesson(Lesson lesson, Section section, Language language) {
        // Stub implementation
    }

    // Method to add a language
    public void addLanguage(Language language) {
        // Stub implementation
    }

    // Method to load languages
    public void loadLanguages() {
        // Stub implementation
    }

    // Method to save languages
    public void saveLanguages() {
        // Stub implementation
    }

    public Language getLanguageByID(UUID id) {
        if(this.languages != null) {
            for(Language l : languages) {
                if(l.getUUID().equals(id))
                    return l;
            }
            System.out.println("Language not found.");
            return null;
        }
        System.out.println("List of languages is empty in LanguageManager");
        this.languages = new ArrayList<Language>();
        return null;
    }
}

