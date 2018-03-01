package cs345.bsu.edu.greenway.triage.project;

public class TriageController {
    private int numerator;
    private int denominator;
    private int numberOfRetrievals;


    public void setNums (String numerator, String denominator){
        this.numerator = Integer.parseInt(numerator);
        this.denominator = Integer.parseInt(denominator);
    }

    public String getAnalyzedGrade(){
        numberOfRetrievals++;
        TriageGradeAnalyzer analyzer = new TriageGradeAnalyzer(numerator, denominator);
        String analyzedGrade = analyzer.calculateAssignmentGrade();
        System.out.print("Controller " + analyzedGrade);
        return analyzedGrade;
    }

    public int getNumberOfRetrievals(){
        return numberOfRetrievals;
    }

}
