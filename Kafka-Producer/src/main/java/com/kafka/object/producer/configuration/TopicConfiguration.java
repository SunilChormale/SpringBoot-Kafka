package com.kafka.object.producer.configuration;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class TopicConfiguration {

    @Value("${topic.name}")
    private String TOPIC_NAME;

    @Bean
    public NewTopic createNewTopic(){
        return TopicBuilder.name(TOPIC_NAME)
                .build();
    }

}
