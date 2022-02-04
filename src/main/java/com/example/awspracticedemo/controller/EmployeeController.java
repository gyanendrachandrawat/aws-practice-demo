package com.example.awspracticedemo.controller;

import com.example.awspracticedemo.model.Employee;
import com.example.awspracticedemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/test")
    public String test() {
        return "Hello this is test controller response";
    }

    @GetMapping("/getEmployees")
    public ResponseEntity<List<Employee>> getEmployees() {
        return new ResponseEntity<>(employeeService.getEmployees(), HttpStatus.OK);
    }

    @PostMapping("/createEmployee")
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        return new ResponseEntity<>(employeeService.createEmployee(employee), HttpStatus.OK);
    }

    @GetMapping("/getEmployeeById")
    public ResponseEntity<Employee> getEmployeeById(@RequestParam Integer id) {
        return new ResponseEntity<>(employeeService.getEmployeeById(id), HttpStatus.OK);
    }

    @DeleteMapping("/deleteEmployeeById")
    public ResponseEntity<Boolean> deleteEmployeeById(@RequestParam Integer id) {
        return new ResponseEntity<>(employeeService.deleteEmployeeById(id), HttpStatus.OK);
    }

    @PutMapping("/updateEmployeeById")
    public ResponseEntity<Employee> updateEmployeeById(@RequestParam Integer id, @RequestBody Employee employee) {
        return new ResponseEntity<>(employeeService.updateEmployeeById(id, employee), HttpStatus.OK);
    }

    @GetMapping("/getEmployeeByContact")
    public ResponseEntity<Employee> getEmployeeByContact(@RequestParam String contact) {
        return new ResponseEntity<>(employeeService.getEmployeeByContact(contact), HttpStatus.OK);
    }

}
