package home.janos.ruleengine.model.event;

import home.janos.ruleengine.model.entity.BusinessEntity;

public interface BusinessEvent<E extends BusinessEntity> {

    E getEntity();
}
