package com.rabbitMQ.publisher.controller;

import com.rabbitMQ.publisher.dto.MessageDto;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class MessageContoller {

    public static final Logger log = LoggerFactory.getLogger(MessageContoller.class);
    private final StreamBridge streamBridge;

    @PostMapping
    public void sendMessage(MessageDto message){
        log.info("sending communication request for the details : {}", message);
        var result = streamBridge.send("sendCommunication-out-0", message);
        log.info("is the communcation request successfully processed ? : {}", result);
    }
}
