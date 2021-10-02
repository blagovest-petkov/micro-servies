package com.example.ratingdataservice.models;

import java.util.List;

public class UserRating {
    public List<Rating> userRating;

    public UserRating() {
    }

    public UserRating(List<Rating> userRating) {
        this.userRating = userRating;
    }
}
