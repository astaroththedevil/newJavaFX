package com.example.newjavafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class GUIApp extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        /*** Controls */
        Text text = new Text("Text from first app");
        Button button = new Button("The Button");
        Text text2 = new Text("another text");

        /*** root */
        // StackPane root = new StackPane();
        // HBox root = new HBox();
        VBox root = new VBox();
        root.getChildren().add(text);
        root.getChildren().add(button);
        root.getChildren().add(text2);

        /*** scene */
        Scene scene = new Scene(root);

        /*** stage */
        primaryStage.setScene(scene);
        primaryStage.setTitle("My app");

        primaryStage.setX(560);
        primaryStage.setY(300);

        primaryStage.setWidth(800);
        primaryStage.setHeight(400);

        primaryStage.initStyle(StageStyle.DECORATED);

        primaryStage.show();
    }
}
