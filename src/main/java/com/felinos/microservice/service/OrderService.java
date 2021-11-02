package com.felinos.microservice.service;

import com.felinos.microservice.entities.Order;
import com.felinos.microservice.entities.User;
import com.felinos.microservice.repository.OrderRepository;
import com.felinos.microservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserRepository userRepository1;


    public Order addOrder(Order o) {
        Order result=orderRepository.save(o);
        return result;
    }

    public void updateOrder(Order order, long orderId) {
        order.setOrder_id(orderId);
        orderRepository.save(order);
    }

    public void deleteOrder(long oid) {
        orderRepository.deleteById(oid);
    }

}
