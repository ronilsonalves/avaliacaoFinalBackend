package com.ronilsonalves.catalogservice.service.impl;

import com.ronilsonalves.catalogservice.dto.CatalogDTO;
import com.ronilsonalves.catalogservice.exceptions.CircuitBreakerException;
import com.ronilsonalves.catalogservice.model.Movie;
import com.ronilsonalves.catalogservice.repository.MovieFeignClient;
import com.ronilsonalves.catalogservice.service.CatalogService;
import io.github.resilience4j.circuitbreaker.CallNotPermittedException;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.AllArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CatalogServiceImpl implements CatalogService {

    private final MovieFeignClient movieFeignClient;

    private RabbitTemplate rabbitTemplate;

    @Override
    @CircuitBreaker(name="movie-service",fallbackMethod="getMovieFallbackValue")
    @Retry(name = "movie-service")
    public Movie getMovieById(Long movieId) {
        return movieFeignClient.getMovieById(movieId);
    }

    @Override
    @CircuitBreaker(name = "movie-service", fallbackMethod = "getCatalogFallbackValue")
    @Retry(name = "movie-service")
    public CatalogDTO getMoviesByGenre(String genre) {
        List<Movie> movies = movieFeignClient.getMoviesByGenre(genre);
        return new CatalogDTO(genre.toUpperCase(),movies);
    }

    @Override
    public void addNewMovie(Movie movie){
        rabbitTemplate.convertAndSend("MovieServiceQueue",movie);
    }


    public CatalogDTO getCatalogFallbackValue(CallNotPermittedException e) throws CircuitBreakerException {
        throw new CircuitBreakerException("Circuit breaker was activated: Some error while trying to fetch movies for Catalog object");
    }

    public Movie getMovieFallbackValue(CallNotPermittedException e) throws CircuitBreakerException {
        throw new CircuitBreakerException("Circuit breaker was activated: Some error occurred while trying to get a movie from movie-service");
    }

}
