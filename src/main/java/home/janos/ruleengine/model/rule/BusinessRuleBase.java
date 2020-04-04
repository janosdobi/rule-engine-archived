package home.janos.ruleengine.model.rule;

import home.janos.ruleengine.model.context.ExecutionType;
import home.janos.ruleengine.model.entity.BusinessEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.function.Predicate;

@Getter
@AllArgsConstructor
public abstract class BusinessRuleBase<E extends BusinessEntity> implements BusinessRule<E> {

    private final ExecutionType executionType; // etc. further fields might be added which can provide basis for rule-clusters
    private final Predicate<E> predicate;
    private final String invalidMessage;
}
