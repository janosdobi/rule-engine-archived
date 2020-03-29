package home.janos.ruleengine.service.consumer;

import home.janos.ruleengine.exception.ExecutionContextException;
import home.janos.ruleengine.model.context.ExecutionContext;
import home.janos.ruleengine.model.entity.BusinessEntity;
import home.janos.ruleengine.model.event.BusinessEvent;
import home.janos.ruleengine.service.handler.BusinessEventHandler;
import home.janos.ruleengine.util.BusinessContextUtil;
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

    //@KafkaListener(topics = {"${kafka.topic.business-event-input}"}, containerFactory = "mainKafkaListenerContainerFactory")
    public boolean listen(@Payload final ConsumerRecord<String, BusinessEvent> consumerRecord,
                       @Headers final MessageHeaders headers) {
        boolean res = false;
        BusinessEvent event = consumerRecord.value();

        try {
            final ExecutionContext context = BusinessContextUtil.getContextFromHeader(headers);
            if (businessEventHandler.handle(event, context)) {
                log.info(Constants.LogMessage.EVENT_HANDLED);
                res = true;
            }
        } catch (final ExecutionContextException ex) {
            log.error(Constants.LogMessage.EXECUTION_CONTEXT_ERROR);
        } catch (Exception e) {
            log.error(Constants.LogMessage.EVENT_FAIL, e);
        }

        return res;
    }
}
