package com.example.redis.springbootrediscache.repository;

import com.example.redis.springbootrediscache.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Customer,Long> {
}
