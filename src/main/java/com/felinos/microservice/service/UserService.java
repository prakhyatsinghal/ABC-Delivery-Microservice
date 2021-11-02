package com.felinos.microservice.service;

import com.felinos.microservice.entities.User;
import com.felinos.microservice.repository.OrderRepository;
import com.felinos.microservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
@Service
public class UserService {

    @Autowired
    UserRepository userRepository ;

    @Autowired
    OrderRepository orderRepository;

    public User findOrderById(long uid) {
        User UserId = null;
        UserId = this.userRepository.findById(uid) ;
        return UserId;
    }

    public User addUser(User u) {
        User added=userRepository.save(u);
        return added;
    }

    public void updateOrder(User user, long userId) {
        user.setId(userId);
        userRepository.save(user);
    }

    public void deleteOrder(long uid) {
        userRepository.deleteById( uid);
    }


}
