package home.janos.ruleengine.util;

import home.janos.ruleengine.exception.ExecutionContextException;
import home.janos.ruleengine.model.context.ExecutionContext;
import org.springframework.messaging.MessageHeaders;

import java.util.Map;

public class BusinessContextUtil {
    private BusinessContextUtil() {}

    public static ExecutionContext getContextFromHeader(final MessageHeaders headers) throws ExecutionContextException {
        ExecutionContext context;

        try {
            context = ExecutionContext.builder()
                    .userId((String) headers.get(Constants.USER_ID))
                    .contextIdentifier((String) headers.get(Constants.CONTEXT_IDENTIFIER))
                    .build();
        } catch (final Exception e) {
            throw new ExecutionContextException(e);
        }

        return context;
    }

    public static ExecutionContext getContextFromHeader(final Map<String, String> headers) throws ExecutionContextException {
        ExecutionContext context;

        try {
            context = ExecutionContext.builder()
                    .userId(headers.get(Constants.USER_ID))
                    .contextIdentifier(headers.get(Constants.CONTEXT_IDENTIFIER))
                    .build();
        } catch (final Exception e) {
            throw new ExecutionContextException(e);
        }

        return context;
    }
}
