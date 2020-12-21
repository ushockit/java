package org.itstep.repositories;

import org.itstep.entities.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.stream.Stream;

public interface UsersRepository extends CrudRepository<User, Long> {
    User findUserByUsername(String username);
    User findUserByActivateCode(String code);
    @Query(value = "SELECT DISTINCT email FROM usrs WHERE email IS NOT NULL",
            nativeQuery = true)
    List<String> getAllUserEmails();
}
