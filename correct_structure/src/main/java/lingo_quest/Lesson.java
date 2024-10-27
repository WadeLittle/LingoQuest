package lingo_quest;

import java.util.ArrayList;
import java.util.Random;
import java.util.UUID;

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

    public Lesson() {
        languageUUID = null;
        pointsEarned = 0;
        totalPoints = 0;
        lessonProgress = 0;
        topicWords = null;
        lessonName = "";
        lessonUUID = null;
    }

    public void setTopicWords(User u) {
        this.topicWords = u.getUserDictionary().getWordsByTopicID(this.lessonUUID);
    }

    public void setTopicWordsByList(ArrayList<Word> w) {
        if(w != null) {
            this.topicWords = w;
        }
    }

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
<<<<<<< HEAD
        //return LanguageManager.getInstance().getLanguageByID(languageUUID).getLanguageName().toString();
    }

    /**
     * @author cade
     * @param n
     */
    public void setLanguageName(String n) {
        if(n != null)
            this.languageName = n;
    }

    /**
     * @author Wade Little
     * Gets the question at the specified question number from the questions list
     * @param questionNum The question number you want to get
     * @return A question
     */
    public Question getQuestion() {
        Question question = questions.get(questionNum);
        this.questionNum++;
        return question;
    }

    public void halfwayCompleteReward() {

=======
>>>>>>> db21abb0812c7f447acaaa10f9ad40d3ff824548
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
