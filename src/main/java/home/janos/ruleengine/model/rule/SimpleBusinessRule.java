package home.janos.ruleengine.model.rule;

import home.janos.ruleengine.model.context.ExecutionType;
import home.janos.ruleengine.model.entity.BusinessEntity;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.function.Predicate;

@EqualsAndHashCode(callSuper = true)
@Getter
public class SimpleBusinessRule<E extends BusinessEntity> extends BusinessRuleBase<E> {

    public SimpleBusinessRule(ExecutionType executionType, Predicate<E> predicate, String invalidMessage) {
        super(executionType, predicate, invalidMessage);
    }
}
