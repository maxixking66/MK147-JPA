package ir.maktabsharif.jpa.repositories.base;

import ir.maktabsharif.jpa.entities.base.BaseDomain;

import java.util.List;
import java.util.Optional;

public interface JpaRepository<T extends BaseDomain<ID>, ID extends Number> {

    Optional<T> findById(ID id);

    T save(T t);

    void deleteById(ID id);

    void delete(T t);

    List<T> findAll();

    long count();

}
