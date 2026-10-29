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

            User user = new User("1", "1");
            em.persist(user);

            Customer customer = new Customer("2", "2");
            em.persist(customer);

            em.getTransaction().commit();


        }
    }
}
