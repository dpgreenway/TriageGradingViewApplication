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
    private TriageController controller = new TriageController();
    private HBox responseComponents = new HBox();
    private int spacing = 20;
    private Button generatorButton;

    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        openingPageFont = setOpeningFont();
        Label title = createOpeningLabel();
        Button beginButton = createOpeningButton();
        VBox titlePage = new VBox();
        titlePage.getChildren().addAll(title, beginButton);
        titlePage.setAlignment(generalAlignment);
        titlePage.setSpacing(spacing);
        Scene scene = new Scene(titlePage,SCENE_WIDTH, SCENE_HEIGHT);
        primaryStage.setTitle("Reading Triage Grades");
        primaryStage.setScene(scene);
        primaryStage.show();
        listenForButtonClick(beginButton);
    }

    private Font setOpeningFont(){
        return new Font("Serif", 24);
    }

    private Label createOpeningLabel(){
        Label mainLabel = new Label("How To Read Your Triage Grades From Blackboard or Canvas");
        mainLabel.setFont(openingPageFont);
        return mainLabel;
    }

    private Button createOpeningButton(){
        Button beginButton = new Button("Analyze My Scores");
        beginButton.setFont(openingPageFont);
        return beginButton;
    }

    private void listenForButtonClick(Button button){
        button.setOnAction(event -> buildAnalyzerScene());
    }

    private void buildAnalyzerScene(){
        analyzerFont = setAnalyzerFont();
        Label mainScreenLabel = createMainLabel();
        numeratorField = new TextField();
        Label divisionSign = createDivisionSign();
        denominatorField = new TextField();
        HBox fractionInput = new HBox(numeratorField, divisionSign, denominatorField);
        fractionInput.setAlignment(generalAlignment);
        generatorButton = createGenerateButton();
        gradeAnalyzer = new VBox(mainScreenLabel, fractionInput, generatorButton);
        gradeAnalyzer.setAlignment(generalAlignment);
        gradeAnalyzer.setSpacing(spacing);
        primaryStage.setTitle("Analyzing Your Triage Grading Scores");
        primaryStage.setScene(new Scene(gradeAnalyzer, SCENE_WIDTH, SCENE_HEIGHT));
        listenForGeneratorButtonClick(generatorButton);
    }

    private Font setAnalyzerFont(){
        return new Font ("Serif", 36);
    }

    private Label createMainLabel(){
        Label analyzingLabel = new Label("Analyze Your Blackboard/Canvas Triage Grade");
        analyzingLabel.setFont(analyzerFont);
        return analyzingLabel;
    }

    private Label createDivisionSign(){
        Label divisionSign = new Label("/");
        divisionSign.setFont(analyzerFont);
        return divisionSign;
    }

    private Button createGenerateButton(){
        Button generateButton = new Button("Generate Triage Grade Interpretation");
        generateButton.setFont(analyzerFont);
        return generateButton;
    }

    private void listenForGeneratorButtonClick(Button button){
        button.setOnAction(event -> retrieveTriageGrade());
    }


    private void retrieveTriageGrade() {
        disableButton(generatorButton);
        checkForPastRetrievals();
        String numerator = numeratorField.getText();
        String denominator = denominatorField.getText();
        displayResponse(numerator, denominator);
    }

    private void disableButton(Button button){
        button.setDisable(true);
    }

    private void reEnableButton(Button button){
        button.setDisable(false);
    }

    private void checkForPastRetrievals(){
        if (controller.getNumberOfRetrievals() > 0){
            responseComponents.getChildren().clear();
            responseComponents.getChildren().addAll();
            gradeAnalyzer.getChildren().remove(responseComponents);
        }
    }

    private void displayResponse(String numerator, String denominator){
        if (controller.attemptToSetNums(numerator, denominator)) {
            checkToDisplayWithoutError();
        }
        else{
            controller.incrementAttemptedRetrievals();
            displayWithError("Error: This is not a Triage Grade!");
        }

    }
    private void checkToDisplayWithoutError() {
        if (controller.checkTriageGradingNumbers()) {
            String grade = controller.getAnalyzedGrade();
            Label responseLabel = new Label("Grade: ");
            responseLabel.setFont(analyzerFont);
            Label gradeLabel = new Label(grade);
            gradeLabel.setFont(analyzerFont);
            responseComponents.getChildren().addAll(responseLabel, gradeLabel);
            responseComponents.setAlignment(generalAlignment);
            reEnableButton(generatorButton);
            gradeAnalyzer.getChildren().addAll(responseComponents);
        } else {
            displayWithError("Error: Only numbers can exist in Grades!");
        }
    }

    private void displayWithError(String message) {
        checkForPastRetrievals();
        Label responseLabel = new Label(message);
        responseLabel.setFont(analyzerFont);
        responseComponents.getChildren().addAll(responseLabel);
        responseComponents.setAlignment(generalAlignment);
        reEnableButton(generatorButton);
        gradeAnalyzer.getChildren().addAll(responseComponents);
    }












}
