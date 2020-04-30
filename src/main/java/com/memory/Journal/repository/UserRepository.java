package com.memory.Journal.repository;

import com.memory.Journal.model.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM user WHERE email=?1 and password=?2", nativeQuery = true)
    void deleteUser(String email, String password) throws IllegalArgumentException;

    @Query(value = "SELECT * FROM user WHERE email=?1 LIMIT 0,1", nativeQuery = true)
    Optional<User> findByEmail(String email);

    @Query(value = "SELECT * FROM user WHERE username=?1 LIMIT 0,1", nativeQuery = true)
    Optional<User> findByUsername(String username);

}
