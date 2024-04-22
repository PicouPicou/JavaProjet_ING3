package com.example.projet_rdv_medical;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HomePageDoctor {
    /** Method disconnecting the user clincking on the button
     * @param event Listener
     */
    public void disconnectButtonOnAction (ActionEvent event){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("welcome-view-2.fxml"));
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
