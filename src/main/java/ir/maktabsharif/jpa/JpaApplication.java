package ir.maktabsharif.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class JpaApplication {

    static void main() {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("default")) {
            EntityManager em = emf.createEntityManager();

            System.out.println("-----------");
            TypedQuery<Long> typedQuery = em.createQuery("select id from User order by id desc", Long.class);
            typedQuery.setMaxResults(10);
            System.out.println(
                    typedQuery.getResultList()
            );

            System.out.println(
                    typedQuery.setFirstResult(10)
                            .getResultList()
            );

        }
    }

//    page = 0
//    size = 10
//    offset = page * size -> 0

//    page = 1
//    size = 10
//    offset = page * size -> 10

    record UserData(Long userId, String username, Long cash) {

    }
}
