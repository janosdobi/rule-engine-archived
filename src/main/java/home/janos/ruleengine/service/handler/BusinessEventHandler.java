package home.janos.ruleengine.service.handler;

import home.janos.ruleengine.model.context.ExecutionContext;
import home.janos.ruleengine.model.entity.BusinessEntity;
import home.janos.ruleengine.model.event.BusinessEvent;

public interface BusinessEventHandler {

    boolean handle(final BusinessEvent<? extends BusinessEntity> event, final ExecutionContext context);
}
