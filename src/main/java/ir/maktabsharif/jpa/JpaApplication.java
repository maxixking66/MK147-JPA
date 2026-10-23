package ir.maktabsharif.jpa;

import ir.maktabsharif.jpa.entities.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.time.ZonedDateTime;

public class JpaApplication {

    static void main() {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("default")) {
            EntityManager em = emf.createEntityManager();
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
//            entity state -> transient/new
            User user = new User("asgari", "asgari123456789");
            System.out.println("em.contains before persist: " + em.contains(user));
            em.persist(user);
            System.out.println("em.contains after persist: " + em.contains(user));
//            entity state -> managed
            user.setFirstname("mohsen");
            user.setLastname("asgari");
            user.setIsActive(true);
            user.setCreatedDate(ZonedDateTime.now());
            System.out.println(user.getId());
            transaction.commit();
        }
    }
}
