package ir.maktabsharif.jpa;

import ir.maktabsharif.jpa.entities.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class JpaApplication {

    static void main() {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("default")) {
            EntityManager em = emf.createEntityManager();

            System.out.println("-----------");
            List<User> fromUser = em.createQuery("from User", User.class)
                    .getResultList();
            System.out.println("-----------");

            System.out.println(fromUser.size());

            fromUser.stream().map(u -> {
                        if (u.getId() % 2 == 0) {
                            return new UserData(u.getId(), u.getUsername(), u.getWallet().getCash());
                        }
                        return new UserData(u.getId(), u.getUsername(), -1L);
                    })
                    .forEach(System.out::println);

        }
    }

    record UserData(Long userId, String username, Long cash) {

    }
}
