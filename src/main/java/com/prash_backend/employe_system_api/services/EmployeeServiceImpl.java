package com.prash_backend.employe_system_api.services;

import com.prash_backend.employe_system_api.entity.EmployeeEntity;
import com.prash_backend.employe_system_api.model.Employee;
import com.prash_backend.employe_system_api.repository.EmployeeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private  EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {

        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee createEmployee(Employee employee) {
//        we need to convert the employ to entity to save to the database
        EmployeeEntity employeeEntity= new EmployeeEntity();
        BeanUtils.copyProperties(employee,employeeEntity);

        employeeRepository.save(employeeEntity);
        return employee;
    }

    @Override
    public List<Employee> getAllEmployees() {
        List<EmployeeEntity> employeeEntities= employeeRepository.findAll();
        List<Employee> employees = employeeEntities
                .stream()
                .map(emp -> new Employee(
                        emp.getId(),
                        emp.getFirstName(),
                        emp.getLastName(),
                        emp.getEmailId()
                )
                )
                .collect(Collectors.toList());
        System.out.printf(employees.toString(),employeeEntities);
        return employees;
    }

    @Override
    public boolean deleteEmployee(long id) {
        EmployeeEntity employeeEntity = employeeRepository.findById(id).get();
        employeeRepository.delete(employeeEntity);

        return true;
    }

    @Override
    public Employee getEmployeeById(long id) {
        EmployeeEntity employeeEntity= employeeRepository.findById(id).get();
//
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeEntity,employee);


        return employee;

    }

    @Override
    public Employee updateEmployee(long id, Employee employee) {
        EmployeeEntity employeeEntity= employeeRepository.findById(id).get();
        employeeEntity.setEmailId(employee.getEmailId());
        employeeEntity.setFirstName(employee.getFirstName());
        employeeEntity.setLastName(employee.getLastName());

        employeeRepository.save(employeeEntity);
        return employee;
    }

    //    we need object of this employee service in our controller
//    as we need to call service from controller
//     from this service we will be calling our repository


}
