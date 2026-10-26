package com.employee.ems.controller;
import com.employee.ems.model.Employee;

import com.employee.ems.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/api/employees")
    public List<Employee> getEmployee() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/api/employees/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable int id) {
        Employee employee = employeeService.getEmployeeById(id);

        if(employee == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.ok(employee);
    }

    @PostMapping("/api/employees")
    public Employee addEmployee(@RequestBody Employee employee) {
        return employeeService.addEmployee(employee);
    }

    @PutMapping("/api/employees/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable int id, @RequestBody Employee employee) {
        Employee updated = employeeService.updateEmployee(id, employee);

        if(updated ==  null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/api/employees/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable int id) {
        if(!employeeService.deleteEmployee(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.noContent().build();
    }
}
