package ir.maktabsharif.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JpaApplication {

    static void main() {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("default")) {
            EntityManager em = emf.createEntityManager();

            System.out.println(
                    em.createQuery("from User u where u.firstname like :fI or lastname = :lI")
                            .setParameter("fI", "%n%")
                            .setParameter("lI", "asgari")
                            .getResultList().size()
            );
        }
    }
}
