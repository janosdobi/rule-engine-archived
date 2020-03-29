package home.janos.ruleengine.model.event;

import home.janos.ruleengine.model.entity.BusinessEntity;
import lombok.*;

import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
@NoArgsConstructor
public class SimpleBusinessEvent<E extends BusinessEntity> extends BusinessEventBase<E> {

    @Builder
    public SimpleBusinessEvent(long id, String key, E entity, LocalDateTime createdAt) {
        super(id, key, entity, createdAt);
    }
}
