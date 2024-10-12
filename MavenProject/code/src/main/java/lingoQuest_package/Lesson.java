package lingoQuest_package;

import java.util.ArrayList;

public class Lesson {
    private int pointsEarned;
    private int totalPoints;
    private int coinValue;
    private double lessonProgress;
    private Dictionary topicDictionary;
    private ArrayList<Question> questions;

    public Lesson() {

    }

    public Lesson(int coinValue, int totalPoints) {

    }

    public void awardForCompletion(User user) {

    }
    /**
     * @author Wade Little
     * Gets the question at the specified question number from the questions list
     * @param questionNum The question number you want to get
     * @return A question
     */
    public Question getQuestion(int questionNum) {

        return questions.get(questionNum);
    }

    public void halfwayCompleteReward() {

    }
}
