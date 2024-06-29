package com.rabbitMQ.accounts.controller;
import com.rabbitMQ.accounts.dto.UserDto;
import com.rabbitMQ.accounts.dto.MessageDto;
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
public class AuthContoller {

    public static final Logger log = LoggerFactory.getLogger(AuthContoller.class);
    private final StreamBridge streamBridge;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody UserDto userDetails) {
        log.info("Logic for creating user account ... : {}", userDetails);

        MessageDto msgDto = new MessageDto(userDetails.id(), userDetails.name(), userDetails.email());
        log.info("Sending communication request for the details: {}", msgDto);

        boolean result = streamBridge.send("sendCommunication-out-0", msgDto);

        if (result) {
            log.info("Communication request successfully triggered for user: {}", userDetails.name());
            return ResponseEntity.ok("User registered successfully");
        } else {
            log.error("Failed to send communication request for user: {}", userDetails.name());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to register user");
        }
    }
}
