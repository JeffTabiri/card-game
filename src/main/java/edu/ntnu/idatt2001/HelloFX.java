package edu.ntnu.idatt2001;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class HelloFX extends Application {

  @Override
  public void start(Stage stage) {
    Button btn1 = new Button("Button 1");
    StackPane root = new StackPane();
    root.getChildren().add(btn1);
    Scene scene = new Scene(root, 300, 250);

    stage.setScene(scene);
    stage.setTitle("JavaFX App");
    stage.show();
  }

  public static void main(String[] args) {
    System.out.println("xd");
    launch();
  }

}