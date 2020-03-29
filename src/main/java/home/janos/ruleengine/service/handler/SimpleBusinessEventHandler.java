package home.janos.ruleengine.service.handler;

import home.janos.ruleengine.model.context.ExecutionContext;
import home.janos.ruleengine.model.entity.BusinessEntity;
import home.janos.ruleengine.model.event.BusinessEvent;
import home.janos.ruleengine.model.result.EngineResult;
import home.janos.ruleengine.model.rule.BusinessRule;
import home.janos.ruleengine.service.RuleApplicator;
import home.janos.ruleengine.service.mapper.RuleMapper;
import home.janos.ruleengine.service.producer.RuleResultProducer;
import home.janos.ruleengine.util.Constants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.Set;

@Service
@Slf4j
public class SimpleBusinessEventHandler implements BusinessEventHandler {

    private final RuleApplicator ruleApplicator;
    private final RuleMapper ruleMapper;
    private final RuleResultProducer ruleResultProducer;

    @Autowired
    public SimpleBusinessEventHandler(final RuleApplicator ruleApplicator, final RuleResultProducer ruleResultProducer,
                                      final RuleMapper ruleMapper) {
        this.ruleApplicator = ruleApplicator;
        this.ruleResultProducer = ruleResultProducer;
        this.ruleMapper = ruleMapper;
    }

    @Override
    public boolean handle(BusinessEvent event, final ExecutionContext context) {
        final BusinessEntity businessEntity = event.getEntity();

        //TODO for now. complex validation cases to be implemented - with multiple entities
        Collection<BusinessEntity> entities = Collections.singletonList(businessEntity);

        final Set<BusinessRule> rulesToBeApplied = ruleMapper.getApplicableRules(entities, context);

        EngineResult result = null;

        try {
            result = ruleApplicator.applyRules(rulesToBeApplied, businessEntity);
        } catch (final Exception e) {
            log.error(Constants.LogMessage.RULE_APPLICATION_FAIL, e);
        }

        /*if (result!= null) {
            try {
                ruleResultProducer.produceResult(result);
                log.info(Constants.LogMessage.RESULT_PRODUCE_SUCCESSFUL);
            } catch (final Exception e) {
                log.error(Constants.LogMessage.RESULT_PRODUCE_FAIL);
            }
        }*/

        return true;
    }
}
