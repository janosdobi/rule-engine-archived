package home.janos.ruleengine.service.handler;

import home.janos.ruleengine.model.event.BusinessEvent;
import org.springframework.stereotype.Service;

@Service
public class SimpleBusinessEventHandler implements BusinessEventHandler {
    @Override
    public String handle(final BusinessEvent event) {
        return null;
    }
}
