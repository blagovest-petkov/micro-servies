package com.example.moviecatalogservice.models;

public class Movie {

    private String id;
    private String name;

    public Movie() {
    }

    public Movie(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String geId() {
        return id;
    }

    public void seId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
