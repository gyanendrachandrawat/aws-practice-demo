package com.example.awspracticedemo.service;

import com.example.awspracticedemo.model.Employee;
import com.example.awspracticedemo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    public Employee createEmployee(Employee employee) {
        employee.setAge(LocalDate.now().getYear() - employee.getDateOfBirth().getYear());
        return employeeRepository.save(employee);
    }

    public Employee getEmployeeById(Integer id) {
        return employeeRepository.findById(id).orElse(null);
    }

    public Boolean deleteEmployeeById(Integer id) {
        employeeRepository.deleteById(id);
        return !employeeRepository.existsById(id);
    }

    public Employee updateEmployeeById(Integer id, Employee employee) {
        Employee tempEmployee = getEmployeeById(id);
        tempEmployee.setDateOfBirth(employee.getDateOfBirth());
        tempEmployee.setContactNumber(employee.getContactNumber());
        tempEmployee.setCity(employee.getCity());
        return createEmployee(tempEmployee);
    }

    public Employee getEmployeeByContact(String contact) {
        return employeeRepository.findByContactNumber(contact);
    }

}
