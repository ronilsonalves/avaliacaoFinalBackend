package com.ronilsonalves.catalogservice.repository;

import com.ronilsonalves.catalogservice.model.Season;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SeasonRepository extends MongoRepository<Season, String> {
}
