package home.janos.ruleengine.model.rule;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode(callSuper = true)
@Getter
public class SimpleBusinessRule extends BusinessRuleBase {

    @Builder
    public SimpleBusinessRule() {
    }
}
