package com.ronilsonalves.catalogservice.service;

import com.ronilsonalves.catalogservice.dto.CatalogDTO;
import com.ronilsonalves.catalogservice.model.Movie;

public interface CatalogService {

    Movie getMovieById(Long movieId);

    CatalogDTO getMoviesByGenre(String genre);

    void addNewMovie(Movie movie);
}
