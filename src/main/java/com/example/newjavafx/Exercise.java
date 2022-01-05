package com.example.newjavafx;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.stage.Stage;

public class Exercise extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Label info = new Label("Progress bar");
        Label finished = new Label("Finished");
        Button start = new Button("Start");
        Button restart = new Button("Restart");
        ProgressBar progressBar = new ProgressBar();

        info.setLayoutY(10);
        progressBar.setLayoutY(30);
        finished.setLayoutY(50);
        start.setLayoutY(70);
        restart.setLayoutY(70);
        restart.setLayoutX(50);

        finished.setVisible(false);
        restart.setDisable(true);

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i <= 100; i++) {
                    double progress = 0.01 * i;
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            progressBar.setProgress(progress);
                        }
                    });
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        finished.setVisible(true);
                        restart.setDisable(false);
                    }
                });

            }
        };

        start.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                start.setDisable(true);
                new Thread(runnable).start();
            }
        });

        restart.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                progressBar.setProgress(0);
                finished.setVisible(false);
                start.setDisable(false);
                restart.setDisable(true);
            }
        });

        Group group = new Group();
        group.getChildren().add(info);
        group.getChildren().add(finished);
        group.getChildren().add(start);
        group.getChildren().add(restart);
        group.getChildren().add(progressBar);

        Scene scene = new Scene(group, 600, 400);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Exercise");
        primaryStage.setX(500);
        primaryStage.setY(300);
        primaryStage.show();
    }
}
