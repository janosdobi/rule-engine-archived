package home.janos.ruleengine.model.result;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
public class SimpleRuleResult extends RuleResultBase {

    @Builder
    public SimpleRuleResult(boolean isValid, String validationMessage, LocalDateTime validatedAt) {
        super(isValid, validationMessage, validatedAt);
    }
}
