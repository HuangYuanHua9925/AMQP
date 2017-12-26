package com.amqp.rabbitmq.config;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

public class MyMessageListener implements MessageListener {

	@Override
	public void onMessage(Message message) {

		System.out.println(new String(message.getBody()));

	}

	@RabbitListener
	public void show() {
		System.out.println(1);
	}

}
