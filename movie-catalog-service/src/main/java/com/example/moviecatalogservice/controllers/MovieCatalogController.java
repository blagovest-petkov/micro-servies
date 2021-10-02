package com.example.moviecatalogservice.controllers;

import com.example.moviecatalogservice.models.CatalogItem;
import com.example.moviecatalogservice.models.Movie;
import com.example.moviecatalogservice.models.UserRating;
import com.example.moviecatalogservice.services.MovieInfoService;
import com.example.moviecatalogservice.services.RatingDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogController {

    // Use this for advanced load balanced
    /*@Autowired
    private DiscoveryClient discoveryClient;*/

    /*@Autowired
    private WebClient.Builder webClientBuilder;*/

    @Autowired
    private RatingDataService ratingDataService;

    @Autowired
    private MovieInfoService movieInfoService;

    @RequestMapping("/{userId}")
    public List<CatalogItem> getCatalog(@PathVariable("userId") String userId) {

        UserRating userRating = ratingDataService.getUserRating(userId);

        return userRating.userRating.stream().map(rating -> {
            Movie movie = movieInfoService.getUserRating(rating.movieId);
            /*Movie movie = webClientBuilder.build()
                    .get()
                    .uri("http://localhost:8082/movies/" + rating.getMovieId())
                    .retrieve()
                    .bodyToMono(Movie.class)
                    .block();*/


            return new CatalogItem(movie.data.name, "Desc", rating.rating);
        }).collect(Collectors.toList());
    }
}
