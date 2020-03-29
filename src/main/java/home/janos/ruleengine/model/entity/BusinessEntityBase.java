package home.janos.ruleengine.model.entity;

import lombok.AllArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
public abstract class BusinessEntityBase implements BusinessEntity {

    private final long id;
    private final LocalDateTime createdAt;
}
