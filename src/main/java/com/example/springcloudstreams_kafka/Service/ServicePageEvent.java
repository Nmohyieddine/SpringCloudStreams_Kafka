package com.example.springcloudstreams_kafka.Service;

import com.example.springcloudstreams_kafka.Entity.PageEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

@Service
public class ServicePageEvent {

    @Bean
    public Consumer<PageEvent> pageEventConsumer(){
        return (input) ->{

            System.out.println(input.name);

        };
    }

    @Bean
    public Supplier<PageEvent> pageEventSupplier(){

        return ()-> new PageEvent(Math.random()>0.5?"U1":"U2",new Date(System.currentTimeMillis()),Math.random());

    }

    @Bean
    public Function<PageEvent,PageEvent> pageEventFunction(){

        return (input)-> new PageEvent("PageFunction",input.getDateVisiting(),input.getNumberVisiting());
    }
}
