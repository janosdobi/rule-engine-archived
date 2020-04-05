package home.janos.ruleengine.model.rule;

import home.janos.ruleengine.model.context.ExecutionType;
import home.janos.ruleengine.model.entity.BusinessEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;
import java.util.function.Predicate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class BusinessRuleBase<E extends BusinessEntity> implements BusinessRule<E> {

    private ExecutionType executionType; // etc. further fields might be added which can provide basis for rule-clusters
    private Set<String> applicableForType;
    private Predicate<E> predicate;
    private String invalidMessage;
}
