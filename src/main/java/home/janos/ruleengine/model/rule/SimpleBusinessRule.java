package home.janos.ruleengine.model.rule;

import home.janos.ruleengine.model.entity.BusinessEntity;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.function.Predicate;

@EqualsAndHashCode(callSuper = true)
@Getter
public class SimpleBusinessRule extends BusinessRuleBase {

    @Builder
    public SimpleBusinessRule(final Predicate<BusinessEntity> predicate, final String invalidMessage) {
        super(predicate, invalidMessage);
    }
}
