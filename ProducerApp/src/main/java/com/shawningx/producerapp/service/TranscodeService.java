package com.shawningx.producerapp.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class TranscodeService {
    private final RabbitTemplate rabbitTemplate;

    public TranscodeService(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void transcodeAsync(String fileName) {

        rabbitTemplate.convertAndSend(
                "transcode-queue",
                fileName
        );

        System.out.println("Sent message: " + fileName);
    }

    public String transcodeSync(String fileName) throws InterruptedException {
        System.out.println("Processing file: " + fileName);
        Thread.sleep(10000);
        System.out.println("Done processing file: " + fileName);
        return "OK";
    }


}
