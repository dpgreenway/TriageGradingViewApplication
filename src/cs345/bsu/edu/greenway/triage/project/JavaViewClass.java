package cs345.bsu.edu.greenway.triage.project;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class JavaViewClass extends Application{

    public void start(Stage primaryStage){
        Button beginButton = new Button();
        Label initialLabel = new Label();
        VBox titlePage = new VBox(initialLabel, beginButton);
        Scene scene = new Scene(titlePage, 800, 500);
        primaryStage.setTitle("Reading Triage Grades");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main (String[] args){

    }

}
