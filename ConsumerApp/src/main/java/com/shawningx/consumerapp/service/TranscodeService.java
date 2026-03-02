package com.shawningx.consumerapp.service;

import org.springframework.stereotype.Service;

@Service
public class TranscodeService {

    public void process(String jobId) throws InterruptedException {
        System.out.println("Container: " + System.getenv("HOSTNAME") + " processing job: " + jobId);
        Thread.sleep(10000);
        System.out.println("Container: " + System.getenv("HOSTNAME") + " DONE job: " + jobId);
    }
}