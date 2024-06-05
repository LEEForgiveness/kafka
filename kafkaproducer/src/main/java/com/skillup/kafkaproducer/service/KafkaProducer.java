package com.skillup.kafkaproducer.service;

import com.skillup.kafkaproducer.dto.AlarmDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {
	private static final String TOPIC = "kafka-json-test";
	private final KafkaTemplate<String, AlarmDto> kafkaTemplate;

	@Autowired
	public KafkaProducer(KafkaTemplate<String, AlarmDto> kafkaTemplate) {
		this.kafkaTemplate = kafkaTemplate;
	}

	public void sendMessage(AlarmDto alarmDto) {
		System.out.println(String.format("Producing message -> %s", alarmDto));
		kafkaTemplate.send(TOPIC, alarmDto);
	}
}
