package com.shipping.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.order.entities.Order;

@Service
public class ConsumerService {
	@KafkaListener(topics = "my_topic", groupId = "my_topic_group_id")
	public void consume(Order order) {
		System.out.println("------###############------------");
		System.out.println(order);
	}
}