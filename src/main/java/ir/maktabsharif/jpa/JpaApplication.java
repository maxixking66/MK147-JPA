package ir.maktabsharif.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JpaApplication {

    static void main() {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("default")) {
            EntityManager em1 = emf.createEntityManager();
            EntityManager em2 = emf.createEntityManager();
            EntityManager em3 = emf.createEntityManager();


        }


    }
}
