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

            TypedQuery<User> query = em.createQuery("from User u where u.username = ?1", User.class);
            query.setParameter(1, "asgari");
            List<User> resultList = query.getResultList();
            System.out.println(resultList.getFirst());
        }
    }
}
