package com.ronilsonalves.catalogservice.service;

import com.ronilsonalves.catalogservice.dto.CatalogDTO;
import com.ronilsonalves.catalogservice.model.Movie;
import com.ronilsonalves.catalogservice.model.Serie;

public interface CatalogService {

    Movie getMovieById(String movieId);

    CatalogDTO getCatalogByGenre(String genre);

    void addNewMovie(Movie movie);

    void addNewSerie(Serie serie);
}
