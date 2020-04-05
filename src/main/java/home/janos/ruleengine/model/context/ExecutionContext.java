package home.janos.ruleengine.model.context;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ExecutionContext {

    private final String userId;
    private final String contextIdentifier;
    private ExecutionType executionType;
}
