package home.janos.ruleengine.service.mapper;

import home.janos.ruleengine.model.context.ExecutionContext;
import home.janos.ruleengine.model.entity.BusinessEntity;
import home.janos.ruleengine.model.rule.BusinessRule;
import home.janos.ruleengine.util.ExcelReader;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
public class SimpleRuleMapper implements RuleMapper {

    private static final Set<BusinessRule> BUSINESS_RULES = new HashSet<>();

    static {
        init();
    }

    private static void init() {
        BUSINESS_RULES.addAll(ExcelReader.readRulesFromExcel());
    }

    @Override
    public Set<BusinessRule> getApplicableRules(final Collection<BusinessEntity> entities, final ExecutionContext context) {
        //TODO implement mapping logic
        return BUSINESS_RULES;
    }
}
