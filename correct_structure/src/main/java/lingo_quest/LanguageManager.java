package lingo_quest;

import java.util.ArrayList;
import java.util.UUID;

public class LanguageManager {
    private ArrayList<Language> languages;  // Corrected to match UML
    private static LanguageManager languageManager;
    private Language currentLanguage;
    private Section currentSection;
    private Lesson currentLesson;
    private final String spanishDictionary = "eeaaed42-a1be-4477-bc7c-2f6f2be2993b";

    // Singleton method
    public static LanguageManager getInstance() {
        if (languageManager == null) {
            languageManager = new LanguageManager();
        }
        return languageManager;
    }

    /**
     * @author cade
     * @return the id of the spanish dicitonary
     */
    public String getSpanishDictionary() {
        return this.spanishDictionary;
    }

    // THIS PROBABLY ISN'T RIGHT AND SHOULD BE FIXED
    public void setCurrentLangauge(Language language) {
        this.currentLanguage = getLanguageByID(language.getLanguageID());
    }


    public Language getCurrentLanguage() {
        return currentLanguage;
    }
    public Section getCurrentSection() {
        return currentSection;
    }
    public Lesson getCurrentLesson() {
        return currentLesson;
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
        if(language != null)
            languages.add(language);
    }

    // Method to load languages
    public void loadLanguages() throws Exception {
        languages = DataLoader.loadLanguages(DataLoader.getLanguageFile());
    }

    /**
     * @author cade
     * calls on datawriter
     */
    public void saveLanguages() {
        DataWriter.writeLanguages(languages,DataWriter.getLanguageFile());
    }

    /**
     * @author cade
     * @param id
     * @return
     */
    public Language getLanguageByID(UUID id) {
        if(this.languages != null) {
            for(Language l : languages) {
                if(l.getLanguageID().equals(id)) {
                    this.currentLanguage = l;
                    return l;
                }
            }
            System.out.println("Language not found.");
            return null;
        }
        System.out.println("List of languages is empty in LanguageManager");
        this.languages = new ArrayList<Language>();
        return null;
    }

    public Section getSectionByID(UUID sectionId) {
        if (this.currentLanguage != null && this.currentLanguage.getSections() != null) {
            for (Section section : this.currentLanguage.getSections()) {
                if (section.getID().equals(sectionId)) {
                    this.currentSection = section;
                    return section; 
                }
            }
            System.out.println("Section not found in the current language.");
            return null;
        }
        System.out.println("Current language is not set or has no sections.");
        return null;
    }

    public Lesson getLessonByID(UUID lessonId, User u) {
        if (this.currentSection != null && this.currentSection.getAllLessons() != null) {
            
            for(Lesson l : this.currentSection.getAllLessons()) {
                l.setTopicWords(u);
            }


            for (Lesson lesson : this.currentSection.getAllLessons()) {
                if (lesson.getLessonID().equals(lessonId)) {
                    this.currentLesson = lesson; 
                    return lesson;  
                }
            }
            System.out.println("Lesson not found in the current section.");
            return null;
        }
        System.out.println("Current section is not set or has no lessons.");
        return null;
    }
}

