package at.fhtw.swkom.paperless.services;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQService {
    private final AmqpTemplate amqpTemplate;

    @Autowired
    public RabbitMQService(AmqpTemplate amqpTemplate) {
        this.amqpTemplate = amqpTemplate;
    }

    @Value("${rabbitmq.exchange.name}")
    private String exchange;

    @Value("${rabbitmq.routing.key.name}")
    private String routingKey;

    public void sendMessage(Integer message) {
        amqpTemplate.convertAndSend(exchange, routingKey, Integer.toString(message));
        System.out.println("Message sent: " + message);
    }
}
