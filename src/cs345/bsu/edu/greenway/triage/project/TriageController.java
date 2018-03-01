package cs345.bsu.edu.greenway.triage.project;

public class TriageController {
    private int numerator;
    private int denominator;

    TriageController(String numerator, String denominator){
        this.numerator = Integer.parseInt(numerator);
        this.denominator = Integer.parseInt(denominator);
    }

    public String getAnalyzedGrade(){
        TriageGradeAnalyzer analyzer = new TriageGradeAnalyzer(numerator, denominator);
        String analyzedGrade = analyzer.calculateAssignmentGrade();
        System.out.print("Controller " + analyzedGrade);
        return analyzedGrade;
    }

}
