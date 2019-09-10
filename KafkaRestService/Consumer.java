package com.example.restservice.kafkarest;

import org.apache.kafka.common.protocol.types.Field;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class Consumer {
    private final Logger logger = LoggerFactory.getLogger(Consumer.class);
    String consumedMessage;

    @KafkaListener(topics = "sample", groupId = "group_id")
    public void consume(String message){
        logger.info(String.format("$$ -> Consumed Message -> %s",message));
        consumedMessage = message;
    }

    public String getMessageConsumed(){
        return consumedMessage;
    }
}
