package ir.maktabsharif.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class JpaApplication {

    static void main() {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("default")) {
            EntityManager em = emf.createEntityManager();

            List<NameProjection> fromUser = em.createQuery("select u.firstname, u.lastname from User u", NameProjection.class)
                    .getResultList();


            NameProjection nameProjection = fromUser.getFirst();
            nameProjection.firstname();
            System.out.println(fromUser);
        }
    }

    public record NameProjection(String firstname, String lastname) {
    }
}
