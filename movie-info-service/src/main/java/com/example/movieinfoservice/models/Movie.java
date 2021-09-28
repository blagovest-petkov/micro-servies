package com.example.movieinfoservice.models;

import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName(value = "data")
public class Movie {

    /*{
        "data": {
            "id": 2,
            "name": "fuchsia rose",
            "year": 2001,
            "color": "#C74375",
            "pantone_value": "17-2031"
        },
        "support": {
            "url": "https://reqres.in/#support-heading",
            "text": "To keep ReqRes free, contributions towards server costs are appreciated!"
        }
    }*/

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
