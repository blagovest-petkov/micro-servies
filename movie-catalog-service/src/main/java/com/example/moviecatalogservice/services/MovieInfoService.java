package com.example.moviecatalogservice.services;

import com.example.moviecatalogservice.models.Data;
import com.example.moviecatalogservice.models.Movie;
import com.example.moviecatalogservice.models.Rating;
import com.example.moviecatalogservice.models.UserRating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.CircuitBreaker;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@Service
public class MovieInfoService {

    @Autowired
    private CircuitBreakerFactory circuitBreakerFactory;

    @Autowired
    private RestTemplate restTemplate;

    public Movie getUserRating(String movieId) {
        CircuitBreaker circuitBreaker = circuitBreakerFactory.create("circuitbreaker");
        String url = "http://movie-info-service/movies/" + movieId;

        return circuitBreaker.run(
                () -> restTemplate.getForObject(url, Movie.class),
                throwable -> getDefaultMovie()
        );
    }

    private Movie getDefaultMovie() {
        Movie movie = new Movie();
        movie.data = new Data(0, "Default Name");
        return movie;
    }
}
