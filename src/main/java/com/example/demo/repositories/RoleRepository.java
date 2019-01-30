package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Role;

@Repository("roleRepository")
public interface RoleRepository extends JpaRepository<Role, Long>{

	Role findByRole(String role);
}
