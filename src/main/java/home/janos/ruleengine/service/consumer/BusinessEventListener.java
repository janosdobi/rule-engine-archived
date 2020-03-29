package home.janos.ruleengine.service.consumer;

import home.janos.ruleengine.model.event.BusinessEvent;
import home.janos.ruleengine.service.handler.BusinessEventHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class BusinessEventListener {

    private final BusinessEventHandler businessEventHandler;

    @Autowired
    public BusinessEventListener(BusinessEventHandler businessEventHandler) {
        this.businessEventHandler = businessEventHandler;
    }

/*    @KafkaListener(topics = {"${kafka.topic.business-event-input}"}, containerFactory = "mainKafkaListenerContainerFactory")
    public void listen(@Payload final ConsumerRecord<String, BusinessEvent> consumerRecord, @Headers final MessageHeaders headers) {
        businessEventHandler.handle(consumerRecord.value());
    }*/
}
