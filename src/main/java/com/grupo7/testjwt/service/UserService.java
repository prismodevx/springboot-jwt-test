package com.grupo7.testjwt.service;

import com.grupo7.testjwt.entity.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
    void save(User user);
}


