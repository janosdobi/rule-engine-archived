package home.janos.ruleengine.service.rule.applicator;

import home.janos.ruleengine.model.entity.BusinessEntity;
import home.janos.ruleengine.model.result.EngineResult;
import home.janos.ruleengine.model.rule.BusinessRule;

import java.util.Set;

public interface RuleApplicator {

    EngineResult applyRules(final Set<BusinessRule<BusinessEntity>> rules, final BusinessEntity entity);
}
