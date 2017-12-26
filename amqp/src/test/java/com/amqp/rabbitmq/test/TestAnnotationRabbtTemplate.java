package com.amqp.rabbitmq.test;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.amqp.rabbitmq.config.RabbitMQConfig;

public class TestAnnotationRabbtTemplate {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
				RabbitMQConfig.class);
		RabbitTemplate rabbitTemplate = context.getBean(RabbitTemplate.class);
		int i = 1;
		synchronized (rabbitTemplate) {

			while (true) {

				String str = "hello :" + i;
				// 需要指定exchange和routingKey
				rabbitTemplate.send("topicExchange", "spitter.yuan",
						new Message(str.getBytes(), new MessageProperties()));
				i++;
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
