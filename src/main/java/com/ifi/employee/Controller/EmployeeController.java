package com.ifi.employee.Controller;

import com.ifi.employee.Model.Employee;
import com.ifi.employee.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping(value = "/")
    public List<Employee> viewEmployeeList() {
        return employeeRepository.findAll();
    }

    @GetMapping(value = "/{id}")
    public Employee viewEmployeeById(
            @PathVariable(value = "id") Long id) {
        return employeeRepository.findById(id).get();
    }

    @PostMapping(value = "/")
    public Employee addEmployee(
            @RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }

    @PutMapping(value = "/{id}")
    public void updateEmployee(
            @PathVariable(value = "id") Long id,
            @RequestBody Employee employee) {
        if(employeeRepository.existsById(id)) {
            employee.setId(id);
            employeeRepository.save(employee);
        }
    }

    @DeleteMapping(value = "/{id}")
    public void deleteEmployee(
            @PathVariable(value = "id") Long id) {
        if(employeeRepository.existsById(id)) {
            Employee employee = employeeRepository.getById(id);
            employeeRepository.delete(employee);
        }

    }

    @GetMapping("/search/{name}")
    public List<Employee> searchEmployee(
            @PathVariable(value = "name") String name) {
        return employeeRepository.findEmployeesByNameContaining(name);
    }
}

