package home.janos.ruleengine.controller;

import home.janos.ruleengine.model.event.BusinessEvent;
import home.janos.ruleengine.service.handler.BusinessEventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import java.util.Map;

@RestController
public class RestTestingEndpoint {

    private final BusinessEventHandler businessEventHandler;

    @Autowired
    public RestTestingEndpoint(final BusinessEventHandler businessEventHandler) {
        this.businessEventHandler = businessEventHandler;
    }

    @PostMapping("/test")
    public ResponseEntity<Void> test(@RequestHeader Map<String, String> headers,
                                     @RequestBody @NotNull BusinessEvent event) {
        businessEventHandler.handle(event);
        return ResponseEntity.ok().build();
    }
}
