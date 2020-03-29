package home.janos.ruleengine.model.result;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
public class SimpleEngineResult extends EngineResultBase {

    @Builder
    public SimpleEngineResult(long id, LocalDateTime createdAt, Set<RuleResult> ruleResults) {
        super(id, createdAt, ruleResults);
    }
}
