package ir.maktabsharif.jpa;

import ir.maktabsharif.jpa.entities.User;
import ir.maktabsharif.jpa.entities.User_;
import ir.maktabsharif.jpa.entities.Wallet;
import ir.maktabsharif.jpa.entities.Wallet_;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.criteria.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class JpaApplication {

    static void main() {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("default")) {
            EntityManager em = emf.createEntityManager();

            UserSearchRequest request = new UserSearchRequest();
            request.setIsActive(false);
            request.setFirstname("7");
            request.setCash(1000L);
            System.out.println(
                    searchOnUsers(
                            em, request
                    ).size()
            );

        }
    }

    static List<User> searchOnUsers(EntityManager em, UserSearchRequest request) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<User> query = cb.createQuery(User.class);
        Root<User> userRoot = query.from(User.class);
        Join<User, Wallet> join = userRoot.join(User_.wallet);
        if (Objects.nonNull(request)) {
            List<Predicate> predicates = new ArrayList<>();
            if (Objects.nonNull(request.getFirstname())) {
                predicates.add(
                        cb.equal(
                                userRoot.get(User_.firstname), request.getFirstname()
                        )
                );
            }
            if (Objects.nonNull(request.getLastname())) {
                predicates.add(
                        cb.like(
                                userRoot.get(User_.lastname), "%" + request.getLastname() + "%"
                        )
                );
            }
            if (Objects.nonNull(request.getAge())) {
                predicates.add(
                        cb.equal(
                                userRoot.get(User_.age), request.getAge()
                        )
                );
            }
            if (Objects.nonNull(request.getIsActive())) {
                Path<Boolean> isActivePath = userRoot.get(User_.isActive);
                predicates.add(
                        request.getIsActive() ? cb.isTrue(isActivePath) : cb.isFalse(isActivePath)
                );

//                predicates.add(
//                        cb.equal(
//                                isActivePath, request.getIsActive()
//                        )
//                );
            }

            if (Objects.nonNull(request.getCash())) {
                predicates.add(
                        cb.equal(
                                join.get(Wallet_.cash), request.getCash()
                        )
                );
            }

            if (!predicates.isEmpty()) {
                query.where(
                        cb.and(predicates)
                );
            }
        }
        return em.createQuery(query).getResultList();
    }

}

@Setter
@Getter
class UserSearchRequest {

    private String firstname;
    private String lastname;
    private Integer age;
    private Boolean isActive;

    private Long cash;
}