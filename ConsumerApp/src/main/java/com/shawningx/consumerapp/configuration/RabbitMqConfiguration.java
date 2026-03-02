package com.shawningx.consumerapp.configuration;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfiguration {

    @Bean
    public Queue transcodeQueue() {
        return new Queue("transcode-queue", true);
    }
}