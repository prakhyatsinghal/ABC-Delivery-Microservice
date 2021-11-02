package com.felinos.microservice.repository;

import com.felinos.microservice.entities.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {

    public Item findById(long id);
}
