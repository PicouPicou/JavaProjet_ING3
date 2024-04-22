package com.example.projet_rdv_medical;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class HelloApplication extends Application {
    /** Method starting the program
     * @param stage
     * @exception IOException
     */
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("welcome-view-2.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 850, 650);
        stage.setTitle("Welcome");//("Login Page");
        stage.setScene(scene);
        stage.show();
    }

    /** Main
     * @param args
     */
    public static void main(String[] args) {
        try {
            Connection conn = DriverManager.getConnection(Database.URL, Database.USERNAME, Database.PASSWORD);
            System.out.print("Connected");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        launch();
    }
}