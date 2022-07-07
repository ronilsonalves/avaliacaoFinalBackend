package com.ronilsonalves.catalogservice.queue;

import com.ronilsonalves.catalogservice.model.Movie;
import com.ronilsonalves.catalogservice.service.impl.CatalogServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class MovieListener {

    private final CatalogServiceImpl catalogService;

    @RabbitListener(queues = {"${queue.movie-service.name}"})
    public void receiveMessage(Movie movie) {
        catalogService.addNewMovie(movie);
    }
}