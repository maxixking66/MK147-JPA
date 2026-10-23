package ir.maktabsharif.jpa;

import ir.maktabsharif.jpa.entities.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JpaApplication {

    static void main() {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("default")) {
            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();

            User user = em.find(User.class, 152L);
            em.detach(user);
            em.persist(user);

            em.getTransaction().commit();
        }
    }
}
