package org.itstep.repositories;

import org.itstep.entities.Book;
import org.springframework.data.repository.CrudRepository;

public interface BooksRepository extends CrudRepository<Book, Long> {
}
