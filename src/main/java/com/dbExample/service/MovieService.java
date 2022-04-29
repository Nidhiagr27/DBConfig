package com.dbExample.service;

import com.dbExample.accessor.MovieAccessor;
import com.dbExample.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MovieService {

    @Autowired
    private MovieAccessor movieAccessor;

    public List<Movie> getMovies(){
        return movieAccessor.getMovies();
    }
}
