package com.wipro.java.hibernate.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // ✅ Enables AUTO_INCREMENT
    @Column(name = "empId")
    private int empId;

    @Column(name = "emp_name", nullable = false)
    private String name;

    public Employee() {}

    public Employee(String name) {
        this.name = name;
    }

    public int getEmpId() {
        return empId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}