package com.example.Spring.MongoDB.models;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="voters")
public class VoterCard {
    private int id;

    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAadhar() {
        return aadhar;
    }

    public void setAadhar(String aadhar) {
        this.aadhar = aadhar;
    }

    private String city;
    private String aadhar;

    public VoterCard(int id, String name, String city, String aadhar) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.aadhar = aadhar;
    }
}
