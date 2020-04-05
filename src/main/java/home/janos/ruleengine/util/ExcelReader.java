package home.janos.ruleengine.util;

import home.janos.ruleengine.model.rule.BusinessRule;

import java.util.Collection;
import java.util.HashSet;

public class ExcelReader {
    private ExcelReader() {
    }

    public static Collection<BusinessRule> readRulesFromExcel() {
        Collection<BusinessRule> businessRules = new HashSet<>();

        //TODO implement excel reading

        return businessRules;
    }
}
