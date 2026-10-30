package ir.maktabsharif.jpa.entities.base;

import ir.maktabsharif.jpa.entities.PostLoadListener;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.ZonedDateTime;

@Setter
@Getter
@NoArgsConstructor
@MappedSuperclass
@EntityListeners(value = PostLoadListener.class)
public abstract class BaseDomain<ID extends Number> {

    public static final String CREATED_DATE = "created_date";
    public static final String LAST_UPDATED_DATE = "last_updated_date";

    @Id
    @GeneratedValue
    private ID id;

    @Column(name = CREATED_DATE)
    private ZonedDateTime createdDate;

    @Column(name = LAST_UPDATED_DATE)
    private ZonedDateTime lastUpdatedDate;

    @PrePersist
    public void prePersistOperation() {
        setCreatedDate(ZonedDateTime.now());
        setLastUpdatedDate(ZonedDateTime.now());
    }

    @PreUpdate
    public void preUpdateOperation() {
        setLastUpdatedDate(ZonedDateTime.now());
    }

    @PreRemove
    public void preRemoveOperation() {
        System.out.println("pre remove operation");
    }

//    @PostLoad
//    public void postLoadOperation() {
//        System.out.println("post load operation for entity: " + getClass().getSimpleName() + ", id: " + getId());
//    }
}
