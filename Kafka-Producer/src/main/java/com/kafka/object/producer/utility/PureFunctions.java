package com.kafka.object.producer.utility;

import org.springframework.stereotype.Component;

@Component
public class PureFunctions {

    public static Long getSystemTimeStamp(){
        return System.currentTimeMillis();
    }

}
