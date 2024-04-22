package com.example.projet_rdv_medical;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.PasswordAuthentication;
import java.util.Properties;
import java.util.Random;
/*import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;*/


public class PasswordReinitializeController {
    @FXML
    private TextField emailField;
    @FXML
    private Button sendButton;
    @FXML
    private Button cancelButton;
    @FXML
    private Label emailMessageLabel;

    /** Method sending a mail with the new password
     * @param event Listener on the Reschedule button
     */
    public void sendButtonOnAction(ActionEvent event) {
        // Get the email to send the password
        emailMessageLabel.setText("*");
        if((!emailField.getText().endsWith("@patient.com") && !emailField.getText().endsWith("@doctor.com") && !emailField.getText().endsWith("@gmail.com")) || (emailField.getText().isEmpty())) {
            emailMessageLabel.setText("* Error format");
            return;
        }
        // Generate a new password
        String newPassword = generateRandomPassword();
        // Update the database
        // Send the email
        //sendEmail(emailField.getText(), newPassword);
    }

    /** Method canceling from the forgotten password page
     * @param event Listener on the Reschedule button
     */
    public void cancelButtonOnAction(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("login-view-2.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.getMessage();
        }
    }

    /** Method generating a new password
     * @return newPassword
     */
    private String generateRandomPassword() {
        // Define all the possible caracters for the password
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789@.&-_*";
        Random rnd = new Random();

        // Generate a randow String of 10 caracters
        StringBuilder newPassword = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            newPassword.append(chars.charAt(rnd.nextInt(chars.length())));
        }
        return newPassword.toString();
    }

    /** Method generating a new password
     * @return newPassword
     */
    private void sendEmail(String userEmail, String newPassword) {
    }
}
