package com.example.projet_rdv_medical;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public class PatientModel extends UserModel implements Database<PatientModel> {
    // Attributes
    private float height;

    // Constructors
    public PatientModel(){
        super();
    }

    public PatientModel(String firstName, String lastName, int age, float height,String email, String password, String address, String city, String postalCode, String phoneNumber){
        super(password, firstName, lastName, age, email, address, city, postalCode, phoneNumber);
        this.height = height;
    }

    /** Method adding a patient to the database
     * @param patient
     */
    @Override
    public void add(PatientModel patient) {
        try {
            Connection conn = DriverManager.getConnection(Database.URL, Database.USERNAME, Database.PASSWORD);
            String query = "INSERT INTO Patient (first_name, last_name, age, height, email, password, address, city, postal_code, phone_number) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, patient.getFirstName());
            stmt.setString(2, patient.getLastName());
            stmt.setInt(3, patient.getAge());
            stmt.setFloat(4, patient.getHeight());
            stmt.setString(5, patient.getEmail());
            stmt.setString(6, patient.getPassword());
            stmt.setString(7, patient.getAddress());
            stmt.setString(8, patient.getCity());
            stmt.setString(9, patient.getPostalCode());
            stmt.setString(10, patient.getPhoneNumber());
            stmt.executeUpdate();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(PatientModel patient) {
        try {
            Connection conn = DriverManager.getConnection(Database.URL);
            String query = "DELETE FROM Patient WHERE email = ? AND password = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, patient.getEmail());
            stmt.setString(2, patient.getPassword());
            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Patient deleted successfully.");
            } else {
                System.out.println("No patient found with the given email and password.");
            }
            conn.close();
        } catch (SQLException e) {
            e.getMessage();
        }
    }

    @Override
    public List<PatientModel> getAll() {
        List<PatientModel> patients = new ArrayList<>();
        try {
            Connection conn = DriverManager.getConnection(Database.URL, Database.USERNAME, Database.PASSWORD);
            String query = "SELECT * FROM Patient";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                PatientModel patient = new PatientModel(
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getInt("age"),
                        rs.getFloat("height"),
                        rs.getString("email"),
                        rs.getString("password"),
                        rs.getString("address"),
                        rs.getString("city"),
                        rs.getString("postal_code"),
                        rs.getString("phone_number")
                );
                patients.add(patient);
            }
            conn.close();
        } catch (SQLException e) {e.getMessage();}
        return patients;
    }

    public PatientModel getPatientByEmailAndPassword(String email, String password) {
        try {
            Connection conn = DriverManager.getConnection(Database.URL, Database.USERNAME, Database.PASSWORD);
            String query = "SELECT * FROM Patient WHERE email = ? AND password = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, email);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                PatientModel patient = new PatientModel(
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getInt("age"),
                        rs.getFloat("height"),
                        rs.getString("email"),
                        rs.getString("password"),
                        rs.getString("address"),
                        rs.getString("city"),
                        rs.getString("postal_code"),
                        rs.getString("phone_number")
                );
                conn.close();
                return patient; // Return the patient found in the database
            }
            conn.close();
        } catch (SQLException e) {
            e.getMessage();
        }
        return null; // If the patient does not exist
    }


    // Getters & Setters
    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }
}
