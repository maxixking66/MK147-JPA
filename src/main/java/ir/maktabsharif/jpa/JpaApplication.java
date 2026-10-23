package ir.maktabsharif.jpa;

import ir.maktabsharif.jpa.entities.User;
import ir.maktabsharif.jpa.entities.Wallet;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.Set;

public class JpaApplication {

    static void main() {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("default")) {
            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();
            User u = new User("mat", "mat");
            em.persist(u);

            Wallet w = new Wallet();
            em.persist(w);

//            Set<Wallet> wallets = new HashSet<>();
//            wallets.add(w);
//            u.setWallets(wallets);

            u.setWallets(Set.of(w));

            em.getTransaction().commit();
        }
    }
}
