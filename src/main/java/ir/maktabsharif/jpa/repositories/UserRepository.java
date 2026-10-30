package ir.maktabsharif.jpa.repositories;

import ir.maktabsharif.jpa.entities.User;
import ir.maktabsharif.jpa.repositories.base.JpaRepository;
import ir.maktabsharif.jpa.repositories.base.PagingAndSortingRepository;

public interface UserRepository extends JpaRepository<User, Long>,
        PagingAndSortingRepository<User> {

    boolean existsByUsername(String username);
}
