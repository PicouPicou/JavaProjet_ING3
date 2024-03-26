package Vue;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

import Controleur.*;

public class LoginWindow extends Application {
    /*
     * start : Méthode implémentée de l'interface Application, affichant la fenetre de conexion
     * input : Stage primaryStage
     * output : aucun
     */
    @Override
    public void start(Stage primaryStage) {

        BorderPane root = new BorderPane();
        Scene scene = new Scene(root, 600, 400);
        primaryStage.setTitle("Login");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);

        // Icon clé
        Image iconCle = new Image("file:C:/Users/clara/Desktop/ING3/Semestre2/Java/Projet/Projet_V1/src/iconCle.png");
        primaryStage.getIcons().add(iconCle);

        // Partie gauche avec l'image centrée
        ImageView logoImage = new ImageView(new Image("file:C:/Users/clara/Desktop/ING3/Semestre2/Java/Projet/Projet_V1/src/logo2.png"));
        logoImage.setFitWidth(220);
        logoImage.setFitHeight(150);
        VBox logoBox = new VBox(logoImage);
        logoBox.setPadding(new Insets(20));
        logoBox.setAlignment(javafx.geometry.Pos.CENTER);
        logoBox.setStyle("-fx-background-color: rgba(239,117,73,0.4)");


        // Ajouter label Copyrights
        Label copyRightsLabel = new Label("Copyright (c) All rights reserved");
        copyRightsLabel.setStyle("-fx-font-size: 8pt; -fx-text-fill: #f27448;");
        VBox.setMargin(copyRightsLabel, new Insets(100, 0, 0, 0));
        VBox.setMargin(logoImage, new Insets(0, 0, 10, 0));
        logoBox.getChildren().add(copyRightsLabel);
        root.setLeft(logoBox);


        // Panel de connexion à droite
        GridPane loginPane = new GridPane();
        //loginPane.setStyle("-fx-background-color: #954949");
        loginPane.setPadding(new Insets(60));
        loginPane.setVgap(10);
        loginPane.setHgap(5);
        Label titleLabel = new Label("Connexion");
        titleLabel.setStyle("-fx-font-weight: bold; -fx-font-size: 18px;");
        GridPane.setConstraints(titleLabel, 0, 0, 2, 1);
        Label usernameLabel = new Label("Nom d'utilisateur :");
        GridPane.setConstraints(usernameLabel, 0, 1);
        TextField usernameField = new TextField();
        GridPane.setConstraints(usernameField, 1, 1);
        Label passwordLabel = new Label("Mot de passe :");
        GridPane.setConstraints(passwordLabel, 0, 2);
        PasswordField passwordField = new PasswordField();
        GridPane.setConstraints(passwordField, 1, 2);
        Label errorLabel = new Label();
        errorLabel.setTextFill(Color.RED);
        GridPane.setConstraints(errorLabel, 0, 3, 2, 1);
        Button loginButton = new Button("Se connecter");
        loginButton.setDefaultButton(true);
        GridPane.setConstraints(loginButton, 0, 4);

        Button cancelButton = new Button("Annuler");
        GridPane.setConstraints(cancelButton, 0, 5);

        // Gestionnaire d'événements pour le bouton Se connecter
        loginButton.setOnAction(event -> {
            String username = usernameField.getText();
            String password = passwordField.getText();

            if (validateConnexion(username, password)) {
                errorLabel.setText("");
                // Code pour la connexion réussie
                System.out.println("Nom d'utilisateur : " + username);
                System.out.println("Mot de passe : " + password);
            } else {
                errorLabel.setText("Nom d'utilisateur ou mot de passe incorrect");
            }
        });

        // Gestionnaire d'événements pour le bouton Annuler
        cancelButton.setOnAction(event -> {
            usernameField.clear();
            passwordField.clear();
            errorLabel.setText("");
        });

        loginPane.getChildren().addAll(titleLabel, usernameLabel, usernameField, passwordLabel, passwordField, errorLabel, loginButton, cancelButton);


        GridPane.setColumnSpan(titleLabel, 2);
        GridPane.setColumnSpan(errorLabel, 2);
        GridPane.setColumnSpan(loginButton, 2);
        GridPane.setColumnSpan(cancelButton, 2);
        GridPane.setHalignment(titleLabel, javafx.geometry.HPos.CENTER);
        GridPane.setHalignment(errorLabel, javafx.geometry.HPos.CENTER);
        GridPane.setHalignment(loginButton, javafx.geometry.HPos.CENTER);
        GridPane.setHalignment(cancelButton, javafx.geometry.HPos.CENTER);

        root.setRight(loginPane);

        primaryStage.show();
    }

    // Méthode de validation des informations de connexion
    public boolean validateConnexion(String username, String password) {

        return true; // Pour cet exemple, toujours retourner true
    }

}