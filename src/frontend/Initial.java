package frontend;

import database.DbHandler;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import participants.Player;

public class Initial extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Blackjack 0.1");

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Text title = new Text("Welcome");
        title.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(title, 0, 0, 2, 1);

        Label label_username = new Label("Username:");
        grid.add(label_username, 0, 1);

        TextField input_username = new TextField();
        grid.add(input_username, 1, 1);

        Label label_password = new Label("Password:");
        grid.add(label_password, 0, 2);

        PasswordField input_password = new PasswordField();
        grid.add(input_password, 1, 2);

        Button btn = new Button("Sign in");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(btn);
        grid.add(hbBtn, 1, 4);

        final Text response = new Text();
        HBox hbResponse = new HBox(0);
        hbResponse.setAlignment(Pos.CENTER);
        hbResponse.getChildren().add(response);
        grid.add(hbResponse, 0, 6, 2, 1);

        btn.setOnAction(e -> {
            // check if fields are empty
            if (input_username.getText().length() == 0 ||
                input_password.getText().length() == 0) {
                response.setFill(Color.FIREBRICK);
                response.setText("Enter username and password");
            } else {
                // attempt to retrieve player
                DbHandler dbHandler = new DbHandler();
                Player player = dbHandler.getPlayer(input_username.getText(), input_password.getText());
                if (player != null) {
                    // found player, correct details
                    response.setFill(Color.GREEN);
                    String msg = "User named " + player.getName() + " found!";
                    response.setText(msg);
                } else {
                    response.setFill(Color.FIREBRICK);
                    response.setText("Incorrect username or password");
                }
            }
        });

        Scene scene = new Scene(grid, 300, 275);
        primaryStage.setScene(scene);

        primaryStage.show();
    }
}
