package edu.ntnu.idatt2001;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;


public class App extends Application {

  static Deck deck = new Deck();
  static Hand firstHand = new Hand();

  @Override
  public void start(Stage stage) throws Exception {

    //Panes initialization
    BorderPane root = new BorderPane();

    BorderPane cardDetails = new BorderPane();

    HBox titledetails = new HBox();

    HBox buttonContainer = new HBox();

    HBox cardContainer = new HBox(30);

    ImageView cardImage = new ImageView();


    //Title
    Text title = new Text("Luck Of The Draw");
    title.setFont(Font.font("Times New Roman", FontWeight.BOLD, 40));
    titledetails.getChildren().add(title);


    //Showing cards
    cardImage.setFitHeight(100);
    cardImage.setFitWidth(100);
    cardContainer.getChildren().add(cardImage);

    //Draw Button
    Button draw = new Button("Draw");
    draw.setPrefSize(100, 50);
    draw.setAlignment(Pos.BOTTOM_LEFT);

    //Check Button
    Button check = new Button("Check");
    check.setPrefSize(100, 50);
    check.setAlignment(Pos.BOTTOM_RIGHT);

    //Restock Button
    Button restock = new Button("Restock");
    restock.setPrefSize(100, 50);
    buttonContainer.getChildren().addAll(draw, check, restock);
    check.setAlignment(Pos.BOTTOM_CENTER);

    //Card Details
    Text details = new Text("Details");

    cardDetails.getChildren().add(details);



    //Creating a scene object

    root.setTop(titledetails);
    titledetails.setAlignment(javafx.geometry.Pos.CENTER);

    root.setCenter(cardContainer);

    root.setBottom(buttonContainer);

    buttonContainer.setAlignment(Pos.CENTER);


    root.setLeft(details);

    //Setting title to the Stage
    Scene scene = new Scene(root, 600, 500, Color.GREEN);

    stage.setTitle("Luck Of The Draw");

    scene.setFill(Color.GREEN);
    //Adding scene to the stage
    stage.setScene(scene);


    //Displaying the contents of the stage
    stage.show();

    cardContainer.setMaxSize(300, 150);

    draw.setOnAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent actionEvent) {

        cardContainer.getChildren().clear();
        firstHand.getCards().clear();
        deck.shuffle();

        if (deck.getCards().size() > 5) {

        for (int i = 0; i < 5; i++) {

          try {
            Card drawnCard = deck.drawCard();
            firstHand.addCard(drawnCard);

            ImageView imageView = new ImageView();
            imageView.setFitHeight(500);
            imageView.setFitWidth(300);
            imageView.setX(imageView.getX()+50);

            imageView.setImage(new Image(new FileInputStream(drawnCard.getUrl())));
            cardContainer.getChildren().add(imageView);

          } catch (FileNotFoundException e) {

            throw new RuntimeException(e);
          }

        }


          details.setText("Details"  +
                        "\n"+ "sum " + firstHand.cardSum()
                        + "\n is Flush? " + firstHand.checkForFlush()
                        + "\n isCardPresent: " + firstHand.checkForCard(new Card(Suits.SPADES, Faces.QUEEN))
                        + "\n isHeartPresent: " + firstHand.checkForSuit("HEARTS")
            );
        }

      }
    });

    restock.setOnAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent actionEvent) {
        deck.reStack();
      }
    });
  }

  public static void main(String[] args) {
    launch(args);
  }


}


