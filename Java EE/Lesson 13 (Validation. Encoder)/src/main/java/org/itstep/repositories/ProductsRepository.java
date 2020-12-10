package org.itstep.repositories;

import org.itstep.entities.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductsRepository extends CrudRepository<Product, Long> {

}
