package home.janos.ruleengine.model.event;

import home.janos.ruleengine.model.entity.BusinessEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public abstract class BusinessEventBase implements BusinessEvent {

    private long id;
    private String key;
    private BusinessEntity entity;
    private LocalDateTime createdAt;
}
