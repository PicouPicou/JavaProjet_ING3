package com.example.projet_rdv_medical;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HomePagePatient {

    private Parent parent;
    private Scene scene;
    private Stage stage;

    public String userEmail;
    public String userPassword;

    /** Method disconnecting the user when the button is pressed
     * @param event Listener on the button
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

    /** Method searching an appointment when the button is pressed
     * @param event Listener on a button
     */
    public void searchAppointmentPageButtonOnAction (ActionEvent event){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("searchAppointmentPage.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.getMessage();
        }
    }

    /** Method searching a doctor when the button is pressed
     * @param event Listener on the button
     */
    public void searchDoctorButtonOnAction (ActionEvent event){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("searchDoctor.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.getMessage();
        }
    }

    /** Method searching an appointment when the button is pressed
     * @param userEmail email of the user connected
     * @param userPassword password of the user connected
     */
    public void setUserInfo(String userEmail, String userPassword) {
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        System.out.print(this.userEmail);
        System.out.print(this.userPassword);
    }

    /***/
    public String getUserEmailInfo(){
        return this.userEmail;
    }
    public String getUserPasswordInfo(){
        return this.userPassword;
    }

    /** Method permitting the modification of the user when the button is pressed
     * @param event Listener on the button
     */
    public void modifyAccountButtonOnAction (ActionEvent event){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("patientAccount-view-2.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
