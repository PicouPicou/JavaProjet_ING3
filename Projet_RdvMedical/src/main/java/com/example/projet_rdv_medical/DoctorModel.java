package com.example.projet_rdv_medical;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DoctorModel extends UserModel implements Database<DoctorModel> {
    // Attributes
    private String specialization;
    private String cliniqueList;

    public DoctorModel(String firstName, String lastName, int age,String email, String password, String address, String city, String postalCode, String phoneNumber, String specialization, String cliniques){
        super(password, firstName, lastName, age, email, address, city, postalCode, phoneNumber);
        this.specialization = specialization;
        this.cliniqueList = cliniques;
    }

    public DoctorModel() {
        super();
    }

    /** Method getting an object doctor from the database with the email and the password
     * @param email of the doctor to get
     * @param password of the doctor to get
     */
    public DoctorModel getDoctorByEmailAndPassword(String email, String password) {
        try {
            Connection conn = DriverManager.getConnection(Database.URL, Database.USERNAME, Database.PASSWORD);
            String query = "SELECT * FROM Doctor WHERE email = ? AND password = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, email);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                DoctorModel doctor = new DoctorModel(
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getInt("age"),
                        rs.getString("email"),
                        rs.getString("password"),
                        rs.getString("address"),
                        rs.getString("city"),
                        rs.getString("postal_code"),
                        rs.getString("phone_number"),
                        rs.getString("specialization"),
                        rs.getString("cliniques")
                );
                conn.close();
                return doctor; // Return the patient found in the database
            }
            conn.close();
        } catch (
        SQLException e) {
            e.getMessage();
        }
            return null; // If the patient does not exist
    }

    /** Method adding a doctor in the database
     * @param doctor object to add
     */
    @Override
    public void add(DoctorModel doctor) {
        try {
            Connection conn = DriverManager.getConnection(Database.URL, Database.USERNAME, Database.PASSWORD);
            String query = "INSERT INTO Doctor (first_name, last_name, age, email, password, address, city, postal_code, phone_number, specialization, cliniques) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, doctor.getFirstName());
            stmt.setString(2, doctor.getLastName());
            stmt.setInt(3, doctor.getAge());
            stmt.setString(4, doctor.getEmail());
            stmt.setString(5, doctor.getPassword());
            stmt.setString(6, doctor.getAddress());
            stmt.setString(7, doctor.getCity());
            stmt.setString(8, doctor.getPostalCode());
            stmt.setString(9, doctor.getPhoneNumber());
            stmt.setString(10, doctor.getSpecialization());
            stmt.setString(11, doctor.getCliniqueList());
            stmt.executeUpdate();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /** Method deleting a doctor from the database
     * @param doctor object to delete
     */
    @Override
    public void delete(DoctorModel doctor) {
        try {
            Connection conn = DriverManager.getConnection(Database.URL, Database.USERNAME, Database.PASSWORD);
            String query = "DELETE FROM Doctor WHERE email = ? AND password = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, doctor.getEmail());
            stmt.setString(2, doctor.getPassword());
            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Doctor deleted successfully.");
            } else {
                System.out.println("No doctor found with the given email and password.");
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /** Method getting all the doctors from the database
     * @return doctors : null if no doctor, a list of doctors otherwise
     */
    @Override
    public List<DoctorModel> getAll() {
        List<DoctorModel> doctors = new ArrayList<>();
        try {
            Connection conn = DriverManager.getConnection(Database.URL, Database.USERNAME, Database.PASSWORD);
            String query = "SELECT * FROM Doctor";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                DoctorModel doctor = new DoctorModel(
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getInt("age"),
                        rs.getString("email"),
                        rs.getString("password"),
                        rs.getString("address"),
                        rs.getString("city"),
                        rs.getString("postal_code"),
                        rs.getString("phone_number"),
                        rs.getString("specialization"),
                        rs.getString("cliniques")
                );
                doctors.add(doctor);
            }
            conn.close();
        } catch (SQLException e) {
            e.getMessage();
        }
        return doctors;
    }

    /** Method printing all the doctors
     * @return doctors : null if no doctor, a list of doctors otherwise
     */
    public static void printAllDoctors(List<DoctorModel> doctors) {
        for (DoctorModel doc : doctors) {
            System.out.println("Username: " + doc.getUsername());
            System.out.println("First Name: " + doc.getFirstName());
            System.out.println("Last Name: " + doc.getLastName());
            System.out.println("Age: " + doc.getAge());
            System.out.println("Email: " + doc.getEmail());
            System.out.println("Address: " + doc.getAddress());
            System.out.println("City: " + doc.getCity());
            System.out.println("Postal Code: " + doc.getPostalCode());
            System.out.println("Phone Number: " + doc.getPhoneNumber());
            System.out.println("Specialization: " + doc.getSpecialization());
            System.out.println("Cliniques: " + doc.getCliniqueList());
            System.out.println();
        }
    }

    /** Method searching doctors
     * @param searchTerm keyword of the research
     * @return doctors list of the research
     */
    public List<DoctorModel> searchDoctors(String searchTerm) {
        List<DoctorModel> searchResults = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(Database.URL, Database.USERNAME, Database.PASSWORD)) {
            String query = "SELECT * FROM Doctor WHERE first_name LIKE ? OR last_name LIKE ? OR cliniques LIKE ? OR specialization LIKE ?";
            try (PreparedStatement stmt = conn.prepareStatement(query)) {
                stmt.setString(1, "%" + searchTerm + "%");
                stmt.setString(2, "%" + searchTerm + "%");
                stmt.setString(3, "%" + searchTerm + "%");
                stmt.setString(4, "%" + searchTerm + "%");
                try (ResultSet rs = stmt.executeQuery()) {
                    while (rs.next()) {
                        DoctorModel doctor = new DoctorModel(
                                rs.getString("first_name"),
                                rs.getString("last_name"),
                                rs.getInt("age"),
                                rs.getString("email"),
                                rs.getString("password"),
                                rs.getString("address"),
                                rs.getString("city"),
                                rs.getString("postal_code"),
                                rs.getString("phone_number"),
                                rs.getString("specialization"),
                                rs.getString("cliniques")
                        );
                        searchResults.add(doctor);
                    }
                }
            }
        } catch (SQLException e) {
            e.getMessage();
        }
        return searchResults;
    }

    // Getters & Setters
    public String getSpecialization(){
        return specialization;
    }
    public String getFullName(){
        return super.getFirstName() + ' ' + super.getLastName();
    }
    public String getCliniqueList(){
        return cliniqueList;
    }
}
