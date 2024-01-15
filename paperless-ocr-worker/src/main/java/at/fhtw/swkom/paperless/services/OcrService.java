package at.fhtw.swkom.paperless.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import net.sourceforge.tess4j.TesseractException;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

public interface OcrService {

    @RabbitListener(queues = "${rabbitmq.queue.name}")
    void processMessage(String message) throws JsonProcessingException, TesseractException;
}
