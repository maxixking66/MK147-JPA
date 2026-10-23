package ir.maktabsharif.jpa.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@Embeddable
public class Address {

    public static final String POSTAL_CODE = "postal_code";

    private String address;

    @Column(name = POSTAL_CODE)
    private String postalCode;
}
