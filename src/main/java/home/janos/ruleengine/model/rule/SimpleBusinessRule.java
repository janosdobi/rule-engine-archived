package home.janos.ruleengine.model.rule;

import home.janos.ruleengine.model.context.ExecutionType;
import home.janos.ruleengine.model.entity.BusinessEntity;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Set;
import java.util.function.Predicate;

@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Data
public class SimpleBusinessRule<E extends BusinessEntity> extends BusinessRuleBase<E> {

    @Builder
    public SimpleBusinessRule(ExecutionType executionType, Set<String> applicableForType, Predicate<E> predicate, String invalidMessage) {
        super(executionType, applicableForType, predicate, invalidMessage);
    }
}
