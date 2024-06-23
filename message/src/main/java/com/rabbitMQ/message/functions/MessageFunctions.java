package com.rabbitMQ.message.functions;
import com.rabbitMQ.message.dto.MessageDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import java.util.function.Function;

@Configuration
public class MessageFunctions {

    public static final Logger log = LoggerFactory.getLogger(MessageFunctions.class);

    public Function<MessageDto, MessageDto> email(){
        return MessageDto -> {
            log.info("sending email with details : {}", MessageDto.toString());
            return MessageDto;
        };
    }

    public Function<MessageDto, Long> sms(){
        return MessageDto -> {
            log.info("sending sms with details : {}", MessageDto.toString());
            return MessageDto.id();
        };
    }
}
