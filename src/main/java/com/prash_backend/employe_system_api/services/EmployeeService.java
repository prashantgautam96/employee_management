package com.prash_backend.employe_system_api.services;
import com.prash_backend.employe_system_api.model.Employee;

import java.util.List;

public interface EmployeeService {
    Employee createEmployee(Employee employee);

    List<Employee> getAllEmployees();


    boolean deleteEmployee(long id);

    Employee getEmployeeById(long id);


    Employee updateEmployee(long id, Employee employee);
}
