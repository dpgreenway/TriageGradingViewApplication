package cs345.bsu.edu.greenway.triage.project;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class JavaViewClass extends Application{

    private Stage primaryStage;

    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        Button beginButton = new Button("Learn How to Read My Scores");
        Label initialLabel = new Label("Reading Triage Grades in Blackboard or Canvas");
        VBox titlePage = new VBox();
        titlePage.getChildren().addAll(initialLabel, beginButton);
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
        Button beginButton = new Button("Learn How to Read My Scores 2");
        Label initialLabel = new Label("Reading Triage Grades in Blackboard or Canvas 2");
        VBox titlePage = new VBox();
        titlePage.getChildren().addAll(beginButton, initialLabel);
        primaryStage.setTitle("Page 2");
        primaryStage.setScene(new Scene(titlePage, 800, 500));
    }



}
