package com.example.rabbitmqapp.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProducerService {

    @Autowired
    private RabbitTemplate rabbitTemplate;


    public void send(String message) throws InterruptedException {
        for (int i=0; i<10; i++){
            rabbitTemplate.convertAndSend("mss.direct.outgoing", "kzntf.v2", message + i);
            Thread.sleep(2000);
        }



    }
}
