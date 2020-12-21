package org.itstep.repositories;

import org.itstep.entities.Person;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PeopleRepository extends CrudRepository<Person, Long> {
    List<Person> findByFirstName(String firstName);
}
