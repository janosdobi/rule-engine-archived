package home.janos.ruleengine.service.rule.provider;

import home.janos.ruleengine.model.context.ExecutionType;
import home.janos.ruleengine.model.entity.SimpleBusinessEntity;
import home.janos.ruleengine.model.rule.BusinessRule;
import home.janos.ruleengine.model.rule.SimpleBusinessRule;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class InMemoryRuleProvider implements RuleProvider {

    @Override
    @SuppressWarnings("rawtypes")
    public Set<BusinessRule> getRules() {
        Set<BusinessRule> rules = new HashSet<>();

        BusinessRule<SimpleBusinessEntity> ruleExample = new SimpleBusinessRule<>(
                ExecutionType.TYPE_A,
                simpleBusinessEntity -> simpleBusinessEntity.getValidatedDouble() > 500,
                "Field must be greater than 500!");

        rules.add(ruleExample);

        return rules;
    }
}
