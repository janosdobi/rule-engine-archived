package home.janos.ruleengine.service.rule.mapper;

import home.janos.ruleengine.model.context.ExecutionContext;
import home.janos.ruleengine.model.entity.BusinessEntity;
import home.janos.ruleengine.model.rule.BusinessRule;
import home.janos.ruleengine.model.rule.RuleContainer;
import home.janos.ruleengine.service.rule.provider.RuleProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
public class SimpleRuleMapper implements RuleMapper {

    private final RuleContainer businessRules = RuleContainer.getInstance();
    private final RuleProvider ruleProvider;

    @Autowired
    public SimpleRuleMapper(final RuleProvider ruleProvider) {
        this.ruleProvider = ruleProvider;
        initRules();
    }

    @Override
    public Set<BusinessRule> getApplicableRules(final Collection<BusinessEntity> entities, final ExecutionContext context) {
        //TODO implement mapping logic
        Set<BusinessRule> ruleSet = new HashSet<>();

        ruleSet.addAll(businessRules.getRulesForType(context.getExecutionType()));

        return ruleSet;
    }

    private void initRules() {
        for (final BusinessRule rule : ruleProvider.getRules()) {
            businessRules.addRule(rule.getExecutionType(), rule);
        }
    }
}
