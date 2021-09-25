package com.example.movieinfoservice.resources;

import com.example.movieinfoservice.models.Movie;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieResource {


    @RequestMapping("/{movieId}")
    public List<Movie> getCatalog(@PathVariable("movieId") String movieId) {

        return Collections.singletonList(new Movie(movieId, "Test name"));
    }
}
