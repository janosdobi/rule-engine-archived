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

        Set<String> applicableTypes = new HashSet<>();
        applicableTypes.add("type1");

        BusinessRule<SimpleBusinessEntity> rule1 = new SimpleBusinessRule<>(
                ExecutionType.TYPE_A,
                applicableTypes,
                simpleBusinessEntity -> simpleBusinessEntity.getValidatedDouble() > 500D,
                "Field must be greater than 500!");

        rules.add(rule1);

        BusinessRule<SimpleBusinessEntity> rule2 = new SimpleBusinessRule<>(
                ExecutionType.TYPE_A,
                applicableTypes,
                simpleBusinessEntity -> simpleBusinessEntity.getValidatedString().length() == 5,
                "String length must be 5!");

        rules.add(rule2);

        return rules;
    }
}
