package com.example.awspracticedemo.repository;

import com.example.awspracticedemo.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    Employee findByContactNumber(String contact);

}
