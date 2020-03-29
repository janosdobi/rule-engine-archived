package home.janos.ruleengine.model.rule;

import home.janos.ruleengine.model.entity.BusinessEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.function.Predicate;

@Getter
@AllArgsConstructor
public abstract class BusinessRuleBase implements BusinessRule {

    private final Predicate<BusinessEntity> predicate;
    private final String invalidMessage;
}
