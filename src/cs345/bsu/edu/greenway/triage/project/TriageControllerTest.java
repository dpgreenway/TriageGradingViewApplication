package cs345.bsu.edu.greenway.triage.project;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TriageControllerTest {

    private TriageController controller;

    @Before
    public void createController(){
        controller = new TriageController();
    }

    @Test
    public void testEmptyInputIntoController(){
        assertEquals(false, controller.attemptToSetNums(null, null));
    }

    @Test
    public void testLettersInput(){
        assertEquals(false,controller.attemptToSetNums("1234f2", "123456"));
    }

    @Test
    public void testNotDivisibleBy3Input(){
        controller.attemptToSetNums("3", "7");
        assertEquals(false, controller.checkTriageGradingNumbers());
    }

    @Test
    public void testCorrect(){
        assertEquals(true, controller.attemptToSetNums("3", "6"));
    }

    @Test
    public void testCorrectDivisibleByThree(){
        controller.attemptToSetNums("3","3");
        assertEquals(true, controller.checkTriageGradingNumbers());
    }

    @Test
    public void testWhenZero(){
        controller.attemptToSetNums("3", "0");
        assertEquals(false, controller.checkTriageGradingNumbers());
    }

    @Test
    public void testDoubleZeros(){
        controller.attemptToSetNums("3", "00");
        assertEquals(false, controller.checkTriageGradingNumbers());
    }

}