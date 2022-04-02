package com.example.redis.cache.repository;

import com.example.redis.cache.model.Customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Customer,Long> {
}
