package com.felinos.microservice.repository;

import com.felinos.microservice.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

      public User findById(long id);

}
