package home.janos.ruleengine.model.event;

import home.janos.ruleengine.model.entity.BusinessEntity;
import lombok.*;

import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
@NoArgsConstructor
public class SimpleBusinessEvent extends BusinessEventBase {

    @Builder
    public SimpleBusinessEvent(long id, String key, BusinessEntity entity, LocalDateTime createdAt) {
        super(id, key, entity, createdAt);
    }
}
