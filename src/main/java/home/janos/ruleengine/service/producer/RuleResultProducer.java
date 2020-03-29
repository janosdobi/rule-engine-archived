package home.janos.ruleengine.service.producer;

import home.janos.ruleengine.model.result.RuleResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RuleResultProducer {

    private final KafkaTemplate<String, RuleResult> kafkaTemplate;

    @Value("${kafka.topic.business-event-output}")
    private String resultTopic;

    @Autowired
    public RuleResultProducer(KafkaTemplate<String, RuleResult> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public boolean produceResult(RuleResult ruleResult) {
        kafkaTemplate.send(resultTopic, ruleResult);
        return true;
    }
}
