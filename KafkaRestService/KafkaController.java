package com.example.restservice.kafkarest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/kafka")
public class KafkaController {
    private final Producer producer;
    private final Consumer consumer;

    @Autowired
    public KafkaController(Producer producer, Consumer consumer){
        this.producer = producer;
        this.consumer = consumer;
    }

    @PostMapping(value = "/publish")
    public void sendMessageToKafkaTopic(@RequestParam("message") String message){
        this.producer.sendMessage(message);
    }

    @GetMapping(value = "/receive")
    public String getMessageFromConsumer(){
        return this.consumer.getMessageConsumed();
    }
}
