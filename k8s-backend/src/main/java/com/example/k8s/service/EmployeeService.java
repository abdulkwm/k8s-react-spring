package com.example.k8s.service;

import com.example.k8s.entity.Employee;

import java.util.List;

public interface EmployeeService {
    Employee save(Employee employee);
    Employee get(long id);
    List<Employee> getAll();
    Employee update(long id, Employee employee);
    void delete(long id);
}
