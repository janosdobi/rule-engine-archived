package home.janos.ruleengine.service.rule.provider;

import home.janos.ruleengine.model.rule.BusinessRule;

import java.util.Set;

public interface RuleProvider {

    Set<BusinessRule> getRules();
}
