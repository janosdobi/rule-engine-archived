package home.janos.ruleengine.model.event;

import home.janos.ruleengine.model.entity.BusinessEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public abstract class BusinessEventBase<E extends BusinessEntity> implements BusinessEvent {

    private final long id;
    private final String key;
    private final E entity;
    private final LocalDateTime createdAt;
}
