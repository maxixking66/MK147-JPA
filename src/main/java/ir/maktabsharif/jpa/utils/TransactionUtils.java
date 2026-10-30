package ir.maktabsharif.jpa.utils;

import jakarta.persistence.EntityManager;

import java.util.function.Supplier;

public class TransactionUtils {

    private TransactionUtils() {

    }

    public static <T> T execute(EntityManager entityManager, Supplier<T> logic) {
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
