package home.janos.ruleengine.model.event;

import home.janos.ruleengine.model.entity.SimpleBusinessEntity;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Getter
public class SimpleBusinessEvent extends BusinessEventBase<SimpleBusinessEntity> {

    @Builder
    public SimpleBusinessEvent(long id, String key, SimpleBusinessEntity entity, LocalDateTime createdAt) {
        super(id, key, entity, createdAt);
    }
}
