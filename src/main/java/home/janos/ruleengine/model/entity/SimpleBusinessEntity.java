package home.janos.ruleengine.model.entity;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Data
public class SimpleBusinessEntity extends BusinessEntityBase {

    private String validatedString;
    private double validatedDouble;

    @Builder
    public SimpleBusinessEntity(long id, LocalDateTime createdAt, String validatedString, double validatedDouble) {
        super(id, createdAt);
        this.validatedString = validatedString;
        this.validatedDouble = validatedDouble;
    }
}
