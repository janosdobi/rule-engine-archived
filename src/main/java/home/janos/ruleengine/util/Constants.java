package home.janos.ruleengine.util;

public class Constants {
    public static final String USER_ID = "userid";
    public static final String CONTEXT_IDENTIFIER = "contextidentifier";

    private Constants() { }

    public static final class LogMessage {
        public static final String EXECUTION_CONTEXT_ERROR = "Error during building execution context.";

        private LogMessage(){}

        public static final String EVENT_FAIL = "Event handling failed.";
        public static final String EVENT_HANDLED = "Event successfully handled.";
        public static final String RESULT_PRODUCE_FAIL = "Producing result entity failed.";
        public static final String RESULT_PRODUCE_SUCCESSFUL = "Producing result entity successful.";
        public static final String APPLYING_RULES = "Applying rule set to entity: {}";
        public static final String APPLYING_RULE = "Applying rule: {}";
        public static final String RULE_RESULT = "Rule result received: {}";
        public static final String ENGINE_RESULT = "Engine result received: {}";
        public static final String RULE_APPLICATION_FAIL = "Application of rules failed.";
    }
}
