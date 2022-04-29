package com.dbExample;

import com.dbExample.model.Movie;
import com.dbExample.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping("/movies")
    private List<Movie> getListOfMovies(){
       return movieService.getMovies();
    }
}
