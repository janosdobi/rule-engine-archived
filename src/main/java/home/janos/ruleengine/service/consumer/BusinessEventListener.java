package home.janos.ruleengine.service.consumer;

import home.janos.ruleengine.model.entity.BusinessEntity;
import home.janos.ruleengine.model.event.BusinessEvent;
import home.janos.ruleengine.service.handler.BusinessEventHandler;
import home.janos.ruleengine.util.Constants;
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

    /*@KafkaListener(topics = {"${kafka.topic.business-event-input}"}, containerFactory = "mainKafkaListenerContainerFactory")
    public void listen(@Payload final ConsumerRecord<String, BusinessEvent<? extends BusinessEntity>> consumerRecord,
                       @Headers final MessageHeaders headers) {
        BusinessEvent<BusinessEntity> event = (BusinessEvent<BusinessEntity>) consumerRecord.value();

        try {
            if (businessEventHandler.handle(event)) {
                log.info(Constants.LogMessage.EVENT_HANDLED);
            }
        } catch (Exception e) {
            log.error(Constants.LogMessage.EVENT_FAIL, e);
        }
    }*/
}
