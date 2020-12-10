package org.itstep.repositories;

import org.itstep.entities.PersonalData;
import org.springframework.data.repository.CrudRepository;

public interface PersonalDataRepository extends CrudRepository<PersonalData, Long> {
}
