package home.janos.ruleengine.model.entity;

import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public abstract class BusinessEntityBase implements BusinessEntity {

    private long id;
    private LocalDateTime createdAt;

}
