package cs345.bsu.edu.greenway.triage.project;

public class TriageGradeAnalyzer {

    private int numerator;
    private int denominator;

    TriageGradeAnalyzer(int numerator, int denominator){
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public String calculateAssignmentGrade() {
        int gradeWidth = calculateLetterGradeWidth(denominator);
        return mapGradeToScore(gradeWidth, numerator);
    }



    private int calculateLetterGradeWidth(int denominator){
        return denominator/3;
    }

    private String mapGradeToScore(int width, int nominator){
        if ((nominator >= 0) && (nominator < (width + 0.0)/2.0)){
            System.out.println("F");
            return "F";
        }
        else if ((nominator >= ((width + 0.0)/2.0)) && (nominator < ((width + 2.0*width)/2.0))){
            System.out.println("D");
            return "D";
        }
        else if ((nominator >= ((width + 2.0*width)/2.0)) && (nominator <= 2.0*width)){
            System.out.println("C");
            return "C";
        }
        else if ((nominator > 2.0*width) && (nominator < (3.0*width + 2.0*width)/2.0)){
            System.out.println("B");
            return "B";
        }
        else{
            System.out.println("A");
            return "A";
        }
    }



}
