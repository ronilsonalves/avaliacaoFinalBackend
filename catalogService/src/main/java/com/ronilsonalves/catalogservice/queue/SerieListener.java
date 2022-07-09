package com.ronilsonalves.catalogservice.queue;

import com.ronilsonalves.catalogservice.model.Serie;
import com.ronilsonalves.catalogservice.service.impl.CatalogServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class SerieListener {

    private final CatalogServiceImpl catalogService;

    @RabbitListener(queues = {"${queue.series-service.name}"})
    public void receiveMessage(Serie serie) {
        catalogService.addNewSerie(serie);
    }
}
