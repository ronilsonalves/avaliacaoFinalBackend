package com.ronilsonalves.serieservice.repository;

import com.ronilsonalves.serieservice.model.Chapter;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ChapterRepository extends MongoRepository<Chapter, String> {
}
