package com.example.newjavafx;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.stage.Stage;

public class Controls extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Font font = Font.font("Ubuntu Mono", FontPosture.ITALIC, 20);
        System.out.println(Font.getFamilies());
        Color color = Color.web("#32CD32");

        /*** Label */
        Label label = new Label("The first label");
        label.setLayoutX(15);
        label.setLayoutY(35);
//        label.setFont(new Font(20));
        label.setFont(font);
        label.setTextFill(color);
//        label.setRotate(-15);

        /*** ImageView */
        Image image = new Image("aston.jpg");
        ImageView imageView = new ImageView(image);
        imageView.setX(250);
        imageView.setY(230);
//        label.setGraphic(imageView);
//        Label labelWithImage = new Label("Label z obrazkiem", imageView);
        imageView.setPreserveRatio(true);

        /*** Button */
        Button button = new Button();
        button.setText("The first button");
        button.setLayoutX(50);
        button.setTextFill(Color.color(0.8, 0, 0, 1));
        button.setMaxWidth(500);
        button.setWrapText(true);
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Click!");
                String text = button.getText() + " clicked!";
                button.setText(text);
//                button.setDisable(true);
//                System.out.println("Catched: " + textField.getText());
            }
        });

        /*** TextField */
        TextField textField = new TextField();
//        textField.setText("placeholder");
        textField.setPromptText("placeholder");
        textField.setLayoutX(200);
        textField.setLayoutY(100);
        textField.setPrefColumnCount(20);

        /*** PasswordField */
        PasswordField passwordField = new PasswordField();
        passwordField.setLayoutX(200);
        passwordField.setLayoutY(130);
        passwordField.setPromptText("password");
        passwordField.setPrefColumnCount(16);

        /***  TextArea */
        TextArea textArea = new TextArea();
        textArea.setLayoutX(200);
        textArea.setLayoutY(450);
        textArea.setPrefWidth(300);
        textArea.setPrefHeight(200);
        textArea.setPromptText("write some text");

        /*** CheckBox */
        CheckBox checkBox = new CheckBox();
        checkBox.setLayoutX(220);
        checkBox.setLayoutY(200);
        checkBox.setText("Check it!");
        checkBox.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (checkBox.isSelected()) {
                    checkBox.setText("Checked!");
                } else {
                    checkBox.setText("Check it!");
                }
            }
        });

        /*** RadioButton */
        RadioButton radioButton = new RadioButton("First choice");
        radioButton.setLayoutX(220);
        radioButton.setLayoutY(10);
        RadioButton radioButton1 = new RadioButton("Second choice");
        radioButton1.setLayoutX(220);
        radioButton1.setLayoutY(30);
        RadioButton radioButton2 = new RadioButton("Third choice");
        radioButton2.setLayoutX(220);
        radioButton2.setLayoutY(50);

        ToggleGroup toggleGroup = new ToggleGroup();
        radioButton.setToggleGroup(toggleGroup);
        radioButton1.setToggleGroup(toggleGroup);
        radioButton2.setToggleGroup(toggleGroup);

        toggleGroup.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
                RadioButton chosen = (RadioButton) newValue;
                System.out.println("Chosen: " + chosen.getText());
            }
        });

        /*** ChoiceBox */
        String[] choices = {"First", "Second", "Third", "Fourth"};
        ChoiceBox<String> choiceBox = new ChoiceBox<>();
        choiceBox.setLayoutX(500);
        choiceBox.setLayoutY(10);
        choiceBox.getItems().addAll(choices);
        choiceBox.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                String choice = choices[newValue.intValue()];
                System.out.println("Chosen from choiceBox: " + choice);
            }
        });
        /*** ListView */
        ListView<String> listView = new ListView<>();
        listView.getItems().addAll(choices);
        listView.setLayoutX(600);
        listView.setLayoutY(10);
        listView.setMaxHeight(250);

        listView.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                String choice = choices[newValue.intValue()];
                System.out.println("Chosen from listView: " + choice);
            }
        });

        /*** ProgressBar */
        ProgressBar progressBar = new ProgressBar();
        progressBar.setLayoutX(600);
        progressBar.setLayoutY(260);
        ProgressBar progressBar1 = new ProgressBar();
        progressBar1.setProgress(0.75);
        progressBar1.setLayoutX(600);
        progressBar1.setLayoutY(300);

        /*** ProgressIndicator */
        ProgressIndicator progressIndicator = new ProgressIndicator();
        progressIndicator.setLayoutX(600);
        progressIndicator.setLayoutY(340);

        ProgressIndicator progressIndicator1 = new ProgressIndicator(0.7);
        progressIndicator1.setLayoutX(600);
        progressIndicator1.setLayoutY(400);

        ProgressIndicator progressIndicator2 = new ProgressIndicator(1);
        progressIndicator2.setLayoutX(600);
        progressIndicator2.setLayoutY(450);

        /*** Slider */
        Slider slider = new Slider(0, 100, 0);
        slider.setLayoutX(10);
        slider.setLayoutY(70);
        slider.setPrefWidth(300);
        slider.setShowTickMarks(true);
        slider.setShowTickLabels(true);
        slider.setMajorTickUnit(25);
        slider.setMinorTickCount(4);
        slider.setSnapToTicks(true);

        slider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                System.out.println("slider: " + newValue.intValue());
                if (newValue.intValue() == 100) {
                    progressBar.setVisible(false);
                    progressIndicator.setVisible(false);
                } else {
                    progressBar.setVisible(true);
                    progressIndicator.setVisible(true);
                    double percentValue = newValue.doubleValue() / 100.0;
                    progressBar.setProgress(percentValue);
                    progressIndicator.setProgress(percentValue);
                }
            }
        });

        ////////////////////////////////////////////////
        Group group = new Group();
        group.getChildren().add(label);
        group.getChildren().add(imageView);
//        group.getChildren().add(labelWithImage);
        group.getChildren().add(button);
        group.getChildren().add(textField);
        group.getChildren().add(passwordField);
        group.getChildren().add(textArea);
        group.getChildren().add(checkBox);
        group.getChildren().add(radioButton);
        group.getChildren().add(radioButton1);
        group.getChildren().add(radioButton2);
        group.getChildren().add(choiceBox);
        group.getChildren().add(listView);
        group.getChildren().add(progressBar);
        group.getChildren().add(progressBar1);
        group.getChildren().add(progressIndicator);
        group.getChildren().add(progressIndicator1);
        group.getChildren().add(progressIndicator2);
        group.getChildren().add(slider);


        Scene scene = new Scene(group, 1000, 800, Color.LIGHTGRAY);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Controls");
        primaryStage.show();
    }
}