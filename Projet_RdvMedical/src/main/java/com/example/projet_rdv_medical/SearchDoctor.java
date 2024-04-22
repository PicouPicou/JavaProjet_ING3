package com.example.projet_rdv_medical;

import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.List;
import java.util.ResourceBundle;

public class SearchDoctor implements Initializable {

    @FXML
    private TextField searchField;

    @FXML
    private TableView<DoctorModel> resultTable;

    @FXML
    private TableColumn<DoctorModel, String> nameColumn;

    @FXML
    private TableColumn<DoctorModel, String> specializationColumn;

    @FXML
    private TableColumn<DoctorModel, String> cliniqueColumn;

    @FXML
    private TableColumn<DoctorModel, String> phoneNumberColumn;


    private DoctorModel doctorModel;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        doctorModel = new DoctorModel();
        resultTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        initializeColumns();
        populateDoctorList();
    }

    private void initializeColumns() {
        nameColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getFullName()));
        specializationColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getSpecialization()));
        cliniqueColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCliniqueList()));
        phoneNumberColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getPhoneNumber()));
    }

    private void populateDoctorList() {
        List<DoctorModel> doctors = doctorModel.getAll();
        resultTable.getItems().addAll(doctors);
    }

    public void returnButtonOnAction (ActionEvent event){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("homePagePatient.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.getMessage();
        }
    }

    @FXML
    private void searchDoctor() {
        String searchTerm = searchField.getText();
        List<DoctorModel> searchResults = doctorModel.searchDoctors(searchTerm);
        resultTable.getItems().clear();
        resultTable.getItems().addAll(searchResults);
    }

}
