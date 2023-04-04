package com.kafka.service;

import com.kafka.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class KafKaConsumerService 
{
	private final Logger logger = LoggerFactory.getLogger(KafKaConsumerService.class);

	private List<String> mensajes = new ArrayList<>();
	private List<User> usuarios = new ArrayList<>();
	
	@KafkaListener(topics = "${general.topic.name}", groupId = "${general.topic.group.id}")
	public void consume(String message) {
		logger.info(String.format("Message recieved -> %s", message));
		mensajes.add(message);
	}

	@KafkaListener(topics = "${user.topic.name}", groupId = "${user.topic.group.id}")
	public void consume(User user) {
		logger.info(String.format("User created -> %s", user));
		usuarios.add(user);
	}

	public List<String> getMensajes(){
		return mensajes;
	}

	public List<User> getUsuarios(){
		return usuarios;
	}
}
