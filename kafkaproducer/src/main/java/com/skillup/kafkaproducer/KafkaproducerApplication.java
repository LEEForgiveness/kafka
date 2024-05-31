package com.skillup.kafkaproducer;

import com.skillup.kafkaproducer.dto.AlarmDto;
import java.util.Properties;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.jackson.JsonObjectSerializer;
import org.springframework.kafka.support.serializer.JsonSerializer;

@SpringBootApplication
public class KafkaproducerApplication {

	private static String TOPIC_NAME = "kafka-events";
	private static String BOOTSTRAP_SERVERS = "localhost:9092";
	private static int PARTITIONS_NUMBER = 1;

	public static void main(String[] args) {
		Properties configs = new Properties();

		configs.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, BOOTSTRAP_SERVERS);
		configs.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
		configs.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class.getName());

//		KafkaProducer<String, String> producer = new KafkaProducer<>(configs);
		KafkaProducer<String, AlarmDto> producer2 = new KafkaProducer<>(configs);
		// Send message to Kafka
//		for (int i = 0; i < 10; i++) {
//			ProducerRecord<String, String> record = new ProducerRecord<>(TOPIC_NAME, 0,
//				Integer.toString(i)
//				, "kafka-event " + i);
//			try {
//				producer.send(record);
//				System.out.println("Send to kafka: " + record.value());
//				Thread.sleep(1000);
//			} catch (Exception e) {
//				System.out.println(e);
//			}
//
//		}

		AlarmDto alarmDto = new AlarmDto("test", "test", "test");
		ProducerRecord<String, AlarmDto> record = new ProducerRecord<>(TOPIC_NAME, 0,
			"alarm"
			, alarmDto);
		try {
			producer2.send(record);
			System.out.println("Send to kafka: " + record.value());
		} catch (Exception e) {
			System.out.println(e);
		}

//		producer.flush();
//		producer.close();
//		SpringApplication.run(KafkaproducerApplication.class, args);

	}

}
