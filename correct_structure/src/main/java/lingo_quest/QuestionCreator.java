package lingo_quest;



public class QuestionCreator {
    
    public Question makeQuestion(double wordValue){
        if (wordPoint <= 0) {
            return new MultipleChoice();
        } else if (wordPoint == 100) {
            return new FillInTheBlank();
        } else if (wordPoint >= 200) {
            return new Matching();
        }
        throw new IllegalArgumentException("Invalid wordPoint value");
    }

}
