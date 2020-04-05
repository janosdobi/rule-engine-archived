package home.janos.ruleengine.model.result;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class EngineResultBase implements EngineResult {

    private long id;
    private LocalDateTime createdAt;
    private Set<RuleResult> ruleResults;
}
