package com.ronilsonalves.catalogservice.repository;

import com.ronilsonalves.catalogservice.model.Serie;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface SerieRepository extends MongoRepository<Serie, String> {

    List<Serie> findAllByGenre(String genre);
}
