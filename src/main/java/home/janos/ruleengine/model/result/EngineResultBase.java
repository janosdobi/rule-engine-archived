package home.janos.ruleengine.model.result;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.Set;

@Getter
@AllArgsConstructor
public abstract class EngineResultBase implements EngineResult {

    private long id;
    private LocalDateTime createdAt;
    private Set<RuleResult> ruleResults;
}
