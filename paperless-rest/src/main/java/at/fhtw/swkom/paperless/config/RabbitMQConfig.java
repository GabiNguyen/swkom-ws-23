package at.fhtw.swkom.paperless.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    public static final String EXCHANGE = "";

    public static final String OCR_IN_QUEUE_NAME = "OCR_In";
    public static final String OCR_OUT_QUEUE_NAME = "OCR_Out";
    public static final String DOCUMENT_STORAGE_PATH_PROPERTY_NAME = "FileStoragePath";


    @Value("${rabbitmq.queue.name}")
    private String queue;

    @Value("${rabbitmq.exchange.name}")
    private String exchange;

    @Value("${rabbitmq.routing.key.name}")
    private String routing_key;

    @Bean
    public Queue queue() {
        return new Queue(queue);
    }

    @Bean
    public TopicExchange exchange() {
        return new TopicExchange(exchange);
    }

    @Bean
    public Binding binding(){
        return BindingBuilder.bind(queue()).to(exchange()).with(routing_key);
    }

    @Bean
    public Queue ocrInQueue() {
        return new Queue(OCR_IN_QUEUE_NAME, false);
    }

    @Bean
    public Queue ocrOutQueue() { return new Queue(OCR_OUT_QUEUE_NAME, false); }

    @Bean
    public ConnectionFactory connectionFactory() {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory("localhost");
        connectionFactory.setUsername("guest");
        connectionFactory.setPassword("guest");
        return connectionFactory;
    }

    @Bean
    public RabbitTemplate rabbitTemplate() {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory());
        rabbitTemplate.setDefaultReceiveQueue(OCR_IN_QUEUE_NAME);
        return rabbitTemplate;
    }

    // Custom error handling with Spring AMQP
    // see <a href="https://www.baeldung.com/spring-amqp-error-handling">Error Handling with Spring AMQP</a>
    // Necessary to avoid requeuing of messages with JSON-parse exceptions
    @Bean
    public SimpleRabbitListenerContainerFactory rabbitListenerContainerFactory(
            ConnectionFactory connectionFactory,
            SimpleRabbitListenerContainerFactoryConfigurer configurer) {
        SimpleRabbitListenerContainerFactory factory =
                new SimpleRabbitListenerContainerFactory();
        configurer.configure(factory, connectionFactory);
        factory.setErrorHandler(errorHandler());
        return factory;
    }

    @Bean
    public ErrorHandler errorHandler() {
        return new ServicesErrorHandler();
}
