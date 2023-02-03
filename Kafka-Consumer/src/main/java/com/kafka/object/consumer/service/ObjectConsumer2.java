package com.kafka.object.consumer.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ObjectConsumer2 {

    @Value("${topic.name}")
    private String TOPIC_NAME;

    private Logger log = LoggerFactory.getLogger(ObjectConsumer.class);

    @KafkaListener(topics = "${topic.name}", groupId = "group2")
    public void consume(Long object){
        log.info(String.format("2.Value received -> %s from the Topic named: %s", object, TOPIC_NAME));
    }
}
