package home.janos.ruleengine.model.rule;

import home.janos.ruleengine.model.context.ExecutionType;
import home.janos.ruleengine.model.entity.BusinessEntity;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * NOT thread-safe! Designed to be populated in a sequential manner on Spring app startup.
 */
public final class RuleContainer {

    private static final RuleContainer SI = new RuleContainer();

    //For the purpose of POC, a simple map is ok as an underlying data structure, more complex implementations can follow.
    private static final Map<ExecutionType, Set<BusinessRule<BusinessEntity>>> ruleMap = new HashMap<>();

    private RuleContainer() {
    }

    public static RuleContainer getInstance() {
        return SI;
    }

    public void addRule(final ExecutionType executionType, final BusinessRule<BusinessEntity> rule) {

        if (!ruleMap.containsKey(executionType)) {
            final Set<BusinessRule<BusinessEntity>> rules = new HashSet<>();
            rules.add(rule);
            ruleMap.put(executionType, rules);
        } else {
            final Set<BusinessRule<BusinessEntity>> rules = ruleMap.get(executionType);
            rules.add(rule);
        }
    }

    public Set<BusinessRule<BusinessEntity>> getRulesForType(final ExecutionType executionType) {
        return ruleMap.get(executionType);
    }
}
