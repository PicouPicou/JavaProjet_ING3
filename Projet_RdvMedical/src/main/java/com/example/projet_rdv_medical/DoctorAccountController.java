package com.example.projet_rdv_medical;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DoctorAccountController implements Initializable {
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
    private TextField specialization;
    @FXML
    private TextField clinique;
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

        // Get the information
        DoctorModel doctor = new DoctorModel("Celine", "Idir", 21, "celineidir@doctor.com", "ididi", "12 Rue du Sotiti", "Paris", "75017", "+33 6 44 44 44 44", "Cardiologist", "Clinique Bellevue");

        firstNameField.setText(doctor.getFirstName());
        lastNameField.setText(doctor.getLastName());
        ageField.setText(String.valueOf(doctor.getAge()));
        emailField.setText(doctor.getEmail());
        passwordField.setText(doctor.getPassword());
        addressField.setText(doctor.getAddress());
        cityField.setText(doctor.getCity());
        postalCodeField.setText(doctor.getPostalCode());
        phoneField.setText(doctor.getPhoneNumber());
        specialization.setText(doctor.getSpecialization());
        clinique.setText(doctor.getCliniqueList());

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
        specialization.setEditable(true);
        clinique.setEditable(true);

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
        specialization.setEditable(false);
        clinique.setEditable(false);

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

        //DoctorModel doctorUpdated = new DoctorModel(firstNameField.getText(), lastNameField.getText(), Integer.parseInt(ageField.getText()), emailField.getText(), passwordField.getText(), addressField.getText(), cityField.getText(), postalCodeField.getText(), phoneField.getText(), specialization.getText(), clinique.getText());
        updateDoctor(emailField.getText());
    }

    public void updateDoctor(String email) {
        try ( Connection conn = DriverManager.getConnection(Database.URL, Database.USERNAME, Database.PASSWORD)) {
            String query = "UPDATE doctor SET first_name = ?, last_name = ?, age = ?, password = ?, address = ?, city = ?, postal_code = ?, phone_number = ?, specialization = ?, cliniques = ? WHERE email = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, firstNameField.getText());
            stmt.setString(2, lastNameField.getText());
            stmt.setInt(3, Integer.parseInt(ageField.getText()));
            stmt.setString(4, passwordField.getText());
            stmt.setString(5, addressField.getText());
            stmt.setString(6, cityField.getText());
            stmt.setString(7, postalCodeField.getText());
            stmt.setString(8, phoneField.getText());
            stmt.setString(9, specialization.getText());
            stmt.setString(10, clinique.getText());
            stmt.setString(11, email);
            stmt.executeUpdate();

            System.out.println("Doctor updated !");
        } catch (SQLException e) {
            e.printStackTrace();
        }
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
