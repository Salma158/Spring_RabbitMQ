package com.rabbitMQ.message.controller;

import com.rabbitMQ.message.dto.TokenDto;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class MessageController {

    public static final Logger log = LoggerFactory.getLogger(MessageController.class);
    private final StreamBridge streamBridge;

    @PostMapping("/verify")
    public ResponseEntity<String> verify(@RequestBody TokenDto tokenDto) {
        log.info("Logic for verifying user token ...");

        boolean result = streamBridge.send("verify-out-0", tokenDto.id());

        if (result) {
            log.info("Communication request successfully triggered for user: {}", tokenDto.id());
            return ResponseEntity.ok("User account activated successfully");
        } else {
            log.error("Failed to send communication request for user: {}", tokenDto.id());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to activate user account");
        }
    }
}
