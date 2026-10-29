package ir.maktabsharif.jpa;

import ir.maktabsharif.jpa.entities.User;
import ir.maktabsharif.jpa.entities.User_;
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

//            "select u.username from User u where u.id= ?"
            CriteriaBuilder cb = em.getCriteriaBuilder();

            CriteriaQuery<User> query = cb.createQuery(User.class);
            Root<User> userRoot = query.from(User.class);
            query.where(
                    cb.equal(
                            userRoot.get(User_.id),
                            50L
                    )
            );

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
