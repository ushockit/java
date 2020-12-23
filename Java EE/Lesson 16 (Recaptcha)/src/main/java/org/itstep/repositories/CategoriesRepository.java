package org.itstep.repositories;

import org.itstep.entities.Category;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CategoriesRepository extends CrudRepository<Category, Long> {
    List<Category> findAll();
}
