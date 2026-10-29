package ir.maktabsharif.jpa;

import ir.maktabsharif.jpa.entities.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class JpaApplication {

    static void main() {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("default")) {
            EntityManager em = emf.createEntityManager();

            System.out.println("-----------");
            TypedQuery<User> userTypedQuery = em.createQuery("from User", User.class);

            userTypedQuery.setHint(
                    "jakarta.persistence.fetchgraph",
                    em.getEntityGraph(User.USER_WALLET_GRAPH)
            );

            List<User> fromUser = userTypedQuery.getResultList();
            System.out.println("-----------");

            System.out.println(fromUser.size());

            fromUser.stream().map(u -> new UserData(u.getId(), u.getUsername(), u.getWallet().getCash()))
                    .forEach(System.out::println);

        }
    }

    record UserData(Long userId, String username, Long cash) {

    }
}
