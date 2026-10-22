package ir.maktabsharif.jpa;

import ir.maktabsharif.jpa.entities.User;
import ir.maktabsharif.jpa.entities.enums.Grade;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.time.ZonedDateTime;
import java.util.List;

public class JpaApplication {

    static void main() {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("default")) {
            EntityManager em = emf.createEntityManager();
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            User user = new User("asgari", "asgari123456789");
            user.setFirstname("mohsen");
            user.setLastname("asgari");
            user.setUsername("asgari");
            user.setPassword("asgari123456789");
            user.setIsActive(true);
            user.setCreatedDate(ZonedDateTime.now());
            user.setGrade(Grade.VERY_BAD);
            em.persist(user);
            transaction.commit();

            List<User> fromUser = em.createQuery("from User", User.class)
                    .getResultList();

            System.out.println(fromUser.size());
        }
    }
}
