package home.janos.ruleengine.model.rule;

import home.janos.ruleengine.model.context.ExecutionType;
import home.janos.ruleengine.model.entity.BusinessEntity;

import java.util.function.Predicate;

public interface BusinessRule<E extends BusinessEntity> {

    Predicate<E> getPredicate();

    String getInvalidMessage();

    ExecutionType getExecutionType();
}
