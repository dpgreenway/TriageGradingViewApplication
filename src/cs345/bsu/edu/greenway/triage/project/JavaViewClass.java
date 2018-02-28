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

public class JavaViewClass extends Application{

    private Stage primaryStage;

    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        Button beginButton = new Button("Learn How to Read My Scores");
        beginButton.setFont(new Font("Serif", 24));

        Label initialLabel = new Label("Reading Triage Grades in Blackboard or Canvas");
        initialLabel.setFont(new Font("Serif", 36));

        VBox titlePage = new VBox();
        titlePage.getChildren().addAll(initialLabel, beginButton);
        titlePage.setAlignment(Pos.CENTER);
        titlePage.setSpacing(20);
        Scene scene = new Scene(titlePage, 800, 500);
        primaryStage.setTitle("Reading Triage Grades");
        primaryStage.setScene(scene);
        primaryStage.show();
        listenForButtonClick(beginButton);
    }

    private void listenForButtonClick(Button button){
        button.setOnAction(event -> buildScene2());
    }

    private void buildScene2(){
        Label initialLabel = new Label("Analyze Your Received Grade");
        initialLabel.setFont(new Font ("Serif", 36));


        TextField numerator = new TextField();
        Label divisionSign = new Label("/");
        divisionSign.setFont(new Font ("Serif", 36));
        TextField denomenator = new TextField();
        HBox fractionInput = new HBox(numerator, divisionSign, denomenator);

        Button generateButton = new Button("Generate Grade");
        generateButton.setFont(new Font ("Serif", 36));
        VBox gradeAnalyzer = new VBox(initialLabel, fractionInput, generateButton);

        primaryStage.setTitle("Page 2");
        primaryStage.setScene(new Scene(gradeAnalyzer, 800, 500));
    }



}
