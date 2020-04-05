package home.janos.ruleengine.service.rule.applicator;

import home.janos.ruleengine.model.entity.BusinessEntity;
import home.janos.ruleengine.model.result.EngineResult;
import home.janos.ruleengine.model.result.RuleResult;
import home.janos.ruleengine.model.result.SimpleEngineResult;
import home.janos.ruleengine.model.result.SimpleRuleResult;
import home.janos.ruleengine.model.rule.BusinessRule;
import home.janos.ruleengine.util.Constants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Predicate;

@Service
@Slf4j
public class RuleApplicatorService implements RuleApplicator {

    @Override
    public EngineResult applyRules(final Set<BusinessRule<BusinessEntity>> rules, final BusinessEntity entity) {
        final Set<RuleResult> ruleResults = new HashSet<>();

        log.info(Constants.LogMessage.APPLYING_RULES, entity);
        for (final BusinessRule<BusinessEntity> rule: rules) {
            log.debug(Constants.LogMessage.APPLYING_RULE, rule);
            final Predicate<BusinessEntity> predicate = rule.getPredicate();

            boolean isValid = predicate.test(entity);

            final RuleResult ruleResult = SimpleRuleResult.builder()
                    .isValid(isValid)
                    .build();

            if (!isValid) {
                ruleResult.setValidationMessage(rule.getInvalidMessage());
            }

            log.debug(Constants.LogMessage.RULE_RESULT, ruleResult);

            ruleResults.add(ruleResult);
        }

        final EngineResult engineResult = SimpleEngineResult.builder()
                .createdAt(LocalDateTime.now())
                .ruleResults(ruleResults)
                .build();

        log.info(Constants.LogMessage.ENGINE_RESULT, engineResult);

        return engineResult;
    }
}
