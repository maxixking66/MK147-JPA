package ir.maktabsharif.jpa.repositories.base;

import ir.maktabsharif.jpa.entities.base.BaseDomain;
import ir.maktabsharif.jpa.utils.TransactionManager;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RequiredArgsConstructor
public abstract class SimpleJpaRepository<T extends BaseDomain<ID>, ID extends Number>
        implements JpaRepository<T, ID>, PagingAndSortingRepository<T> {

    protected final EntityManager entityManager;

    protected final TransactionManager transactionManager;

    @Override
    public Optional<T> findById(ID id) {
        return Optional.ofNullable(
                entityManager.find(getEntityClass(), id)
        );
    }

    @Override
    public T save(T t) {
        return transactionManager.execute(
                () -> {
                    if (Objects.isNull(t.getId())) {
                        entityManager.persist(t);
                    } else {
                        return entityManager.merge(t);
                    }
                    return t;
                }
        );
    }

    @Override
    public void deleteById(ID id) {
        delete(
                entityManager.getReference(
                        getEntityClass(), id
                )
        );
    }

    @Override
    public void delete(T t) {
        transactionManager.execute(
                () -> {
                    entityManager.remove(t);
                    return null;
                }
        );
    }

    @Override
    public List<T> findAll() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> cq = cb.createQuery(getEntityClass());
        cq.from(getEntityClass());
        return entityManager.createQuery(cq).getResultList();
    }

    @Override
    public long count() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<T> entityRoot = cq.from(getEntityClass());
        cq.select(cb.count(entityRoot));
        return entityManager.createQuery(cq).getSingleResult();
    }

    @Override
    public Page<T> findAll(Pageable pageable) {
        long count = count();
        if (count == 0) {
            return Page.PageImpl.empty(pageable);
        }
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> cq = cb.createQuery(getEntityClass());
        cq.from(getEntityClass());
        List<T> resultList = entityManager.createQuery(cq)
                .setFirstResult(pageable.offset())
                .setMaxResults(pageable.size())
                .getResultList();
        return new Page.PageImpl<>(resultList, pageable, count);
    }

    protected abstract Class<T> getEntityClass();
}
