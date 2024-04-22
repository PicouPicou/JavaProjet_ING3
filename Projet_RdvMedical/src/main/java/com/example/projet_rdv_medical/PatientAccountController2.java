package com.example.projet_rdv_medical;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class PatientAccountController2 implements Initializable {
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
    private Button modifyButton;
    @FXML
    private Button saveButton;
    @FXML
    private Label emailMessageLabel;
    @FXML
    private Label passwordMessageLabel;
    @FXML
    private Label ageMessageLabel;
    @FXML
    private Label uncompleteFieldsMessageLabel;
    @FXML
    private Label confirmPasswordStarLabel;

    /** Method modifying the user parameters
     */
    public void modifyButtonOnAction(){
        firstNameField.setPromptText("First Name");
        lastNameField.setPromptText("Last Name");
        ageField.setPromptText("Age");
        emailField.setPromptText("E-mail");
        passwordField.setPromptText("Password");
        addressField.setPromptText("Confirm Password");
        cityField.setPromptText("City");
        postalCodeField.setPromptText("Postal Code");
        phoneField.setPromptText("Phone");

        // Patient
        System.out.println("Bouton appuye");

        // Get the information
        //PatientModel patient = new PatientModel(firstNameField.getText(), lastNameField.getText(), Integer.parseInt(ageField.getText()), 0, emailField.getText(), passwordField.getText(), addressField.getText(), cityField.getText(), postalCodeField.getText(), phoneField.getText());
        PatientModel patient = new PatientModel("Clara", "Lacour", 21, 65, "clara.lacour@patient.com", "blabla", "12 Rue du Paradis", "Paris", "75017", "+33 6 54 54 54 54");

        firstNameField.setText(patient.getFirstName());
        lastNameField.setText(patient.getLastName());
        ageField.setText(String.valueOf(patient.getAge()));
        emailField.setText(patient.getEmail());
        passwordField.setText(patient.getPassword());
        addressField.setText(patient.getAddress());
        cityField.setText(patient.getCity());
        postalCodeField.setText(patient.getPostalCode());
        phoneField.setText(patient.getPhoneNumber());

        // Set all textfields editable
        firstNameField.setEditable(true);
        lastNameField.setEditable(true);
        ageField.setEditable(true);
        emailField.setEditable(true);
        passwordField.setEditable(true);
        addressField.setEditable(true);
        cityField.setEditable(true);
        postalCodeField.setEditable(true);
        phoneField.setEditable(true);

        // Button change
        modifyButton.setVisible(false);
        saveButton.setVisible(true);
    }

    public void saveButtonOnAction(){
        // Set all textfields editable
        firstNameField.setEditable(false);
        lastNameField.setEditable(false);
        ageField.setEditable(false);
        emailField.setEditable(false);
        passwordField.setEditable(false);
        addressField.setEditable(false);
        cityField.setEditable(false);
        postalCodeField.setEditable(false);
        phoneField.setEditable(false);

        confirmPasswordField.setVisible(false);
        passwordMessageLabel.setVisible(false);
        confirmPasswordStarLabel.setVisible(false);

        if(firstNameField.getText().isEmpty() || lastNameField.getText().isEmpty() || ageField.getText().isEmpty() ||phoneField.getText().isEmpty() || addressField.getText().isEmpty() || cityField.getText().isEmpty() || postalCodeField.getText().isEmpty() || emailField.getText().isEmpty() || passwordField.getText().isEmpty() || confirmPasswordField.getText().isEmpty()) {
            uncompleteFieldsMessageLabel.setText("Please, complete every fields");
            return;
        }
        if(!emailField.getText().endsWith("@patient.com")) {
            emailMessageLabel.setText("* Error format");
            return;
        }

        // Button change
        modifyButton.setVisible(true);
        saveButton.setVisible(false);

        PatientModel patientUpdated = new PatientModel(firstNameField.getText(), lastNameField.getText(), Integer.parseInt(ageField.getText()), 0, emailField.getText(), passwordField.getText(), addressField.getText(), cityField.getText(), postalCodeField.getText(), phoneField.getText());
        // TO DO : modify patient in database (modifie tous les attributs car height n'est pas modifie par l'utilisateru. ou alors recupere son height)
    }

    /** Method initializing all the actions
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        String email = null, password = null;
        HomePagePatient homePagePatient = new HomePagePatient();
        String emailUser = homePagePatient.getUserEmailInfo();
        String passwordUser = homePagePatient.getUserPasswordInfo();

        // Get the patient from the database
        //PatientModel patient = new PatientModel().getPatientByEmailAndPassword(emailUser, passwordUser);
        PatientModel patient = new PatientModel("Clara", "Lacour", 21, 65, "clara1lacour@patient.com", "blabla", "12 Rue du Paradis", "Paris", "75017", "+33 6 54 54 54 54");
        firstNameField.setPromptText(patient.getFirstName());
        lastNameField.setPromptText(patient.getLastName());
        ageField.setPromptText(String.valueOf(patient.getAge()));
        emailField.setPromptText(patient.getEmail());
        passwordField.setPromptText(patient.getPassword());
        addressField.setPromptText(patient.getAddress());
        cityField.setPromptText(patient.getCity());
        postalCodeField.setPromptText(patient.getPostalCode());
        phoneField.setPromptText(patient.getPhoneNumber());

        // Hidden confirmPasswordField
        confirmPasswordField.setEditable(false);
        confirmPasswordField.setVisible(false);
        passwordMessageLabel.setVisible(false);
        confirmPasswordStarLabel.setVisible(false);
        confirmPasswordField.setText(" ");

        passwordField.textProperty().addListener((observableValue, oldValue, newValue) -> {
            if(!patient.getPassword().equals(passwordField.getText())){
                confirmPasswordField.setEditable(true);
                confirmPasswordField.setVisible(true);
                passwordMessageLabel.setVisible(true);
                confirmPasswordStarLabel.setVisible(true);
            }
            else{
                confirmPasswordField.setEditable(false);
                confirmPasswordField.setVisible(false);
            }
        });
    }
}
