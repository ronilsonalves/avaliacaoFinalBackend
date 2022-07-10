package com.ronilsonalves.movieservice.service.impl;

import com.ronilsonalves.movieservice.model.Movie;
import com.ronilsonalves.movieservice.repository.MovieRepository;
import com.ronilsonalves.movieservice.service.MovieService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.AllArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
@AllArgsConstructor
public class MovieServiceImpl implements MovieService {

    private static final Logger log = Logger.getLogger(MovieServiceImpl.class.getName());

    private final MovieRepository movieRepository;
    private RabbitTemplate rabbitTemplate;

    @Override
    @CircuitBreaker(name="movie-service")
    @Retry(name="movie-service")
    public List<Movie> getAllByGenre(String genre) {
        return movieRepository.findAllByGenre(genre);
    }

    @Override
    @CircuitBreaker(name="movie-service")
    @Retry(name="movie-service")
    public Movie getMovieById(Long movieId) {
        return movieRepository.findById(movieId).orElse(null);
    }

    @Override
    @CircuitBreaker(name="movie-service")
    @Retry(name="movie-service")
    public Movie saveMovie(Movie movie) {
        String movieNameAux = movie.getName();
        movie.setName(movieNameAux.toLowerCase());
        log.info("Saving new movie on service's database...");
        Movie movieSaved = movieRepository.save(movie);
        log.info("Movie saved on db!\n Now sending message to Rabbit Queue to update data on catalogService...");
        rabbitTemplate.convertAndSend("MovieServiceQueue",movie);
        log.info("... message sent to catalogService via Rabbit service!");
        return movieSaved;
    }
}
