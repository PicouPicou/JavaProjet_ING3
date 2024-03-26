package Vue;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import javafx.scene.control.Label;
import javafx.animation.*;
import javafx.util.Duration;

public class WelcomeWindow extends Application {

    /*
    * start : Méthode implémentée de l'interface Application, affichant un message de bienvenue
    * input : Stage primaryStage
    * output : aucun
    */
    @Override
    public void start(Stage primaryStage){

        // Label de bienvenu
        Label welcomeLabel = new Label("Welcome !");
        welcomeLabel.setStyle("-fx-font-size: 24px; -fx-font-weight: bold; -fx-text-fill: #f27448;");

        // Apparition progressive du message de bienvenue
        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(3), welcomeLabel);
        fadeTransition.setFromValue(0.0);
        fadeTransition.setToValue(1.0);
        fadeTransition.play();

        // Bouton Go
        Button goButton = new Button("Go");
        goButton.setVisible(false); // Invisible jusqu'à la fin de l'apparition
        fadeTransition.setOnFinished(event ->{
                goButton.setVisible(true);
        });

        // Ouverture de la fenetre de connexion
        goButton.setOnAction(event -> {
            // Ouvrir la fenetre de connexion
            LoginWindow loginWindow = new LoginWindow();
            loginWindow.start(primaryStage);
        });

        // Box verticale
        VBox vertBox = new VBox(welcomeLabel, goButton);
        vertBox.setAlignment(Pos.CENTER);
        vertBox.setSpacing(20);

        Scene scene = new Scene(vertBox, 400, 200);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
