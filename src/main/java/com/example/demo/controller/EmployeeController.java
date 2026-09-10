package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.DTO.EmployeeDTO;
import com.example.demo.Repository.EmployeeRepository;
import com.example.demo.model.Employee;


@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeRepository repository;

    // POST - Add employee
    @PostMapping
    public Employee addEmployee(@RequestBody EmployeeDTO dto) {

        Employee employee = new Employee();

        employee.setName(dto.getName());
        employee.setEmail(dto.getEmail());
        employee.setDepartment(dto.getDepartment());
        employee.setSalary(dto.getSalary());

        return repository.save(employee);
    }

    // GET - Get all employees
    @GetMapping
    public List<Employee> getAllEmployees() {
        return repository.findAll();
    }

    // GET - Get employee by ID
    @GetMapping("/{id}")
    public Employee getEmployee(@PathVariable Integer id) {
        return repository.findById(id).orElse(null);
    }

    // PUT - Update employee
    @PutMapping("/{id}")
    public Employee updateEmployee(
            @PathVariable Integer id,
            @RequestBody EmployeeDTO dto) {

        Employee employee = repository.findById(id).orElse(null);

        if (employee != null) {

            employee.setName(dto.getName());
            employee.setEmail(dto.getEmail());
            employee.setDepartment(dto.getDepartment());
            employee.setSalary(dto.getSalary());

            return repository.save(employee);
        }

        return null;
    }

    // DELETE - Delete employee
    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable Integer id) {

        repository.deleteById(id);

        return "Employee deleted successfully";
    }
}