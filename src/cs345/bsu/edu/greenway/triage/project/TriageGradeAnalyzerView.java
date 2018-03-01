package cs345.bsu.edu.greenway.triage.project;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class TriageGradeAnalyzerView extends Application{

    private Stage primaryStage;
    private Font analyzerFont;
    private Font openingPageFont;
    private final int SCENE_WIDTH = 800;
    private final int SCENE_HEIGHT = 500;
    private Pos generalAlignment = Pos.CENTER;
    private TextField numeratorField;
    private TextField denominatorField;
    private VBox gradeAnalyzer;

    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        openingPageFont = setOpeningFont();
        Label title = createOpeningLabel();
        Button beginButton = createOpeningButton();
        VBox titlePage = new VBox();
        titlePage.getChildren().addAll(title, beginButton);
        titlePage.setAlignment(generalAlignment);
        titlePage.setSpacing(20);
        Scene scene = new Scene(titlePage,SCENE_WIDTH, SCENE_HEIGHT);
        primaryStage.setTitle("Reading Triage Grades");
        primaryStage.setScene(scene);
        primaryStage.show();
        listenForButtonClick(beginButton);
    }

    private Font setOpeningFont(){
        return new Font("Serif", 24);
    }

    private Button createOpeningButton(){
        Button beginButton = new Button("See How My Scores Should Be Read");
        beginButton.setFont(openingPageFont);
        return beginButton;
    }

    private Label createOpeningLabel(){
        Label mainLabel = new Label("How To Read Your Triage Grades From Blackboard or Canvas");
        mainLabel.setFont(openingPageFont);
        return mainLabel;
    }

    private void listenForButtonClick(Button button){
        button.setOnAction(event -> buildScene2());
    }

    private void buildScene2(){
        analyzerFont = setAnalyzerFont();
        Label mainScreenLabel = createMainLabel();
        numeratorField = new TextField();
        Label divisionSign = createDivisionSign();
        denominatorField = new TextField();
        HBox fractionInput = new HBox(numeratorField, divisionSign, denominatorField);
        fractionInput.setAlignment(Pos.CENTER);
        Button generateButton = createGenerateButton();
        gradeAnalyzer = new VBox(mainScreenLabel, fractionInput, generateButton);
        gradeAnalyzer.setAlignment(Pos.CENTER);
        gradeAnalyzer.setSpacing(20);
        primaryStage.setTitle("Analyzing Your Triage Grading Scores");
        primaryStage.setScene(new Scene(gradeAnalyzer, SCENE_WIDTH, SCENE_HEIGHT));
        listenForGeneratorButtonClick(generateButton);
    }

    private void listenForGeneratorButtonClick(Button button){
        button.setOnAction(event -> retrieveTriageGrade());
    }


    private void retrieveTriageGrade() {
        String numerator = numeratorField.getText();
        String denominator = denominatorField.getText();
        TriageController controller = new TriageController(numerator, denominator);
        String grade = controller.getAnalyzedGrade();
        Label responseLabel = new Label("Response: ");
        responseLabel.setFont(analyzerFont);
        Label gradeLabel = new Label (grade);
        gradeLabel.setFont(analyzerFont);
        HBox responseComponents = new HBox(responseLabel, gradeLabel);
        gradeAnalyzer.getChildren().addAll(responseComponents);
    }


    private Label createMainLabel(){
        Label analyzingLabel = new Label("Analyze Your Received Grade");
        analyzingLabel.setFont(analyzerFont);
        return analyzingLabel;
    }

    private Label createDivisionSign(){
        Label divisionSign = new Label("/");
        divisionSign.setFont(analyzerFont);
        return divisionSign;
    }

    private Button createGenerateButton(){
        Button generateButton = new Button("Generate Grade");
        generateButton.setFont(analyzerFont);
        return generateButton;
    }

    private Font setAnalyzerFont(){
        return new Font ("Serif", 36);
    }

}
