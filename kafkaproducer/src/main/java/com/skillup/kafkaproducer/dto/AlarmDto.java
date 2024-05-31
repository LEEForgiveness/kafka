package com.skillup.kafkaproducer.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AlarmDto {

	private String receiverUuid;
	private String message;
	private String eventType;
}
