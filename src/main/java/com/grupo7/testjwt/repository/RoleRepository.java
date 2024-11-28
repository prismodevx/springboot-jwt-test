package com.grupo7.testjwt.repository;

import com.grupo7.testjwt.entity.ERole;
import com.grupo7.testjwt.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(ERole name);
}
