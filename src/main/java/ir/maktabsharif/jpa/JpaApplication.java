package ir.maktabsharif.jpa;

import ir.maktabsharif.jpa.entities.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

public class JpaApplication {

    static void main() {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("default")) {
            EntityManager em = emf.createEntityManager();

//            em.createQuery("from User", User.class);
//            em.createQuery("select u.id from User u", Long.class);

//            select w.user from Wallet w

//            "select count(u) from User u"
            CriteriaBuilder cb = em.getCriteriaBuilder();

            CriteriaQuery<Long> query = cb.createQuery(Long.class);
            Root<User> userRoot = query.from(User.class);
            query.select(cb.count(userRoot));

            System.out.println(em.createQuery(query).getResultList());

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
