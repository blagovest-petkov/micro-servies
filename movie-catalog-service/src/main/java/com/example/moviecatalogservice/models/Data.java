package com.example.moviecatalogservice.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Data {
    public Integer id;
    public String name;

    public Data() {
    }

    public Data(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
}
