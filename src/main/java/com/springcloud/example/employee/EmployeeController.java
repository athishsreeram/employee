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

    @RequestMapping("/get")
    private Employee getEmployeeById(@RequestParam String id) {
        System.out.println("Get Emp Called "+id);
        return employeeRepository.findEmployeeById(id);
    }

    @RequestMapping
    @ResponseBody
    private List<Employee> getAllEmployees() {
        System.out.println("Called");

        return employeeRepository.findAllEmployees();
    }

    @RequestMapping("/create")
    @ResponseBody
    private Employee create(@RequestParam String id,@RequestParam String name) {
        System.out.println("Created");
        Employee employee= new Employee();
        employee.setId(id);
        employee.setName(name);
        return employeeRepository.updateEmployee(employee);
    }

}