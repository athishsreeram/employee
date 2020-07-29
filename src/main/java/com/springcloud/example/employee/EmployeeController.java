package com.springcloud.example.employee;

import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private EmployeeRepository employeeRepository;

    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Cacheable(value="employee",key="#id")
    @GetMapping("/{id}")
    private Employee getEmployeeById(@PathVariable String id) {
        return employeeRepository.findEmployeeById(id);
    }

    @Cacheable(value="employee")
    @GetMapping
    private List<Employee> getAllEmployees() {
        System.out.println("Called");

        return employeeRepository.findAllEmployees();
    }

    @CachePut(value="employee",key="#id")
    @PostMapping("/update")
    private Employee updateEmployee(@RequestBody Employee employee) {
        return employeeRepository.updateEmployee(employee);
    }

}