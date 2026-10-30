package ir.maktabsharif.jpa.utils;

import ir.maktabsharif.jpa.repositories.UserRepository;
import ir.maktabsharif.jpa.repositories.UserRepositoryImpl;
import ir.maktabsharif.jpa.services.UserService;
import ir.maktabsharif.jpa.services.UserServiceImpl;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ApplicationContext {

    private static final ApplicationContext CTX = new ApplicationContext();

    private ApplicationContext() {
        initializingBean();
    }

    public static ApplicationContext getInstance() {
        return CTX;
    }

    private final Map<Class<?>, Object> beans = new HashMap<>();

    private void initializingBean() {
        registerBean(EntityManagerFactory.class, createEntityManagerFactory());
        registerBean(EntityManager.class, createEntityManager());
        registerBean(TransactionManager.class, createTransactionManager());
        UserRepositoryImpl userRepository = createUserRepository();
        registerBean(UserRepository.class, userRepository);
        registerBean(UserRepositoryImpl.class, userRepository);
        UserServiceImpl userService = createUserService();
        registerBean(UserService.class, userService);
        registerBean(UserServiceImpl.class, userService);
    }

    private UserServiceImpl createUserService() {
        return new UserServiceImpl(
                getBean(UserRepository.class),
                getBean(TransactionManager.class)
        );
    }

    private TransactionManager createTransactionManager() {
        return new TransactionManager(getBean(EntityManager.class));
    }

    private UserRepositoryImpl createUserRepository() {
        return new UserRepositoryImpl(
                getBean(EntityManager.class),
                getBean(TransactionManager.class)
        );
    }

    private <T> void registerBean(Class<T> tClass, T t) {
        beans.put(tClass, t);
    }

    public <T> T getBean(Class<T> tClass) {
        Object bean = beans.get(tClass);
        if (Objects.isNull(bean)) {
            throw new RuntimeException("no bean found for class: " + tClass.getSimpleName());
        }
        return tClass.cast(bean);
    }

    private EntityManagerFactory createEntityManagerFactory() {
        return Persistence.createEntityManagerFactory("default");
    }

    private EntityManager createEntityManager() {
        return getBean(EntityManagerFactory.class).createEntityManager();
    }
}
