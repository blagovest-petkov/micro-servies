package com.example.movieinfoservice.controlers;

import com.example.movieinfoservice.models.Movie;
import com.example.movieinfoservice.services.ExternalApiService;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/movies")
public class MovieControler {

    @Autowired
    private ExternalApiService apiService;

    @RequestMapping("/{movieId}")
    public Movie getMovieInfo(@PathVariable("movieId") String movieId) throws JsonProcessingException {
        /*String str = "{\n" +
                "        \"data\": {\n" +
                "            \"id\": 2,\n" +
                "            \"name\": \"fuchsia rose\",\n" +
                "            \"year\": 2001,\n" +
                "            \"color\": \"#C74375\",\n" +
                "            \"pantone_value\": \"17-2031\"\n" +
                "        },\n" +
                "        \"support\": {\n" +
                "            \"url\": \"https://reqres.in/#support-heading\",\n" +
                "            \"text\": \"To keep ReqRes free, contributions towards server costs are appreciated!\"\n" +
                "        }\n" +
                "    }";
        ObjectMapper om = new ObjectMapper();
        om.configure(DeserializationFeature.UNWRAP_ROOT_VALUE, true);
        //om.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        System.out.println(om.readValue(str, Movie.class));*/
        return apiService.getMovie(movieId);
    }
}
