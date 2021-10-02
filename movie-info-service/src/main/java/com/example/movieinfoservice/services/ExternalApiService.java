package com.example.movieinfoservice.services;

import com.example.movieinfoservice.models.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ExternalApiService {

    @Autowired
    private RestTemplate restTemplate;

    public Movie getMovie(String movieId) {
       return restTemplate.getForObject("https://reqres.in/api/unknown/" + movieId, Movie.class);
    }
}
