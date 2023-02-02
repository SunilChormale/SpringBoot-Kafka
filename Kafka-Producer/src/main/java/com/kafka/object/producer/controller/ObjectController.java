package com.kafka.object.producer.controller;

import com.kafka.object.producer.service.ObjectGeneratorProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/publisher/v1")
public class ObjectController {

    @Autowired
    private ObjectGeneratorProducer objectGeneratorProducer;

    @GetMapping("/produce/{noOfObject}")
    public String publishEventsToTopic(@PathVariable("noOfObject") int noOfObject){
        objectGeneratorProducer.publishObjectToTopic(noOfObject);
        return String.format("%s events sent to the Topic",noOfObject);
    }
}
