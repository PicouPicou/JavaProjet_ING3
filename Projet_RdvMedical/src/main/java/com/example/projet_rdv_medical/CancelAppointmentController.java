package com.example.projet_rdv_medical;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class CancelAppointmentController {
    /** Method making the confirmation of the meetin
     * @param event Listener
     */
    public void confirmCancelAction(ActionEvent event){
    //    AppointmentModel appointment = new AppointmentModel();
    //  appointment.setAvailable(appointment);
    //  appointment.deleteAppointment();
    }

    /** Method going back of the meeting cancelling
     * @param event Listener
     */
    public void cancelAction(ActionEvent event){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("meeetingPatient-view.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
        } catch (IOException e) {
            e.getMessage();
        }
    }
}