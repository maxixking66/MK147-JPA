package ir.maktabsharif.jpa;

import ir.maktabsharif.jpa.entities.User;
import jakarta.persistence.*;

import java.util.List;

public class JpaApplication {

    static void main() {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("default")) {
            EntityManager em = emf.createEntityManager();

            System.out.println("-----------");
            TypedQuery<User> userTypedQuery = em.createQuery("from User", User.class);

            EntityGraph<?> entityGraph = em.createEntityGraph(User.class);
            entityGraph.addAttributeNode("wallet");

//            jakarta.persistence.fetchgraph
//            jakarta.persistence.loadgraph -> spring data

            userTypedQuery.setHint(
                    "jakarta.persistence.fetchgraph", entityGraph
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
