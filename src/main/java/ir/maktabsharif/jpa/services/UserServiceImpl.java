package ir.maktabsharif.jpa.services;

import ir.maktabsharif.jpa.entities.User;
import ir.maktabsharif.jpa.repositories.UserRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User register(User user) {
        userRepository.save(user);
        transferMoney();
        return null;
    }

    private void transferMoney() {

    }
}
