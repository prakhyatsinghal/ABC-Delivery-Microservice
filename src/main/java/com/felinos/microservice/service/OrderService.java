package com.felinos.microservice.service;

import com.felinos.microservice.entities.Order;
import com.felinos.microservice.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public Order findOrderByUserId(int uid) {
        Order UserId = null;
        UserId = this.orderRepository.findById(uid) ;
        return UserId;
    }

    public Order addOrder(Order o) {
        Order result=orderRepository.save(o);
        return result;
    }

    public void updateOrderByOrderId(Order order, long orderId) {
        order.setOrder_id(orderId);
        orderRepository.save(order);
    }

    public void updateOrderByUserId(Order order, int userId) {
        order.setUser_id(userId);
        orderRepository.save(order);
    }

    public void deleteOrderByUserId(int oid) {
        orderRepository.deleteById(oid);
    }



}
