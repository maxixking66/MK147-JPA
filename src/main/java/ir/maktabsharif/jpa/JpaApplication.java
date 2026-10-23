package ir.maktabsharif.jpa;

import ir.maktabsharif.jpa.entities.Customer;
import ir.maktabsharif.jpa.entities.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JpaApplication {

    static void main() {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("default")) {
            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();

            System.out.println(
                    em.createQuery("from Customer", Customer.class)
                            .getResultList().size()
            );

            System.out.println(
                    em.createQuery("from User", User.class)
                            .getResultList().size()
            );

            em.getTransaction().commit();


        }
    }
}
