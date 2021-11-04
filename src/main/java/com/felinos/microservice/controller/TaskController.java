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
    public ResponseEntity<Order> getOrder(@PathVariable("id") int id) {
        Order user = orderservice.findOrderByUserId(id);
        if (user == null) {return ResponseEntity.status(HttpStatus.NOT_FOUND).build();}
        return ResponseEntity.of(Optional.of(user));}

    @PostMapping("/users/")
    public ResponseEntity<User> addUser(@RequestBody User user) {
        User u = null;
        try{u = this.userservice.addUser(user);
            System.out.println(u);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (Exception e){e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/orders/")
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

    @PostMapping("/items/")
    public ResponseEntity<Item> addItem(@RequestBody Item item) {
        Item i = null;
        try {
            i = this.itemService.addItem(item);
            System.out.println(i);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }

    @DeleteMapping("/orders/orderId/{Id}")
    public ResponseEntity<Void> deleteBook(@PathVariable("Id") int orderId) {
        try {
            this.orderservice.deleteOrderByUserId(orderId);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/orders/userId/{Id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable("Id") int userId) {
        try {
            this.orderservice.deleteOrderByUserId(userId);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/orders/orderId/{orderId}")
    public ResponseEntity<Order> updateOrder(@RequestBody Order order, @PathVariable("orderId") int orderId) {
        try {
            this.orderservice.updateOrderByOrderId(order, orderId);
            return ResponseEntity.ok().body(order);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }


    }

    @PutMapping("/orders/userId/{userId}")
    public ResponseEntity<Order> updateOrderByUserId(@RequestBody Order order, @PathVariable("userId") int userId) {
        try {
            this.orderservice.updateOrderByUserId(order, userId);
            return ResponseEntity.ok().body(order);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }


    }

}


