package com.example.demosecutity.persistence.repository;

import com.example.demosecutity.persistence.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

    Role findByName(String role);
}
