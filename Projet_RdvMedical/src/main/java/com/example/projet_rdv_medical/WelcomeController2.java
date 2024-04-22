// https://www.youtube.com/watch?v=fPo7zNrFF7U&list=PLhs1urmduZ2-4hFJxb2dgfWwcinNqEz0c&index=2
package com.example.projet_rdv_medical;

import javafx.animation.KeyFrame;
import javafx.animation.ScaleTransition;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.io.IOException;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

public class WelcomeController2 implements Initializable {
    @FXML private ImageView bubbleJ1;
    @FXML private ImageView bubbleJ2;
    @FXML private ImageView bubbleJ3;
    @FXML private ImageView bubbleJ4;
    @FXML private ImageView bubbleJ5;
    @FXML private ImageView bubbleJ6;
    @FXML private ImageView bubbleJ7;
    @FXML private ImageView bubbleJ8;
    @FXML private ImageView bubbleJ9;
    @FXML private ImageView bubbleJ10;
    @FXML private ImageView bubbleJ11;
    @FXML private ImageView bubbleJ12;
    @FXML private ImageView bubbleJ13;
    @FXML private ImageView bubbleJ14;
    @FXML private ImageView bubbleJ15;
    @FXML private ImageView bubbleJ16;
    @FXML private ImageView bubbleJ17;
    @FXML private ImageView bubbleJ18;
    @FXML private ImageView bubbleJ19;
    @FXML private ImageView bubbleJ20;
    @FXML private ImageView bubbleJ21;
    @FXML private ImageView bubbleJ22;
    @FXML private ImageView bubbleJ23;

    @FXML private ImageView bubbleR1;
    @FXML private ImageView bubbleR2;
    @FXML private ImageView bubbleR3;
    @FXML private ImageView bubbleR4;
    @FXML private ImageView bubbleR5;
    @FXML private ImageView bubbleR6;
    @FXML private ImageView bubbleR7;
    @FXML private ImageView bubbleR8;
    @FXML private ImageView bubbleR9;
    @FXML private ImageView bubbleR10;
    @FXML private ImageView bubbleR11;
    @FXML private ImageView bubbleR12;
    @FXML private ImageView bubbleR13;
    @FXML private ImageView bubbleR14;
    @FXML private ImageView bubbleR15;
    @FXML private ImageView bubbleR16;
    @FXML private ImageView bubbleR17;
    @FXML private ImageView bubbleR18;
    @FXML private ImageView bubbleR19;
    @FXML private ImageView bubbleR20;
    @FXML private ImageView bubbleR21;
    @FXML private ImageView bubbleR22;
    @FXML private ImageView bubbleR23;
    @FXML private ImageView bubbleR24;
    @FXML private ImageView bubbleR25;
    @FXML private ImageView bubbleR26;
    @FXML private ImageView bubbleR27;
    @FXML private ImageView bubbleR28;
    @FXML private ImageView bubbleR29;
    @FXML private ImageView bubbleR30;
    @FXML private ImageView bubbleR31;
    @FXML private ImageView bubbleR32;
    @FXML private ImageView bubbleR33;
    @FXML private ImageView bubbleR34;
    @FXML private ImageView bubbleR35;
    @FXML private ImageView bubbleR36;
    @FXML private ImageView bubbleR37;
    @FXML private ImageView heartImage;


    private static final double MIN_DURATION = 4.0;
    private static final double MAX_DURATION = 7.0;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Random random = new Random();

        // Boutons Jaunes
        moveByTransitionScale(bubbleJ1, -1, getRandomDuration(random));
        moveByTransitionScale(bubbleJ2, -1, getRandomDuration(random));
        //moveByTransitionScale(bubbleJ3, -1, getRandomDuration(random));
        moveByTransitionScale(bubbleJ4, -1, getRandomDuration(random));
        moveByTransitionScale(bubbleJ5, -1, getRandomDuration(random));
        moveByTransitionScale(bubbleJ6, -1, getRandomDuration(random));
        moveByTransitionScale(bubbleJ7, -1, getRandomDuration(random));
        //moveByTransitionScale(bubbleJ8, -1, getRandomDuration(random));
        moveByTransitionScale(bubbleJ9, -1, getRandomDuration(random));
        moveByTransitionScale(bubbleJ10, -1, getRandomDuration(random));
        moveByTransitionScale(bubbleJ11, -1, getRandomDuration(random));
        moveByTransitionScale(bubbleJ12, -1, getRandomDuration(random));
        //moveByTransitionScale(bubbleJ13, -1, getRandomDuration(random));
        moveByTransitionScale(bubbleJ14, -1, getRandomDuration(random));
        moveByTransitionScale(bubbleJ15, -1, getRandomDuration(random));
        moveByTransitionScale(bubbleJ16, -1, getRandomDuration(random));
        //moveByTransitionScale(bubbleJ17, -1, getRandomDuration(random));
        moveByTransitionScale(bubbleJ18, -1, getRandomDuration(random));
        moveByTransitionScale(bubbleJ19, -1, getRandomDuration(random));
        moveByTransitionScale(bubbleJ20, -1, getRandomDuration(random));
        moveByTransitionScale(bubbleJ21, -1, getRandomDuration(random));
        moveByTransitionScale(bubbleJ22, -1, getRandomDuration(random));
        //moveByTransitionScale(bubbleJ23, -1, getRandomDuration(random));

        // Boutons Rouges
        moveByTransitionScale(bubbleR1, -1, getRandomDuration(random));
        moveByTransitionScale(bubbleR2, -1, getRandomDuration(random));
        moveByTransitionScale(bubbleR3, -1, getRandomDuration(random));
        moveByTransitionScale(bubbleR4, -1, getRandomDuration(random));
        moveByTransitionScale(bubbleR5, -1, getRandomDuration(random));
        moveByTransitionScale(bubbleR6, -1, getRandomDuration(random));
        moveByTransitionScale(bubbleR7, -1, getRandomDuration(random));
        moveByTransitionScale(bubbleR8, -1, getRandomDuration(random));
        moveByTransitionScale(bubbleR9, -1, getRandomDuration(random));
        moveByTransitionScale(bubbleR10, -1, getRandomDuration(random));
        moveByTransitionScale(bubbleR11, -1, getRandomDuration(random));
        moveByTransitionScale(bubbleR12, -1, getRandomDuration(random));
        moveByTransitionScale(bubbleR13, -1, getRandomDuration(random));
        moveByTransitionScale(bubbleR14, -1, getRandomDuration(random));
        moveByTransitionScale(bubbleR15, -1, getRandomDuration(random));
        moveByTransitionScale(bubbleR16, -1, getRandomDuration(random));
        moveByTransitionScale(bubbleR17, -1, getRandomDuration(random));
        moveByTransitionScale(bubbleR18, -1, getRandomDuration(random));
        moveByTransitionScale(bubbleR19, -1, getRandomDuration(random));
        moveByTransitionScale(bubbleR20, -1, getRandomDuration(random));
        moveByTransitionScale(bubbleR21, -1, getRandomDuration(random));
        moveByTransitionScale(bubbleR22, -1, getRandomDuration(random));
        moveByTransitionScale(bubbleR23, -1, getRandomDuration(random));
        moveByTransitionScale(bubbleR24, -1, getRandomDuration(random));
        moveByTransitionScale(bubbleR25, -1, getRandomDuration(random));
        moveByTransitionScale(bubbleR26, -1, getRandomDuration(random));
        moveByTransitionScale(bubbleR27, -1, getRandomDuration(random));
        moveByTransitionScale(bubbleR28, -1, getRandomDuration(random));
        moveByTransitionScale(bubbleR29, -1, getRandomDuration(random));
        moveByTransitionScale(bubbleR30, -1, getRandomDuration(random));
        moveByTransitionScale(bubbleR31, -1, getRandomDuration(random));
        moveByTransitionScale(bubbleR32, -1, getRandomDuration(random));
        moveByTransitionScale(bubbleR33, -1, getRandomDuration(random));
        moveByTransitionScale(bubbleR34, -1, getRandomDuration(random));
        moveByTransitionScale(bubbleR35, -1, getRandomDuration(random));
        moveByTransitionScale(bubbleR36, -1, getRandomDuration(random));
        moveByTransitionScale(bubbleR37, -1, getRandomDuration(random));

        Timeline heartbeatTimeline = new Timeline();
        // Heart beat illustration
        heartbeatTimeline.getKeyFrames().addAll(
                new KeyFrame(Duration.ZERO, e -> heartImage.setVisible(false)), // Appears
                new KeyFrame(Duration.millis(100), e -> heartImage.setVisible(true)), // Disappears
                new KeyFrame(Duration.millis(200), e -> heartImage.setVisible(false)), // Appears
                new KeyFrame(Duration.millis(300), e -> heartImage.setVisible(true)), // Disappears
                new KeyFrame(Duration.millis(400), e -> heartImage.setVisible(false)), // Appears
                new KeyFrame(Duration.millis(1400), e -> heartImage.setVisible(true)) // Disappears
        );

        // Répéter la séquence indéfiniment
        heartbeatTimeline.setCycleCount(Timeline.INDEFINITE);

        // Démarrer la timeline
        heartbeatTimeline.play();
    }

    private double getRandomDuration(Random random) {
        return MIN_DURATION + (MAX_DURATION - MIN_DURATION) * random.nextDouble();
    }

    public void moveByTransitionScale(ImageView image, int distance, double duration){
        ScaleTransition transitionScale = new ScaleTransition();
        transitionScale.setDuration(Duration.seconds(duration));
        transitionScale.setNode(image);
        transitionScale.setToX(distance);
        transitionScale.setToY(distance);

        transitionScale.setCycleCount(100);
        transitionScale.play();
    }

    public void loginButtonOnAction(ActionEvent actionEvent){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("login-view-2.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((javafx.scene.Node) actionEvent.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
