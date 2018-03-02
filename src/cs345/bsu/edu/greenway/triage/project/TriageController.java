package cs345.bsu.edu.greenway.triage.project;

public class TriageController {
    private int numerator;
    private int denominator;
    private int numberOfRetrievals;


    public boolean attemptToSetNums(String numerator, String denominator){
        try{
            this.numerator = Integer.parseInt(numerator);
            this.denominator = Integer.parseInt(denominator);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

    public boolean checkTriageGradingNumbers(){
        return (denominator%3 == 0) && (denominator != 0);
    }

    public void incrementAttemptedRetrievals(){
        numberOfRetrievals++;
    }

    public String getAnalyzedGrade(){
        incrementAttemptedRetrievals();
        TriageGradeAnalyzer analyzer = new TriageGradeAnalyzer(numerator, denominator);
        return analyzer.calculateAssignmentGrade();
    }

    public int getNumberOfRetrievals(){
        return numberOfRetrievals;
    }
}
