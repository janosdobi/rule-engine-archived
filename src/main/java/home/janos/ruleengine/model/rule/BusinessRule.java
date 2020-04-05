package home.janos.ruleengine.model.rule;

import home.janos.ruleengine.model.context.ExecutionType;
import home.janos.ruleengine.model.entity.BusinessEntity;

import java.util.Set;
import java.util.function.Predicate;

public interface BusinessRule<E extends BusinessEntity> {

    Set<Predicate<E>> getPredicates();

    String getInvalidMessage();

    ExecutionType getExecutionType();
}
