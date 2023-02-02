package com.kafka.object.producer.service;

import com.kafka.object.producer.utility.PureFunctions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

@Service
public class ObjectGeneratorProducer {

    private Logger log = LoggerFactory.getLogger(ObjectGeneratorProducer.class);

    @Value("${topic.name}")
    private String TOPIC_NAME;

    @Autowired
    private KafkaTemplate<String, Long> kafkaTemplate;

    /**
     * For Example, we are going to publish the random string to the topic
     * @param noOfObject
     */
    public void publishObjectToTopic(int noOfObject){
        log.info(String.format("Publishing %s of object to topic named: %s", noOfObject,TOPIC_NAME));

        try{
            // Let's create a stream of timestamp of the system

            Stream.generate(PureFunctions::getSystemTimeStamp)
                    .limit(noOfObject)
                    .forEach(timeStamp -> publish(timeStamp));

        }catch (Exception e){
            log.error("System error occurred");
        }
    }

    private void publish(Long object){
        log.info(String.format("Value which was published is %s", object));
        kafkaTemplate.send(TOPIC_NAME, object);
    }
}
