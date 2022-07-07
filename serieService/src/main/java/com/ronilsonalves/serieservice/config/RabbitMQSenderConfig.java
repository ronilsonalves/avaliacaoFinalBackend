package com.ronilsonalves.serieservice.config;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQSenderConfig {

    @Value("${queue.serie-service.name")
    private String serieServiceQueue;

    @Bean Queue queue () {
        return new Queue(this.serieServiceQueue, false);
    }
}
