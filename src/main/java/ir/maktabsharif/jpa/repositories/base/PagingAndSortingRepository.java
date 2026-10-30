package ir.maktabsharif.jpa.repositories.base;

import ir.maktabsharif.jpa.entities.base.BaseDomain;

public interface PagingAndSortingRepository<T extends BaseDomain<?>> {

    Page<T> findAll(Pageable pageable);

}
