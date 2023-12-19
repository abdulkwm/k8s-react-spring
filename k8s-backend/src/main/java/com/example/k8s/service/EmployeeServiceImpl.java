package com.example.k8s.service;

import com.example.k8s.entity.Employee;
import com.example.k8s.exception.EmployeeNotFoundException;
import com.example.k8s.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepo;

    //    Create
    @Override
    public Employee save(Employee employee) {
        return employeeRepo.save(employee);
    }

    //    Read
    @Override
    public Employee get(long id) {
        Employee employee = employeeRepo.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException("it is not found"));
        return employee;
    }

    @Override
    public List<Employee> getAll() {
        return employeeRepo.findAll();
    }

    //    Update

    @Override
    public Employee update(long id, Employee employee) {
        Employee emp = employeeRepo.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException("it is not found"));
        emp.setName(employee.getName());
        emp.setEmail(employee.getEmail());
        employeeRepo.save(emp);
        return emp;
    }

    //    Delete

    @Override
    public void delete(long id) {
        Employee employee = employeeRepo.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException("it is not found"));
        employeeRepo.delete(employee);
    }
}
