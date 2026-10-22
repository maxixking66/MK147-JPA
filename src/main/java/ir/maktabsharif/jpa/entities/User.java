package ir.maktabsharif.jpa.entities;

import jakarta.persistence.*;

import java.time.ZonedDateTime;

@Entity
@Table(
        name = User.TABLE_NAME,
        indexes = @Index(name = User.USERNAME_PASSWORD_INDEX_NAME,
                columnList = User.USERNAME_PASSWORD_INDEX)
)
public class User {

    public static final String TABLE_NAME = "users";
    public static final String IS_ACTIVE = "is_active";
    public static final String CREATED_DATE = "created_date";
    public static final String LAST_UPDATE_DATE = "last_update_date";
    public static final String USERNAME = "username";
    public static final String PASSWORD = "password";
    public static final String USERNAME_PASSWORD_INDEX_NAME = "users_username_password_index_name";
    public static final String USERNAME_PASSWORD_INDEX = USERNAME + "," + PASSWORD;

    @Id
//    @GeneratedValue
    private Long id;

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

    @Column(name = CREATED_DATE)
    private ZonedDateTime createdDate;

    @Column(name = LAST_UPDATE_DATE)
    private ZonedDateTime lastUpdateDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public ZonedDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(ZonedDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public ZonedDateTime getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(ZonedDateTime lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
