package home.janos.ruleengine.service.rule.mapper;

import home.janos.ruleengine.model.context.ExecutionContext;
import home.janos.ruleengine.model.entity.BusinessEntity;
import home.janos.ruleengine.model.rule.BusinessRule;

import java.util.Collection;
import java.util.Set;

public interface RuleMapper {
    Set<BusinessRule> getApplicableRules(final Collection<BusinessEntity> entities, final ExecutionContext context);
}
