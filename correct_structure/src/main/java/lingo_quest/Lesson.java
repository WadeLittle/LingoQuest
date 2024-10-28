package lingo_quest;

import java.util.ArrayList;
import java.util.Random;
import java.util.UUID;
/**
 * Represents a lesson in a language learning application, containing a collection of words and managing progress.
 */
public class Lesson {
    private UUID languageUUID;
    private int pointsEarned;
    private int totalPoints;
    private double lessonProgress;
    public ArrayList<Word> topicWords;
    private int questionNum;
    private String lessonName;
    private UUID lessonUUID;
    public Question currentQuestion;
    private String languageName;
    /**
     * Default constructor initializing fields with default values and setting the language to Spanish.
     */
    public Lesson() {
        languageName = "Spanish";
        languageUUID = null;
        pointsEarned = 0;
        totalPoints = 0;
        lessonProgress = 0;
        topicWords = null;
        lessonName = "";
        lessonUUID = null;
    }
    /**
     * Sets the topic words for this lesson based on the user's dictionary and the lesson's UUID.
     * 
     * @param u The user from whose dictionary the words will be fetched.
     */
    public void setTopicWords(User u) {
        this.topicWords = u.getUserDictionary().getWordsByTopicID(this.lessonUUID);
    }
    /**
     * Sets the topic words for the lesson from a specified list, filtering out words presented more than once.
     * 
     * @param w List of words to be set as topic words.
     */
    public void setTopicWordsByList(ArrayList<Word> w) {
        ArrayList<Word> fin = new ArrayList();
        if(w != null) {
            for(Word word : w) {
                if(word.getTimesPresented() > 0)
                    fin.add(word);
            }
            this.topicWords = fin;
        }
    }
    /**
     * Updates the lesson's progress by calculating the ratio of points earned to total points.
     * Progress is updated based on the words' individual points contributing to the lesson's total points.
     */
    public void updateProgress() {
        // set to 0 before running the sum
        this.pointsEarned = 0;
        if (topicWords.size() > 0) {
            setTotalPoints(topicWords.size() * 300);
        }
        for (Word w : topicWords) {
            this.pointsEarned += w.getPoints();
        }
        System.out.println("pointsearned: " + this.pointsEarned + "\n\ntotalpoints: " + this.totalPoints);
        double quotient = (double) this.pointsEarned / (double) this.totalPoints;
        this.lessonProgress = 100 * (quotient);
    }

    /**
     * @author cade
     * @return the id of the lesson
     */
    public UUID getLessonID() {
        return this.lessonUUID;
    }

    /**
     * @author cade
     * @param id
     */
    public void setLessonID(UUID id) {
        if (id != null)
            this.lessonUUID = id;
    }

    public Lesson(String lessonName, UUID languageUUID, UUID lessonUUID) {
        this.languageUUID = languageUUID;
        pointsEarned = 0;
        totalPoints = getTotalPoints();
        lessonProgress = getLessonProgress();
        // MISSING TOPIC WORDS
        this.lessonName = lessonName;
        this.lessonUUID = lessonUUID;
    }

    public String getLessonName() {
        return lessonName;
    }

    public int getTotalPoints() {
        return this.totalPoints;
    }

    public int getPointsEarned() {
        return pointsEarned;
    }

    /**
     * @author cade
     * @return the id
     */
    public UUID getLanguageID() {
        return this.languageUUID;
    }

    /**
     * @author cade
     * @param id
     */
    public void setLanguageID(UUID id) {
        if (id != null)
            this.languageUUID = id;
    }

    public String getLanguageName() {
        // hardcoded TODO
        return "Spanish";
    }

    /**
     * @author cade stocker
     * @return lesson's coin value
     */

    /**
     * @author cade
     * @param points
     */
    public void setPointsEarned(int points) {
        this.pointsEarned = points;
        this.updateProgress();
    }

    /**
     * @author cade stocker
     * @param points
     */
    public void setTotalPoints(int points) {
        this.totalPoints = points;
    }

    /**
     * set the lesson's progress
     * 
     * @param progress
     */
    public void setLessonProgress(double progress) {
        this.lessonProgress = progress;
    }

    public void setLessonName(String name) {
        if (name != null)
            this.lessonName = name;
    }

    /**
     * @author cade stocker
     * @return the lesson progress
     */
    public double getLessonProgress() {
        this.updateProgress();
        return this.lessonProgress;
    }

    public Word getRandomWord() {
        Random randomNum = new Random();
        int randomIndex = randomNum.nextInt(this.topicWords.size());
        return this.topicWords.get(randomIndex);
    }

    public ArrayList<Word> getWords(Word word, int numOfWords) {
        ArrayList<Word> words = new ArrayList<>();
        words.add(word);

        Random randomNum = new Random();
        while (words.size() < numOfWords) {
            int randomIndex = randomNum.nextInt(this.topicWords.size());
            Word aWord = this.topicWords.get(randomIndex);

            if (!words.contains(aWord)) {
                words.add(aWord);
            }
        }
        return words;
    }

}
