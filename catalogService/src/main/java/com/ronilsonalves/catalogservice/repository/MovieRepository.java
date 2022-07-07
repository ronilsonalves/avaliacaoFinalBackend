package com.ronilsonalves.catalogservice.repository;

import com.ronilsonalves.catalogservice.model.Movie;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface MovieRepository extends MongoRepository<Movie, String> {

    List<Movie> findAllByGenre (String genre);
}
