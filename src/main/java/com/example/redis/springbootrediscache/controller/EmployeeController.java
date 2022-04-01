package com.example.redis.springbootrediscache.controller;


import com.example.redis.springbootrediscache.ResouceNotFoundException;
import com.example.redis.springbootrediscache.model.Customer;
import com.example.redis.springbootrediscache.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;

    @PostMapping("/employees")
    public Customer addEmployee(@RequestBody Customer employee) {

        return employeeRepository.save(employee);
    }


    @GetMapping("/employees")
    public ResponseEntity<List<Customer>> getAllEmployees() {
        return ResponseEntity.ok(employeeRepository.findAll());
    }

    @GetMapping("employees/{employeeId}")
    @Cacheable(value = "employees",key = "#employeeId")
    public Customer findEmployeeById(@PathVariable(value = "employeeId") Long employeeId) {
        System.out.println("Employee fetching from database:: "+employeeId);
        return employeeRepository.findById(employeeId).orElseThrow(
                () -> new ResouceNotFoundException("Employee not found" + employeeId));
    }


    @PutMapping("employees")
    @CachePut(value = "employees",key = "#root.args[0].id")
    public Customer updateEmployee(@RequestBody Customer employeeDetails) {
        final Customer updatedEmployee = employeeRepository.save(employeeDetails);
        return updatedEmployee;
    }


    @DeleteMapping("employees/{id}")
    @CacheEvict(value = "employees", allEntries = true)
    public void deleteEmployee(@PathVariable(value = "id") Long employeeId) {
        Customer employee = employeeRepository.findById(employeeId).orElseThrow(
                () -> new ResouceNotFoundException("Employee not found" + employeeId));
        employeeRepository.delete(employee);
    }
}
