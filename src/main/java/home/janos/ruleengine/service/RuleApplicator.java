package home.janos.ruleengine.service;

import home.janos.ruleengine.model.entity.BusinessEntity;
import home.janos.ruleengine.model.result.RuleResult;
import home.janos.ruleengine.model.rule.BusinessRule;

import java.util.Set;

public interface RuleApplicator {

    RuleResult applyRules(final Set<BusinessRule> rules, final BusinessEntity entity);
}
