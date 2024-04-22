package com.example.projet_rdv_medical;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MeetingPatientController {
    /** Method confirming the meeting when the button is pressed
     * @param event Listener on the Reschedule button
     */
    public void confirmButtonOnAction(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("HomePagePatient-view.fxml"));
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
            FXMLLoader loader = new FXMLLoader(getClass().getResource("HomePagePatient-view.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
        } catch (IOException e) {
            e.getMessage();
        }
    }

    /** Method modifying the date and the time of the meeting when the button is pressed
     * @param event Listener on the Reschedule button
     */
    public void rescheduleButtonOnAction(ActionEvent event) {
        // TO DO : Aller à la page date
        /*try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("date-view.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
        } catch (IOException e) {
            e.getMessage();
        }*/

        // Update le rdv dans la bdd

    }

}
