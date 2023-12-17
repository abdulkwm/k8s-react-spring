package com.example.k8s;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepo;

//    Create
    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee){
        return employeeRepo.save(employee);
    }
//    Read
    @GetMapping("/{id}")
    public Employee getEmployee(@PathVariable long id){
       Employee employee = employeeRepo.findById(id)
               .orElseThrow(()->new EmployeeNotFoundException("it is not found"));
       return employee;
    }
    @GetMapping
    public List<Employee> getAllEmployee(){
        List<Employee> employees = employeeRepo.findAll();
        return employees;
    }
//    Update
    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable long id, @RequestBody Employee employeeDetail){
        Employee employee = employeeRepo.findById(id)
                .orElseThrow(()->new EmployeeNotFoundException("it is not found"));
        employee.setName(employeeDetail.getName());
        employee.setEmail(employeeDetail.getEmail());
        employeeRepo.save(employee);
        return employee;
    }
//    Delete
    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable long id){
        Employee employee = employeeRepo.findById(id)
                .orElseThrow(()->new EmployeeNotFoundException("it is not found"));
        employeeRepo.delete(employee);
    }
}
