package ir.maktabsharif.jpa;

import ir.maktabsharif.jpa.entities.User;
import ir.maktabsharif.jpa.entities.Wallet;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JpaApplication {

    static void main() {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("default")) {
            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();

            User user = new User("1", "1");
            Wallet wallet = new Wallet();
            user.setWallet(wallet);
            em.persist(user);

            em.getTransaction().commit();


        }
    }
}
