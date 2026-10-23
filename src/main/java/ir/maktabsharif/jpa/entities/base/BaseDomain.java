package ir.maktabsharif.jpa.entities.base;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.ZonedDateTime;

@Setter
@Getter
@NoArgsConstructor
@MappedSuperclass
public abstract class BaseDomain<ID extends Number> {

    public static final String CREATED_DATE = "created_date";

    @Id
    @GeneratedValue
    private ID id;

    @Column(name = CREATED_DATE)
    private ZonedDateTime createdDate;
}
