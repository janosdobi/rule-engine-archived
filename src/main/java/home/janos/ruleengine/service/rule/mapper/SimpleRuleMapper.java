package home.janos.ruleengine.service.rule.mapper;

import home.janos.ruleengine.model.context.ExecutionContext;
import home.janos.ruleengine.model.entity.BusinessEntity;
import home.janos.ruleengine.model.entity.SimpleBusinessEntity;
import home.janos.ruleengine.model.rule.BusinessRule;
import home.janos.ruleengine.model.rule.RuleContainer;
import home.janos.ruleengine.service.rule.provider.RuleProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

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
    public Set<BusinessRule<BusinessEntity>> getApplicableRules(final Collection<BusinessEntity> entities, final ExecutionContext context) {
        Set<BusinessRule<BusinessEntity>> ruleSet = new HashSet<>();

        //TODO until complex cases are implemented
        final SimpleBusinessEntity entity = entities.iterator().hasNext() ? (SimpleBusinessEntity) entities.iterator().next() : null;

        ruleSet.addAll(businessRules.getRulesForType(context.getExecutionType()));

        //complexity can be added here by retrieving from RuleContainer based on more sophisticated logic. E.g.:
        return ruleSet.stream()
                .filter(rule -> rule.getApplicableForType().contains(entity.getEntityType()))
                .collect(Collectors.toSet());
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    private void initRules() {
        for (final BusinessRule rule : ruleProvider.getRules()) {
            businessRules.addRule(rule.getExecutionType(), rule);
        }
    }
}
