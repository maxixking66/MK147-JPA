package ir.maktabsharif.jpa.entities;

import ir.maktabsharif.jpa.entities.base.BaseDomain;
import ir.maktabsharif.jpa.entities.enums.Grade;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.ZonedDateTime;

@Entity
@Table(
        name = User.TABLE_NAME,
        indexes = @Index(name = User.USERNAME_PASSWORD_INDEX_NAME,
                columnList = User.USERNAME_PASSWORD_INDEX)
)
@Setter
@Getter
@NoArgsConstructor
public class User extends BaseDomain<Long> {

    public static final String TABLE_NAME = "users";
    public static final String IS_ACTIVE = "is_active";
    public static final String LAST_UPDATE_DATE = "last_update_date";
    public static final String USERNAME = "username";
    public static final String PASSWORD = "password";
    public static final String USERNAME_PASSWORD_INDEX_NAME = "users_username_password_index_name";
    public static final String USERNAME_PASSWORD_INDEX = USERNAME + "," + PASSWORD;
    public static final String POSTAL_CODE = "postal_code";

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Column(length = 50)
    private String firstname;

    @Column(length = 50)
    private String lastname;

    @Column(name = USERNAME, nullable = false, unique = true, length = 30)
    private String username;

    @Column(name = PASSWORD, nullable = false)
    private String password;

    @Column(columnDefinition = "text")
    private String description;

    private Integer age;

    @Column(name = IS_ACTIVE)
    private Boolean isActive;

    @Column(name = LAST_UPDATE_DATE)
    private ZonedDateTime lastUpdateDate;

    @Enumerated(EnumType.STRING)
    private Grade grade;

    @Transient
    private String transientField;

    @Embedded
    private Address address;

    @OneToOne
//    @JoinColumn(name = "w_id")
    private Wallet wallet;

}
