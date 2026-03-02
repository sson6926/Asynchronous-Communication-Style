package com.shawningx.producerapp.controller;

import com.shawningx.producerapp.service.TranscodeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class TranscodeController {
    private final TranscodeService service;

    public TranscodeController(TranscodeService service) {
        this.service = service;
    }

    @PostMapping("/transcode")
    public ResponseEntity<Map<String, String>> transcode() {

        String jobId = UUID.randomUUID().toString();

        service.transcodeAsync(jobId);

        return ResponseEntity.ok(
                Map.of(
                        "jobId", jobId,
                        "status", "submitted"
                )
        );

    }

    @PostMapping("/transcode/sync")
    public ResponseEntity<Map<String, String>> transcodeSync() throws InterruptedException {

        String fileName = UUID.randomUUID().toString();
        String res = service.transcodeSync(fileName);
        return ResponseEntity.ok().body(Map.of(
                "fileName", fileName,
                "status", res
        ));
    }
}
