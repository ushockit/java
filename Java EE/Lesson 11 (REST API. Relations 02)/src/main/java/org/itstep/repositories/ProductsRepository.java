package org.itstep.repositories;

import org.itstep.entities.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductsRepository extends CrudRepository<Product, Long> {
    List<Product> findAll();
}
