package com.example.springcloudstreams_kafka.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data @NoArgsConstructor @AllArgsConstructor
public class PageEvent {

    public String name;
    public Date dateVisiting;
    public double numberVisiting;

}