package home.janos.ruleengine.model.result;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public abstract class RuleResultBase implements RuleResult {

    private boolean isValid;
    private String validationMessage;
    private LocalDateTime validatedAt;

}
