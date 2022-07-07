package com.ronilsonalves.catalogservice.repository;

import com.ronilsonalves.catalogservice.model.Chapter;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ChapterRepository extends MongoRepository<Chapter, String> {
}
