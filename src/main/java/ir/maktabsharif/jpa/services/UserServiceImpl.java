package ir.maktabsharif.jpa.services;

import ir.maktabsharif.jpa.entities.User;
import ir.maktabsharif.jpa.repositories.UserRepository;
import ir.maktabsharif.jpa.utils.TransactionManager;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final TransactionManager transactionManager;

    @Override
    public User register(User user) {
        return transactionManager.execute(
                () -> {
                    userRepository.save(user);
                    transferMoney();
                    return user;
                }
        );
    }

    private void transferMoney() {
        throw new RuntimeException();
    }
}
