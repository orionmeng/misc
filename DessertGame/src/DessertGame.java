import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.application.Platform;
import javafx.geometry.Pos;
import java.util.Random;

public class DessertGame extends Application {
  
  private static int score = 0;

    @Override
    public void start(final Stage stage) {
        // Step 3 & 4
        BorderPane borderPane = new BorderPane();
        Scene scene = new Scene(borderPane, 640, 480);
        stage.setTitle("Dessert in the Desert JavaFX Game");
        
        // Step 5
        Label scoreLabel = new Label("Score: "+score);
        
        borderPane.setTop(scoreLabel);
        BorderPane.setAlignment(scoreLabel, Pos.TOP_LEFT);

        Button exitButton = new Button("Exit");
        exitButton.setOnAction(event -> {
            Platform.exit();
        });
        borderPane.setBottom(exitButton);
        BorderPane.setAlignment(exitButton, Pos.BOTTOM_RIGHT);
        
        // Step 6
        Pane pane = new Pane();
        borderPane.setCenter(pane);
        BorderPane.setAlignment(pane, Pos.CENTER);

        // TODO: Step 7-10
        Random random = new Random();
        Button real = new Button("Dessert");
        Button fake1 = new Button("Desert");
        Button fake2 = new Button("Desert");
        Button fake3 = new Button("Desert");
        Button fake4 = new Button("Desert");
        Button fake5 = new Button("Desert");
        Button fake6 = new Button("Desert");
        Button fake7 = new Button("Desert");
        pane.getChildren().add(real);
        pane.getChildren().add(fake1);
        pane.getChildren().add(fake2);
        pane.getChildren().add(fake3);
        pane.getChildren().add(fake4);
        pane.getChildren().add(fake5);
        pane.getChildren().add(fake6);
        pane.getChildren().add(fake7);
        Button[] buttons = new Button[8];
        buttons[0] = real;
        buttons[1] = fake1;
        buttons[2] = fake2;
        buttons[3] = fake3;
        buttons[4] = fake4;
        buttons[5] = fake5;
        buttons[6] = fake6;
        buttons[7] = fake7;
        real.setOnAction(event -> {
          ++score;
          scoreLabel.setText("Score "+score);
          randomizeButtonPositions(random, buttons);
          exitButton.requestFocus();
        });
        fake1.setOnAction(event -> {
          --score;
          scoreLabel.setText("Score "+score);
          randomizeButtonPositions(random, buttons);
          exitButton.requestFocus();
        });
        fake2.setOnAction(event -> {
          --score;
          scoreLabel.setText("Score "+score);
          randomizeButtonPositions(random, buttons);
          exitButton.requestFocus();
        });
        fake3.setOnAction(event -> {
          --score;
          scoreLabel.setText("Score "+score);
          randomizeButtonPositions(random, buttons);
          exitButton.requestFocus();
        });
        fake4.setOnAction(event -> {
          --score;
          scoreLabel.setText("Score "+score);
          randomizeButtonPositions(random, buttons);
          exitButton.requestFocus();
        });
        fake5.setOnAction(event -> {
          --score;
          scoreLabel.setText("Score "+score);
          randomizeButtonPositions(random, buttons);
          exitButton.requestFocus();
        });
        fake6.setOnAction(event -> {
          --score;
          scoreLabel.setText("Score "+score);
          randomizeButtonPositions(random, buttons);
          exitButton.requestFocus();
        });
        fake7.setOnAction(event -> {
          --score;
          scoreLabel.setText("Score "+score);
          randomizeButtonPositions(random, buttons);
          exitButton.requestFocus();
        });
        exitButton.requestFocus();
        
        stage.setScene(scene);
        randomizeButtonPositions(random, buttons);
        exitButton.requestFocus();
        stage.show();
    }
    
    private void randomizeButtonPositions(Random random, Button[] buttons) {
      for (int i = 0; i < buttons.length; i++) {
        buttons[i].setLayoutX(random.nextInt(600));
        buttons[i].setLayoutY(random.nextInt(400));
      }
    }

    public static void main(String[] args) {
        Application.launch();
    }
}