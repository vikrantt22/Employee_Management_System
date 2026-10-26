package com.employee.ems.service;

import com.employee.ems.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    private final List<Employee> employees = new ArrayList<>();

    public EmployeeService () {
        employees.add(new Employee(1, "Vikrant", "vikrant@gmail.com", "IT", 50000));
        employees.add(new Employee(2, "Asmita", "asmita@gmail.com", "Teacher", 90000));
        employees.add(new Employee(3, "Sneha", "sneha@gmail.com", "Doctor", 80000));
    }

    public List<Employee> getAllEmployees() {
        return employees;
    }

    public Employee addEmployee(Employee employee)  {
        employees.add(employee);
        return employee;
    }

    public Employee getEmployeeById(int id) {
        for(Employee employee : employees) {
            if (employee.getId() == id) {
                return employee;
            }
        }
        return null;
    }

    public Employee updateEmployee(int id, Employee updatedEmployee) {
        for(int i=0; i<employees.size(); i++) {
            Employee employee = employees.get(i);
            if (employee.getId() == id) {
                Employee updated = new Employee(
                        id,
                        updatedEmployee.getName(),
                        updatedEmployee.getEmail(),
                        updatedEmployee.getDepartment(),
                        updatedEmployee.getSalary()
                );
                employees.set(i, updated);
                return updated;
            }
        }
        return null;
    }

    public boolean deleteEmployee(int id) {
        for(int i=0; i<employees.size(); i++) {
            Employee employee = employees.get(i);
            if(employee.getId() == id) {
                employees.remove(i);
                return true;
            }
        }
        return false;
    }
}
