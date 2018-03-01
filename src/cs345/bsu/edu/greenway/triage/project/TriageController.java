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
            System.out.println("This is not an integer value.");
            return false;
        }

    }

    public boolean checkTriageGradingNumbers(){
        return ((numerator <= denominator) && (denominator%3 == 0));
    }

    public void incrementAttemptedRetrievals(){
        numberOfRetrievals++;
    }

    public String getAnalyzedGrade(){
        incrementAttemptedRetrievals();
        TriageGradeAnalyzer analyzer = new TriageGradeAnalyzer(numerator, denominator);
        String analyzedGrade = analyzer.calculateAssignmentGrade();
        System.out.print("Controller " + analyzedGrade);
        return analyzedGrade;
    }


    public int getNumberOfRetrievals(){
        return numberOfRetrievals;
    }

}
