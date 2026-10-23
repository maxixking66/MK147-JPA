package ir.maktabsharif.jpa.entities;

import ir.maktabsharif.jpa.entities.enums.IdentificationType;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Customer extends User {

    private IdentificationType identificationType;

    private String identificationCode;

    public Customer(String username, String password) {
        super(username, password);
    }
}
