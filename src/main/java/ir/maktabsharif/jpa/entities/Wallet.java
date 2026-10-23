package ir.maktabsharif.jpa.entities;

import ir.maktabsharif.jpa.entities.base.BaseDomain;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = Wallet.TABLE_NAME)
@Setter
@Getter
@NoArgsConstructor
public class Wallet extends BaseDomain<Long> {

    public static final String TABLE_NAME = "wallets";

    private Long cash = 0L;

    private Long credit = 0L;

    @ManyToMany(mappedBy = "wallets")
    private Set<User> users;

    @Transient
    private Long total;

    public Long getTotal() {
        this.total = getCash() + getCredit();
        return total;
    }
}
