package cs345.bsu.edu.greenway.triage.project;

public class TriageController {
    private int numerator;
    private int denominator;
    private String analyzedGrade;

    TriageController(String numerator, String denominator){
        this.numerator = Integer.parseInt(numerator);
        this.denominator = Integer.parseInt(denominator);
    }

    public String getAnalyzedGrade(){
        TriageGradeAnalyzer analyzer = new TriageGradeAnalyzer(numerator, denominator);
        analyzedGrade = analyzer.calculateAssignmentGrade();
        return analyzedGrade;
    }

}
