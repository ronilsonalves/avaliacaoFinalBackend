package com.ronilsonalves.serieservice.repository;

import com.ronilsonalves.serieservice.model.Season;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SeasonRepository extends MongoRepository<Season, String> {
}
