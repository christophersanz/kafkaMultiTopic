package com.kafka.controller;

import com.kafka.model.User;
import com.kafka.service.KafKaConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/kafka")
public class KafkaConsumerController {
    private final KafKaConsumerService kafKaConsumerService;

    @Autowired
    public KafkaConsumerController(KafKaConsumerService kafKaConsumerService) {
        this.kafKaConsumerService = kafKaConsumerService;
    }

    @GetMapping(value = "/messages")
    List<String> getMensajes(){
        return this.kafKaConsumerService.getMensajes();
    }

    @GetMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
    List<User> getUsuarios(){
        return this.kafKaConsumerService.getUsuarios();
    }

}
