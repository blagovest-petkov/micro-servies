package com.example.moviecatalogservice.models;

public class CatalogItem {

    public String name;
    public String desc;
    public int rating;

    public CatalogItem() {
    }

    public CatalogItem(String name, String desc, int rating) {
        this.name = name;
        this.desc = desc;
        this.rating = rating;
    }
}
