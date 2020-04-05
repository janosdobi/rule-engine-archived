package home.janos.ruleengine.model.result;

import lombok.*;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class RuleResultBase implements RuleResult {

    private boolean isValid;
    private String validationMessage;
    private LocalDateTime validatedAt;

}
