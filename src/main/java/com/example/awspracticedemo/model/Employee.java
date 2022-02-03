package com.example.awspracticedemo.model;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String firstName;

    private String lastName;

    @NotNull
    @Column(nullable = false)
    private LocalDate dateOfBirth;

    private Integer age;

    @NotNull
    @Column(nullable = false, unique = true)
    private String contactNumber;

    private String city;

}
