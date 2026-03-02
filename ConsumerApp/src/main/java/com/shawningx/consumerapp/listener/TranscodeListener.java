package com.shawningx.consumerapp.listener;

import com.shawningx.consumerapp.service.TranscodeService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class TranscodeListener {

    private final TranscodeService service;

    public TranscodeListener(TranscodeService service) {
        this.service = service;
    }

    @RabbitListener(queues = "transcode-queue")
    public void handle(String jobId) throws InterruptedException {
        service.process(jobId);
    }
}
