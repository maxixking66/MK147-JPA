package ir.maktabsharif.jpa.repositories;

import ir.maktabsharif.jpa.entities.User;
import ir.maktabsharif.jpa.entities.User_;
import ir.maktabsharif.jpa.repositories.base.SimpleJpaRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

public class UserRepositoryImpl extends SimpleJpaRepository<User, Long>
        implements UserRepository {

    public UserRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public boolean existsByUsername(String username) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<User> userRoot = cq.from(getEntityClass());
        cq.select(cb.count(userRoot));
        cq.where(cb.equal(userRoot.get(User_.username), username));
        return entityManager.createQuery(cq).getSingleResult() > 0;
    }

    @Override
    protected Class<User> getEntityClass() {
        return User.class;
    }
}
