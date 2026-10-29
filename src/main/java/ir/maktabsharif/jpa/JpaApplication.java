package ir.maktabsharif.jpa;

import ir.maktabsharif.jpa.entities.User;
import ir.maktabsharif.jpa.entities.Wallet;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class JpaApplication {

    static void main() {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("default")) {
            EntityManager em = emf.createEntityManager();

            em.getTransaction().begin();

//            List<User> resultList = em.createNamedQuery(User.FIND_BY_USERNAME_NAMED_QUERY, User.class)
//                    .setParameter("username", "1")
//                    .getResultList();

            List<User> resultList = em.createQuery("from User", User.class).getResultList();

            System.out.println(resultList.size());
            Wallet wallet = resultList.getFirst().getWallet();
            System.out.println(em.contains(wallet));
            System.out.println("walletId: " + wallet.getId());
            System.out.println("before setCash");
            wallet.setCash(1000L);
            System.out.println("after setCash");

            em.getTransaction().commit();

        }
    }
}
