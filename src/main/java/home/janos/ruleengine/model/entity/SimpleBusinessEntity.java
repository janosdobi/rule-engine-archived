package home.janos.ruleengine.model.entity;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Getter
public class SimpleBusinessEntity extends BusinessEntityBase {

    private final String validatedString;
    private final double validatedDouble;

    @Builder
    public SimpleBusinessEntity(long id, LocalDateTime createdAt, String validatedString, double validatedDouble) {
        super(id, createdAt);
        this.validatedString = validatedString;
        this.validatedDouble = validatedDouble;
    }
}
