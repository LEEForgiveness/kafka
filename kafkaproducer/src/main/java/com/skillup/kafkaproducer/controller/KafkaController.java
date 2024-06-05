package com.skillup.kafkaproducer.controller;

import com.skillup.kafkaproducer.dto.AlarmDto;
import com.skillup.kafkaproducer.service.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafka")
public class KafkaController {
	private final KafkaProducer producer;

	@Autowired
	KafkaController(KafkaProducer producer) {
		this.producer = producer;
	}

	@PostMapping
	public String sendMessage(@RequestBody AlarmDto message) {
		this.producer.sendMessage(message);
		return "Message sent to the Kafka Topic Successfully";
	}
}
