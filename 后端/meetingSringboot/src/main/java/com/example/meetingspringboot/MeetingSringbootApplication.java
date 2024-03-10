package com.example.meetingspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class MeetingSringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(MeetingSringbootApplication.class, args);
    }

}
