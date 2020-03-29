package home.janos.ruleengine.service.handler;

import home.janos.ruleengine.model.event.BusinessEvent;

public interface BusinessEventHandler {

    String handle(final BusinessEvent event);
}
