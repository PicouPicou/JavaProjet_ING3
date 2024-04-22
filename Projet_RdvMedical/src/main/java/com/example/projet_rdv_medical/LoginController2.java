package com.example.projet_rdv_medical;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import java.io.IOException;

public class LoginController2 {
    @FXML
    private Button createAccountButton;
    @FXML
    private Button loginButton;
    @FXML
    private TextField loginMessageLabel;
    @FXML
    private TextField emailField;
    @FXML
    private TextField passwordField;

    /** Connect the user to his account when the Login button is pressed, if the user exist
     * @param event Listener
     */
    public void loginButtonOnAction(ActionEvent event){
        String email = emailField.getText();
        String password = passwordField.getText();

        // Getting the user from the database
        if(email.endsWith("@patient.com")){
            PatientModel patient = new PatientModel().getPatientByEmailAndPassword(email, password);

            // Check connexion
            if(patient != null){
                loginMessageLabel.setText("Connexion success !");
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("homePagePatient.fxml")); // Mettre page accueil patient
                    Parent root = loader.load();
                    Scene scene = new Scene(root);
                    Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
                    stage.setScene(scene);
                    stage.show();
                } catch (IOException e) {
                    e.getMessage();
                }
                HomePagePatient homePagePatient = new HomePagePatient();
                homePagePatient.setUserInfo(email, password);
            }
            else{ // If user not found
                loginMessageLabel.setText("Login failed. Please, try again.");
            }
        } else {
            DoctorModel doctor = new DoctorModel().getDoctorByEmailAndPassword(email, password);
            if(doctor != null){
                loginMessageLabel.setText("Connexion success !");
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("homePageDoctor.fxml")); // Mettre page accueil docteur
                    Parent root = loader.load();
                    Scene scene = new Scene(root);
                    Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
                    stage.setScene(scene);
                    stage.show();
                } catch (IOException e) {
                    e.getMessage();
                }
            }
            else{ // If user not found
                loginMessageLabel.setText("Login failed. Please, try again.");
            }
        }
    }

    /**
     * Go the register window when the button CreateAccount is clicked
     * @param event Listener of the button */
    public void createAccountButtonOnAction(ActionEvent event){
        System.out.println("create account button !");
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("register-view.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.getMessage();
        }
    }

    /** Handle the forgotten password case
     * @param event Listener
     */
    public void passwordForgottenButtonOnAction(ActionEvent event){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("reinitializatePassword-view.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.getMessage();
        }
    }
}
