package home.janos.ruleengine.model.rule;

import home.janos.ruleengine.model.entity.BusinessEntity;

import java.util.function.Predicate;

public interface BusinessRule {

    Predicate<BusinessEntity> getPredicate();

    String getInvalidMessage();
}
