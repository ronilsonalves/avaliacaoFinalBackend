package com.ronilsonalves.movieservice.service.impl;

import com.ronilsonalves.movieservice.model.Movie;
import com.ronilsonalves.movieservice.repository.MovieRepository;
import com.ronilsonalves.movieservice.service.MovieService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;

    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public List<Movie> getAllByGenre(String genre) {
        return movieRepository.findAllByGenre(genre);
    }

    @Override
    public Movie getMovieById(Long movieId) {
        return movieRepository.findById(movieId).orElse(null);
    }

    @Override
    public Movie saveMovie(Movie movie) {
        return movieRepository.save(movie);
    }
}
