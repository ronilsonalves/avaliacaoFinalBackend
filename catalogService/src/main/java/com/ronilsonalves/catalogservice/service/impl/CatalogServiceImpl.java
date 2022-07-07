package com.ronilsonalves.catalogservice.service.impl;

import com.ronilsonalves.catalogservice.dto.CatalogDTO;
import com.ronilsonalves.catalogservice.exceptions.CircuitBreakerException;
import com.ronilsonalves.catalogservice.model.Movie;
import com.ronilsonalves.catalogservice.model.Serie;
import com.ronilsonalves.catalogservice.repository.MovieFeignClient;
import com.ronilsonalves.catalogservice.repository.MovieRepository;
import com.ronilsonalves.catalogservice.repository.SerieRepository;
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

    private final SerieRepository serieRepository;
    private final MovieRepository movieRepository;

    private RabbitTemplate rabbitTemplate;

    @Override
    public Movie getMovieById(String movieId) {
        return movieRepository.findById(movieId).orElse(null);
    }

    @Override
    public CatalogDTO getCatalogByGenre(String genre) {
        List<Movie> movies = movieRepository.findAllByGenre(genre);
        List<Serie> series = serieRepository.findAllByGenre(genre);
        return new CatalogDTO(genre.toUpperCase(),movies,series);
    }

    @Override
    public void addNewMovie(Movie movie){
        rabbitTemplate.convertAndSend("MovieServiceQueue",movie);
    }

    @Override
    public void addNewSerie(Serie serie) {
        rabbitTemplate.convertAndSend("SerieServiceQueue",serie);
    }


//    public CatalogDTO getCatalogFallbackValue(CallNotPermittedException e) throws CircuitBreakerException {
//        throw new CircuitBreakerException("Circuit breaker was activated: Some error while trying to fetch movies for Catalog object");
//    }
//
//    public Movie getMovieFallbackValue(CallNotPermittedException e) throws CircuitBreakerException {
//        throw new CircuitBreakerException("Circuit breaker was activated: Some error occurred while trying to get a movie from movie-service");
//    }

}
