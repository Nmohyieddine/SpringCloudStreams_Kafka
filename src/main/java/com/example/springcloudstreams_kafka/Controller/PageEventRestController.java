package com.example.springcloudstreams_kafka.Controller;

import com.example.springcloudstreams_kafka.Entity.PageEvent;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class PageEventRestController {

    StreamBridge streamBridge;

    public PageEventRestController(StreamBridge streamBridge) {
        this.streamBridge = streamBridge;
    }

    @GetMapping(path = "/publish/{topic}/{name}")
    public PageEvent publish(@PathVariable(name = "topic") String topic,@PathVariable(name = "name") String name){

        PageEvent pageEvent=new PageEvent(name,new Date(System.currentTimeMillis()),Math.random());

        streamBridge.send(topic,pageEvent);



        return pageEvent;

    }
}
