package com.example.rabbitmqapp.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@EnableRabbit
@Slf4j
public class SampleService {

    @RabbitListener(bindings = @QueueBinding(key = "kzntf.v2", value = @Queue(name = "inbound-queue"), exchange = @Exchange(name = "mss.direct.outgoing")))
    public void receive(Message message){
        log.info("Listener received message; {}", message.toString());
    }
}
