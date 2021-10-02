package com.example.moviecatalogservice.services;

import com.example.moviecatalogservice.models.Rating;
import com.example.moviecatalogservice.models.UserRating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.CircuitBreaker;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@Service
public class RatingDataService {
    @Autowired
    private CircuitBreakerFactory circuitBreakerFactory;

    @Autowired
    private RestTemplate restTemplate;

    public UserRating getUserRating(String userId) {
        CircuitBreaker circuitBreaker = circuitBreakerFactory.create("circuitbreaker");
        String url = "http://rating-data-service/ratingsdata/users/" + userId;

        return circuitBreaker.run(
                () -> restTemplate.getForObject(url, UserRating.class),
                throwable -> getDefaultUserRating()
        );
    }

    private UserRating getDefaultUserRating() {
        UserRating userRating = new UserRating();
        userRating.userRating = Collections.singletonList(new Rating("0", 0));
        return userRating;
    }
}
