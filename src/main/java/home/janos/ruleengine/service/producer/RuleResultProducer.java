package home.janos.ruleengine.service.producer;

import home.janos.ruleengine.model.result.EngineResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RuleResultProducer {

    private final KafkaTemplate<String, EngineResult> kafkaTemplate;

    @Value("${kafka.topic.business-event-output}")
    private String resultTopic;

    @Autowired
    public RuleResultProducer(KafkaTemplate<String, EngineResult> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public boolean produceResult(EngineResult engineResult) {
        kafkaTemplate.send(resultTopic, engineResult);
        return true;
    }
}
