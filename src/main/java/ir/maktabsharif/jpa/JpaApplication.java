package ir.maktabsharif.jpa;

import ir.maktabsharif.jpa.entities.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;

public class JpaApplication {

    static void main() {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("default")) {
            EntityManager em = emf.createEntityManager();

//            em.createQuery("from User", User.class);
//            em.createQuery("select u.id from User u", Long.class);

//            select w.user from Wallet w

//            "select u from User u"
            CriteriaBuilder cb = em.getCriteriaBuilder();

            CriteriaQuery<User> query = cb.createQuery(User.class);
            query.from(User.class);

            System.out.println(em.createQuery(query).getResultList().size());

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
