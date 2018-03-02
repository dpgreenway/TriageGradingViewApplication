package cs345.bsu.edu.greenway.triage.project;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TriageGradeAnalyzerTest {

    private TriageGradeAnalyzer analyzer;

    @Before
    public void createAnalyzer() {
        analyzer = new TriageGradeAnalyzer(3, 3);
    }

    @Test
    public void testCreateA(){
        analyzer.setNumerator(3);
        analyzer.setDenominator(3);
        assertEquals("A", analyzer.calculateAssignmentGrade());
    }

    @Test
    public void testCreateB(){
        analyzer.setNumerator(7);
        analyzer.setDenominator(9);
        assertEquals("B", analyzer.calculateAssignmentGrade());
    }

    @Test
    public void testCreateC(){
        analyzer.setNumerator(2);
        analyzer.setDenominator(3);
        assertEquals("C", analyzer.calculateAssignmentGrade());
    }

    @Test
    public void testCreateD(){
        analyzer.setNumerator(1);
        analyzer.setDenominator(2);
        assertEquals("D", analyzer.calculateAssignmentGrade());
    }

    @Test
    public void testCreateF(){
        TriageGradeAnalyzer analyzer = new TriageGradeAnalyzer(0, 3);
        assertEquals("F", analyzer.calculateAssignmentGrade());
    }

    @Test
    public void testLargeDivisibleBy3(){
        analyzer.setDenominator(33);
        analyzer.setNumerator(11);
        assertEquals("D", analyzer.calculateAssignmentGrade());
    }

    @Test
    public void testLargerThanDenominatorIsAnA(){
        analyzer.setDenominator(33);
        analyzer.setNumerator(34);
        assertEquals("A", analyzer.calculateAssignmentGrade());
    }



}