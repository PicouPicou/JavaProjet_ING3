package com.example.projet_rdv_medical;

public class CliniqueModel {
    // Attributes
    private String name;

    // Constructor
    public CliniqueModel(String name){
        this.name = name;
    }

    // Getter & Setter
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
}
