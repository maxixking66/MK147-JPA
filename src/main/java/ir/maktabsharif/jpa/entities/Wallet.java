package ir.maktabsharif.jpa.entities;

import ir.maktabsharif.jpa.entities.base.BaseDomain;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = Wallet.TABLE_NAME)
@Setter
@Getter
@NoArgsConstructor
public class Wallet extends BaseDomain<Long> {

    public static final String TABLE_NAME = "wallets";

    private Long cash;

    private Long credit;

    @OneToOne(mappedBy = "wallet")
    private User user;

    @Transient
    private Long total;

    public Long getTotal() {
        this.total = getCash() + getCredit();
        return total;
    }
}
