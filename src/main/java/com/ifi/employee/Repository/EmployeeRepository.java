package com.ifi.employee.Repository;

import com.ifi.employee.Model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    List<Employee> findEmployeesByNameContaining(String name);


}
