package com.example.demo.DTO;

public class EmployeeDTO {

    private String name;
    private String email;
    private double salary;
    private String department;

    public EmployeeDTO() {
    }

    public EmployeeDTO(String name, String email, double salary, String department) {
        this.name = name;
        this.email = email;
        this.salary = salary;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}