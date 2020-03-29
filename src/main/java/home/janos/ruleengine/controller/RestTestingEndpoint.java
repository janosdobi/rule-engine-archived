package home.janos.ruleengine.controller;

import home.janos.ruleengine.exception.ExecutionContextException;
import home.janos.ruleengine.model.context.ExecutionContext;
import home.janos.ruleengine.model.entity.SimpleBusinessEntity;
import home.janos.ruleengine.model.event.SimpleBusinessEvent;
import home.janos.ruleengine.service.handler.BusinessEventHandler;
import home.janos.ruleengine.util.BusinessContextUtil;
import home.janos.ruleengine.util.Constants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import java.util.Map;

@RestController
@Slf4j
public class RestTestingEndpoint {

    private final BusinessEventHandler businessEventHandler;

    @Autowired
    public RestTestingEndpoint(final BusinessEventHandler businessEventHandler) {
        this.businessEventHandler = businessEventHandler;
    }

    @PostMapping("/test")
    public ResponseEntity<Void> test(@RequestHeader Map<String, String> headers,
                                     @RequestBody @NotNull SimpleBusinessEvent event) {
        ResponseEntity<Void> responseEntity = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();

        try {
            final ExecutionContext context = BusinessContextUtil.getContextFromHeader(headers);
            if (businessEventHandler.handle(event, context)) {
                responseEntity = ResponseEntity.ok().build();
                log.info(Constants.LogMessage.EVENT_HANDLED);
            }
        } catch (final ExecutionContextException e) {
            log.error(Constants.LogMessage.EXECUTION_CONTEXT_ERROR);
        } catch (final Exception e) {
            log.error(Constants.LogMessage.EVENT_FAIL, e);
        }

        return responseEntity;
    }
}
