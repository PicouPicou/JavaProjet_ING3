package com.example.projet_rdv_medical;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class MeetingDoctorController {
    @FXML
    private Text namePatientText;
    @FXML
    private Text nameDoctorField;
    @FXML
    private Text clinicField;
    @FXML
    private Text dateField;
    @FXML
    private Text hourField;
    @FXML
    private Text specializationField;


    /** Method replacing the doctor of the meeting when the button is pressed
     * @param event Listener on the Get replaced button
     */
    public void getReplacedButtonOnAction(ActionEvent event) {
        // TO DO : Change the doctor
    }

    /** Method modifying the date and the time of the meeting when the button is pressed
     * @param event Listener on the Reschedule button
     */
    public void rescheduleButtonOnAction(ActionEvent event) {
        // Go to the date view
    }

    /** Method confirming the meeting when the button is pressed
     * @param event Listener on the Reschedule button
     */
    public void confirmButtonOnAction(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("HomePageDoctor-view.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
        } catch (IOException e) {
            e.getMessage();
        }
    }

    /** Method canceling the meeting when the button is pressed
     * @param event Listener on the Reschedule button
     */
    public void cancelButtonOnAction(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("HomePageDoctor-view.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
        } catch (IOException e) {
            e.getMessage();
        }
    }
}
