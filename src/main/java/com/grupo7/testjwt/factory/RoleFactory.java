package com.grupo7.testjwt.factory;

import com.grupo7.testjwt.entity.ERole;
import com.grupo7.testjwt.entity.Role;
import com.grupo7.testjwt.exception.RoleNotFoundException;
import com.grupo7.testjwt.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RoleFactory {
    @Autowired
    RoleRepository roleRepository;

    public Role getInstance(String role) throws RoleNotFoundException {
        switch (role) {
            case "admin" -> {
                return roleRepository.findByName(ERole.ROLE_ADMIN);
            }
            case "user" -> {
                return roleRepository.findByName(ERole.ROLE_USER);
            }
            case "super_admin" -> {
                return roleRepository.findByName(ERole.ROLE_SUPER_ADMIN);
            }
            default -> throw  new RoleNotFoundException("No se encontro el rol " +  role);
        }
    }

}
