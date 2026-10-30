package ir.maktabsharif.jpa;

import ir.maktabsharif.jpa.entities.User;
import ir.maktabsharif.jpa.services.UserService;
import ir.maktabsharif.jpa.utils.ApplicationContext;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

public class JpaApplication {

    static void main() {
        ApplicationContext ctx = ApplicationContext.getInstance();
        try {
            UserService userService = ctx.getBean(UserService.class);
            User user = new User("1235", "1235");
            userService.register(user);

//            UserRepository userRepository = ctx.getBean(UserRepository.class);
//            User user = new User("1234", "1234");
//            userRepository.save(user);

        } finally {
            ctx.getBean(EntityManager.class).close();
            ctx.getBean(EntityManagerFactory.class).close();
        }
    }
}