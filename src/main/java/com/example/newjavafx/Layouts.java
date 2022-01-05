package com.example.newjavafx;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class Layouts extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        /*** Layouts */

        /*** HBox */

        Button menuButton = new Button("Menu");
        Button contactButton = new Button("Contact");
        Button orderButton = new Button("Order");
        menuButton.setId("menu-button");
        contactButton.setId("contact-button");
        orderButton.setId("order-button");

        HBox hBox = new HBox();
//        hBox.getChildren().add(menuButton);
//        hBox.getChildren().add(contactButton);
//        hBox.getChildren().add(orderButton);
        hBox.getChildren().addAll(menuButton, contactButton, orderButton);
        hBox.setSpacing(10);
        hBox.setPadding(new Insets(10, 5, 10, 5));
        hBox.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, CornerRadii.EMPTY, Insets.EMPTY)));

        /*** VBox */

        ImageView pizzaImageView = new ImageView(new Image("pizza.png"));
        Label pizzaLabel = new Label("Pizza", pizzaImageView);
        pizzaLabel.getStyleClass().add("img-label");
        ImageView hamburgerImageView = new ImageView(new Image("hamburger.png"));
        Label hamburgerLabel = new Label("Hamburger", hamburgerImageView);
        hamburgerLabel.getStyleClass().add("img-label");
        ImageView drinksImageView = new ImageView(new Image("napoje.png"));
        Label drinksLabel = new Label("Drinks", drinksImageView);
        drinksLabel.getStyleClass().add("img-label");

        VBox vBox = new VBox();
        vBox.getChildren().addAll(pizzaLabel, hamburgerLabel, drinksLabel);
        vBox.setSpacing(10);
        vBox.setPadding(new Insets(20));
        vBox.setBackground(new Background(new BackgroundFill(Color.CORAL, CornerRadii.EMPTY, Insets.EMPTY)));

        /*** StackPane */

        ImageView bigPizza = new ImageView(new Image("pizza-cztery-sery-duza.png"));
        Label bigPizzaLabel = new Label("Pizza four cheeses");
        bigPizzaLabel.setTextFill(Color.WHITE);

        StackPane stackPane = new StackPane();
        stackPane.getChildren().addAll(bigPizza, bigPizzaLabel);
        stackPane.setAlignment(Pos.CENTER);
        stackPane.setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));

        /*** FlowPane */

        ImageView pizzaFourCheese = new ImageView(new Image("pizza-cztery-sery.png"));
        ImageView pizzaFunghi = new ImageView(new Image("pizza-funghi.png"));
        ImageView pizzaMargarita = new ImageView(new Image("pizza-margaritta.png"));
        ImageView pizzaMexicana = new ImageView(new Image("pizza-mexicana.png"));
        ImageView pizzaPepperoni = new ImageView(new Image("pizza-pepperoni.png"));
        ImageView pizzaSalami = new ImageView(new Image("pizza-salami.png"));

        FlowPane flowPane = new FlowPane();
        flowPane.getChildren().addAll(pizzaFourCheese, pizzaFunghi, pizzaMargarita, pizzaMexicana, pizzaPepperoni, pizzaSalami);
        flowPane.setOrientation(Orientation.HORIZONTAL);
//        flowPane.setMaxWidth(150);
        flowPane.setPrefWrapLength(150);
        flowPane.setHgap(5);
        flowPane.setVgap(10);
        flowPane.setPadding(new Insets(5));

        /*** GridPane */

        Button minus = new Button("-");
        minus.setPrefSize(30, 30);
        Button plus = new Button("+");
        plus.setPrefSize(30, 30);
        Label qty = new Label("1");
        qty.setPadding(new Insets(0, 10, 0, 10 ));

        Button ok = new Button("OK");
        Button cancel = new Button("Cancel");

        Pane pane = new Pane();
        pane.setPrefWidth(50);

        GridPane gridPane = new GridPane();
        gridPane.add(minus, 0, 0);
        gridPane.add(qty, 1, 0);
        gridPane.add(plus, 2, 0);
        gridPane.add(pane, 3, 1);
        gridPane.add(ok, 4, 1);
        gridPane.add(cancel, 5, 1);

        /*** ScrollPane */

        for (int i = 0; i <= 20; i++) {
            ImageView copy = new ImageView(new Image("pizza-cztery-sery.png"));
            flowPane.getChildren().add(copy);
        }

        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(flowPane);
        scrollPane.setMaxWidth(150);

        /*** BorderPane */
        BorderPane borderPane = new BorderPane();
        borderPane.setTop(hBox);
        borderPane.setLeft(vBox);
        borderPane.setCenter(stackPane);
        borderPane.setRight(scrollPane);
        borderPane.setBottom(gridPane);

        Scene scene = new Scene(borderPane, 1000, 800, Color.LIGHTGRAY);
        scene.getStylesheets().add("styles.css");


        primaryStage.setScene(scene);
        primaryStage.setTitle("Layouts");
        primaryStage.show();
    }
}
