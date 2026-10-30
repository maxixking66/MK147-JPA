package ir.maktabsharif.jpa.utils;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;

import java.util.function.Supplier;

@RequiredArgsConstructor
public class TransactionManager {

    private final EntityManager entityManager;

    public <T> T execute(Supplier<T> logic) {
        T t;
        entityManager.getTransaction().begin();
        try {
            t = logic.get();
            entityManager.getTransaction().commit();
        } catch (Throwable throwable) {
            entityManager.getTransaction().rollback();
            throw throwable;
        }
        return t;
    }
}
