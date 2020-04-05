package home.janos.ruleengine.model.result;

import lombok.*;

import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Data
public class SimpleRuleResult extends RuleResultBase {

    @Builder
    public SimpleRuleResult(boolean isValid, String validationMessage, LocalDateTime validatedAt) {
        super(isValid, validationMessage, validatedAt);
    }
}



