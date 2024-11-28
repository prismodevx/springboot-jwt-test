package com.grupo7.testjwt.service.impl;

import com.grupo7.testjwt.entity.User;
import com.grupo7.testjwt.repository.UserRepository;
import com.grupo7.testjwt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public boolean existsByUsername(String username) {
        return userRepository.existsByUsername(username);
    }

    @Override
    public boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    @Override
    public void save(User user){
        userRepository.save(user);
    }
}
