package com.example.projet_rdv_medical;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class RegisterController {
    @FXML
    private TextField firstNameField;
    @FXML
    private TextField lastNameField;
    @FXML
    private TextField ageField;
    @FXML
    private TextField phoneField;
    @FXML
    private TextField addressField;
    @FXML
    private TextField cityField;
    @FXML
    private TextField postalCodeField;
    @FXML
    private TextField emailField;
    @FXML
    private TextField passwordField;
    @FXML
    private TextField confirmPasswordField;
    @FXML
    private Button signInButton;
    @FXML
    private TextField heightField;
    @FXML
    private Label heightLabel;
    @FXML
    private Label emailMessageLabel;
    @FXML
    private Label passwordMessageLabel;
    @FXML
    private Label ageMessageLabel;
    @FXML
    private Label uncompleteFieldsMessageLabel;

    /**
     * Method going back to the Login window
     * @param event Listener on the button */
    public void signInButtonOnAction(ActionEvent event){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("login-view-2.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
        } catch (IOException e) {
            e.getMessage();
        }
    }

    public void specifyPatientOrDoctorWithEmail(ActionEvent event){
        // Case Patient -> add height
        if(emailField.getText().endsWith("@patient.com")){
            heightField.setVisible(true);
            heightLabel.setVisible(true);
            // Create new patient (do table database)
        } else if (emailField.getText().endsWith("@doctor.com")) {
            heightField.setVisible(true); // Avec specialite
            heightLabel.setVisible(true);
        }

        // Case Doctor -> add specialisation
    }

    public void initialize(){
        heightField.setVisible(false);
        heightLabel.setVisible(false);

        emailField.textProperty().addListener((observableValue, oldValue, newValue) -> {
            if(newValue.endsWith("@patient.com")){
                heightField.setVisible(true);
                heightLabel.setVisible(true);
            }
            else{
                heightField.setVisible(false);
                heightLabel.setVisible(false);
            }
        });
    }

    /**
     * Create a new account of a new user
     * @param event Listener on the button
     * @exception IOException Exception on the window opening */
    public void createButtonOnAction(ActionEvent event){
        String firstName = firstNameField.getText();
        String lastName = lastNameField.getText();

        String phone = phoneField.getText();
        String address = addressField.getText();
        String city = cityField.getText();
        String postalCode = postalCodeField.getText();
        String email = emailField.getText();
        String password = passwordField.getText();
        String confirmPassword = confirmPasswordField.getText();

        // Initialize all the labels // TO DO : Make better the label display (in real time)
        emailMessageLabel.setText("");
        ageMessageLabel.setText("");
        uncompleteFieldsMessageLabel.setText("");
        passwordMessageLabel.setText("");

        if(firstName.isEmpty() || lastName.isEmpty() || ageField.getText().isEmpty() || phone.isEmpty() || address.isEmpty() || city.isEmpty() || postalCode.isEmpty() || email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
            uncompleteFieldsMessageLabel.setText("Please, complete every fields");
            return;
        }
        if(!email.endsWith("@patient.com") && !email.endsWith("@doctor.com")) {
            emailMessageLabel.setText("* Error format");
            return;
        }
        if (!password.equals(confirmPassword)) {
            passwordMessageLabel.setText("* Not same password");
            return;
        }

        int age = 0;
        if (!ageField.getText().isEmpty()){
            age = Integer.parseInt(ageField.getText());
        }
        // Check the age
        if (age <= 0 || age > 120){
            ageMessageLabel.setText("* Error format");
            return;
        }

        // Check if the user do not already exist
        if (email.endsWith("@patient.com")){

            float height = 0;
            if (!heightField.getText().isEmpty()){
                height = Float.parseFloat(heightField.getText());
            }
            // Check the height
            if (height <= 0){
                //heightMessageLabel.setText("* Error format");
                return;
            }

            PatientModel patientCheck = new PatientModel().getPatientByEmailAndPassword(email, password);
            if (patientCheck == null){
                // Add the user to the database
                PatientModel patient = new PatientModel(firstName, lastName, age, height, email, password, address, city, postalCode, phone);
                patient.add(patient);
                System.out.println("Patient registered successfully.");

                // Go to the user page
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("welcome-view-2.fxml")); // Mettre la page d'accueil client
                    Parent root = loader.load();
                    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    stage.setScene(new Scene(root));
                } catch (IOException e) {
                    e.getMessage();
                }
            }
            else{
                System.out.println("User already exist");
            }
        }
    }
}
