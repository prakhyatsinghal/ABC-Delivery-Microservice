package com.felinos.microservice.repository;

import com.felinos.microservice.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository <Order, Long> {

      public Order findById(long id);
    }

