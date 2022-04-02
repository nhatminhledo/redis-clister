package com.redis.api;


import com.redis.ResouceNotFoundException;
import com.redis.common.Response;
import com.redis.constant.RestURIConstant;
import com.redis.model.Customer;
import com.redis.repository.EmployeeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController extends AbstractController{

    @Autowired
    private EmployeeRepository employeeRepository;

    @RequestMapping(path = RestURIConstant.EMPLOYEES, method = RequestMethod.POST)
    public ResponseEntity<Response> addEmployee(@RequestBody Customer employee) {
        final Customer customer = employeeRepository.save(employee);

        return responseUtil.successResponse(customer);
    }

    @RequestMapping(path = RestURIConstant.EMPLOYEES, method = RequestMethod.GET)
    public ResponseEntity<Response> getAllEmployees() {
        return responseUtil.successResponse(employeeRepository.findAll());
    }

    @RequestMapping(path = RestURIConstant.EMPLOYEES + RestURIConstant.DETAILS, method = RequestMethod.GET)
    @Cacheable(value = "employees",key = "#employeeId")
    public Customer findEmployeeById(@PathVariable(value = "employeeId") Long employeeId) {
        System.out.println("Employee fetching from database:: "+employeeId);
        
        return employeeRepository.findById(employeeId).orElseThrow(
                () -> new ResouceNotFoundException("Employee not found" + employeeId));
    }

    @RequestMapping(path = RestURIConstant.EMPLOYEES, method = RequestMethod.PUT)
    @CachePut(value = "employees",key = "#root.args[0].id")
    public ResponseEntity<Response> updateEmployee(@RequestBody Customer employeeDetails) {
        final Customer updatedEmployee = employeeRepository.save(employeeDetails);

        return responseUtil.successResponse(updatedEmployee);
    }

    @RequestMapping(path = RestURIConstant.EMPLOYEES + RestURIConstant.DETAILS, method = RequestMethod.DELETE)
    @CacheEvict(value = "employees", allEntries = true)
    public void deleteEmployee(@PathVariable(value = "id") Long employeeId) {
        Customer employee = employeeRepository.findById(employeeId).orElseThrow(
                () -> new ResouceNotFoundException("Employee not found" + employeeId));
        employeeRepository.delete(employee);
    }
}
