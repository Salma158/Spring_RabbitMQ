package com.rabbitMQ.accounts.functions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.function.Consumer;

@Configuration
public class UsersFunctions {

    public static final Logger log = LoggerFactory.getLogger(UsersFunctions.class);

    @Bean
    public Consumer<Long> updateAccount(){
        return id -> {
            log.info("activating user account with id : {}", id.toString());
        };
    }
}
