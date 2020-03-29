package home.janos.ruleengine.util;

import home.janos.ruleengine.model.rule.BusinessRule;
import home.janos.ruleengine.model.rule.SimpleBusinessRule;

import java.util.Collection;
import java.util.HashSet;

public class ExcelReader {
    private ExcelReader(){}

    public static Collection<BusinessRule> readRulesFromExcel() {
        Collection<BusinessRule> businessRules = new HashSet<>();

        //TODO implement excel reading
        businessRules.add(SimpleBusinessRule.builder()
                .invalidMessage("Entity invalid!")
                .predicate(businessEntity -> false)
                .build());

        return businessRules;
    }
}
