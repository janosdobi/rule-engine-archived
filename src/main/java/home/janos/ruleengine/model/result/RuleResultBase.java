package home.janos.ruleengine.model.result;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public abstract class RuleResultBase implements RuleResult {

    private final boolean isValid;
    private final String validationMessage;
    private final LocalDateTime validatedAt;
}
