package com.example.moviecatalogservice.models;

public class Rating {

    public String movieId;
    public int rating;

    public Rating() {
    }

    public Rating(String movieId, int rating) {
        this.movieId = movieId;
        this.rating = rating;
    }

}
