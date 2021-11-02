package com.felinos.microservice.controller;


import com.felinos.microservice.entities.Item;
import com.felinos.microservice.entities.Order;
import com.felinos.microservice.entities.User;
import com.felinos.microservice.service.ItemService;
import com.felinos.microservice.service.OrderService;
import com.felinos.microservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class TaskController {

    @Autowired
    private UserService userservice;

    @Autowired
    private OrderService orderservice;

    @Autowired
    private ItemService itemService;

    @GetMapping("/")
    public String Welcome() {
        return "Welcome to ABC Delivery";
    }

    @GetMapping("/orders/{id}")
    public ResponseEntity<User> getBook(@PathVariable("id") long id) {
        User user = userservice.findOrderById(id);
        if (user == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(user));
    }

    @PostMapping("/order/")
    public ResponseEntity<Order> addOrder(@RequestBody Order order) {
        Order o = null;
        try {
            o = this.orderservice.addOrder(order);
            System.out.println(o);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }


//    @PostMapping("/order/")
//    public void addOrder(@RequestBody Order order, @RequestBody User user, @RequestBody Item item) {
//        Order o = null;
//        o = this.orderservice.addOrder(o);
//        User u = null;
//        u = this.userservice.addUser(u);
//        Item i = null;
//        i = this.itemService.addItem(i);
//    }
}


