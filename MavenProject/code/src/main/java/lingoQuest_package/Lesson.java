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

    public Question getQuestion() {

        return questions.get(0);
    }

    public void halfwayCompleteReward() {

    }
}
