package com.example.task2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.task2.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

}
