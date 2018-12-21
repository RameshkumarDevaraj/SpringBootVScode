package com.kg.springfinal.repository;

import com.kg.springfinal.model.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * TeamRepository
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    
}