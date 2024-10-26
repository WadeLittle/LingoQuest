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

    public Lesson() {
        languageUUID = null;
        pointsEarned =0;
        totalPoints =0;
        lessonProgress = 0;
        topicWords = null;
        lessonName = "";
        lessonUUID = null;
    }

    public void setTopicWords(User u) {
        this.topicWords = u.getUserDictionary().getWordsByTopicID(this.lessonUUID);
    }

    public void updateProgress() {
         this.lessonProgress = this.pointsEarned/this.totalPoints;
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
        if(id != null)
            this.lessonUUID = id;
    }

    public Lesson( String lessonName,UUID languageUUID, UUID lessonUUID) {
        this.languageUUID = languageUUID;
        pointsEarned = 0;
        totalPoints = getTotalPoints();
        lessonProgress = getLessonProgress();
        //MISSING TOPIC WORDS
        this.lessonName = lessonName;
        this.lessonUUID = lessonUUID;
    }

    public String getLessonName() {
        return lessonName;
    }
    public int getTotalPoints() {
        return topicWords.size() * 300; 
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
        if(id != null)
            this.languageUUID = id;
    }

    public void awardForCompletion(User user) {

    }
    
    public String getLanguageName() {
        return LanguageManager.getInstance().getLanguageByID(languageUUID).getLanguageName().toString();
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

    }

    /**
     * @author cade stocker
     * @return lesson's coin value
     */
    //public int getCoinValue() {
    //    return this.coinValue;
    //}

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
        this.updateProgress();
    }

    /**
     * set the lesson's progress
     * @param progress
     */
    public void setLessonProgress(double progress) {
        this.lessonProgress = progress;
    }

    public void setLessonName(String name) {
        if(name != null)
            this.lessonName = name;
    }

    /**
     * @author cade stocker
     * @return the lesson progress
     */
    public double getLessonProgress(){
        this.updateProgress();
        return this.lessonProgress;
    }

    /**
     * Creates a question from the list of words
     * @return
     */
    public Question createQuestion() {

    }
    /**
     * NOT SURE
     * @return
     */
    public String presentQuestion(Question question) {

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
        while(words.size() < numOfWords) {
            int randomIndex = randomNum.nextInt(this.topicWords.size());
            Word aWord = this.topicWords.get(randomIndex);

            if(!words.contains(aWord)) {
                words.add(aWord);
            }
        }
        return words;
    }

    
}

