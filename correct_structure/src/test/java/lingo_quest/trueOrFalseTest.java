package lingo_quest;



import static org.junit.Assert.assertEquals;
import static org.junit.Assert.*;
import static org.junit.Test.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import lingo_quest.QuestionCreator;
import lingo_quest.TrueOrFalse;

public class trueOrFalseTest {
    
    @Test
    public void testSetUserAnswer() {

        TrueOrFalse t = new TrueOrFalse();
        t.setUserAnswer("hello");
        assertEquals("hello", t.userAnswer);
    
    }

}
