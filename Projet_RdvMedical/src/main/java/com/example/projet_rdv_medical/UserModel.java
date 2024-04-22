package com.example.projet_rdv_medical;

import java.io.PrintStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserModel {
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private int age;
    private String email;
    private String address;
    private String city;
    private String postalCode;
    private String phoneNumber;

    // Constructeur par défaut
    public UserModel() { }

    // Constructeur avec tous les attributs
    public UserModel(String password, String firstName, String lastName, int age, String email, String address, String city, String postalCode, String phoneNumber) {
        //this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.email = email;
        this.address = address;
        this.city = city;
        this.postalCode = postalCode;
        this.phoneNumber = phoneNumber;
    }

    /*@Override
    public void add(UserModel user) {
        try {
            Connection conn = DriverManager.getConnection(Database.URL, Database.USERNAME, Database.PASSWORD);
            String query = "INSERT INTO User (password, first_name, last_name, age, email, address, city, postal_code, phone_number) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, user.getPassword());
            stmt.setString(2, user.getFirstName());
            stmt.setString(3, user.getLastName());
            stmt.setInt(4, user.getAge());
            stmt.setString(5, user.getEmail());
            stmt.setString(6, user.getAddress());
            stmt.setString(7, user.getCity());
            stmt.setString(8, user.getPostalCode());
            stmt.setString(9, user.getPhoneNumber());
            stmt.executeUpdate();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<UserModel> getAll() {
        List<UserModel> users = new ArrayList<>();
        try {
            Connection conn = DriverManager.getConnection(Database.URL, Database.USERNAME, Database.PASSWORD);
            String query = "SELECT * FROM User";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                UserModel user = new UserModel(
                        //rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getInt("age"),
                        rs.getString("email"),
                        rs.getString("address"),
                        rs.getString("city"),
                        rs.getString("postal_code"),
                        rs.getString("phone_number")
                );
                users.add(user);
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public void delete(UserModel userToDelete){
        System.out.println("delete");
    }

    public UserModel getUserByEmailAndPassword(String email, String password) {
        try {
            Connection conn = DriverManager.getConnection(Database.URL, Database.USERNAME, Database.PASSWORD);
            String query = "SELECT * FROM User WHERE email = ? AND password = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, email);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                UserModel user = new UserModel(
                        rs.getString("password"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getInt("age"),
                        rs.getString("email"),
                        rs.getString("address"),
                        rs.getString("city"),
                        rs.getString("postal_code"),
                        rs.getString("phone_number")
                );
                conn.close();
                return user; // Return the user found in the database
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; // If the user does not exist
    }

    public static void printAllUsers(List<UserModel> users) {
        for (UserModel user : users) {
            System.out.println("Username: " + user.getUsername());
            System.out.println("First Name: " + user.getFirstName());
            System.out.println("Last Name: " + user.getLastName());
            System.out.println("Age: " + user.getAge());
            System.out.println("Email: " + user.getEmail());
            System.out.println("Address: " + user.getAddress());
            System.out.println("City: " + user.getCity());
            System.out.println("Postal Code: " + user.getPostalCode());
            System.out.println("Phone Number: " + user.getPhoneNumber());
            System.out.println();
        }
    }*/


    // Getters et Setters
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getPostalCode() {
        return postalCode;
    }
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
