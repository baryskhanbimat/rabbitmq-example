package com.example.rabbitmqapp.controller;

import com.example.rabbitmqapp.RabbitmqAppApplication;
import com.example.rabbitmqapp.service.ProducerService;
import org.apache.log4j.Logger;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.TimeUnit;

@RestController
public class SampleController {
    @Autowired
    private ProducerService producerService;

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST, value = "/send/{message}")
    public ResponseEntity send(@PathVariable String message) throws InterruptedException {
        producerService.send(message);
        return ResponseEntity.ok().build();
    }


}
