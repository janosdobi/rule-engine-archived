package home.janos.ruleengine.model.result;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Getter
public class SimpleRuleResult extends RuleResultBase {

    @Builder
    public SimpleRuleResult(boolean isValid, String validationMessage, LocalDateTime validatedAt) {
        super(isValid, validationMessage, validatedAt);
    }
}
