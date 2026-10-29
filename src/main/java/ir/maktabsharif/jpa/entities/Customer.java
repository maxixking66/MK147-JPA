package ir.maktabsharif.jpa.entities;

import ir.maktabsharif.jpa.entities.enums.IdentificationType;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@DiscriminatorValue("cu_stomer")
public class Customer extends User {

    private IdentificationType identificationType;

    private String identificationCode;

    public Customer(String username, String password) {
        super(username, password);
    }
}
