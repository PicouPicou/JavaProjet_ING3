package com.example.projet_rdv_medical;

import java.util.List;

public interface Database<T> {
    String URL = "jdbc:mysql://localhost:3306/health&care";
    String USERNAME = "root";
    String PASSWORD = "root";

    /**
    * Method adding a T data to the database
    * @param item the object to add
    */
    void add(T item);

    /**
     * Method deleting a T data to the database
     * @param item the object to delete
     */
    void delete(T item);

    /**
     * Method getting all the item T of a table from the database
     * @return List<T> the list with all the object T
     */
    List<T> getAll();
}
