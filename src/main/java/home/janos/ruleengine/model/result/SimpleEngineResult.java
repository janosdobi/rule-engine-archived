package home.janos.ruleengine.model.result;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Data
public class SimpleEngineResult extends EngineResultBase {

    @Builder
    public SimpleEngineResult(long id, LocalDateTime createdAt, Set<RuleResult> ruleResults) {
        super(id, createdAt, ruleResults);
    }
}
