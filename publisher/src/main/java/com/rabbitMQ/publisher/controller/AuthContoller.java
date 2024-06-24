package com.rabbitMQ.publisher.controller;
import com.rabbitMQ.publisher.dto.UserDto;
import com.rabbitMQ.publisher.dto.MessageDto;
import lombok.AllArgsConstructor;
import org.apache.logging.log4j.message.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class AuthContoller {

    public static final Logger log = LoggerFactory.getLogger(AuthContoller.class);
    private final StreamBridge streamBridge;

    @PostMapping("/register")
    public void register(@RequestBody UserDto userDetails){
        log.info("Logic for creating user account ... : {}", userDetails);
        MessageDto msgDto = new MessageDto(userDetails.id(), userDetails.name(), userDetails.email());
        log.info("sending communication request for the details : {}", msgDto);
        var result = streamBridge.send("sendCommunication-out-0", msgDto);
        log.info("is the communcation request successfully triggered ? : {}", result);
    }
}
