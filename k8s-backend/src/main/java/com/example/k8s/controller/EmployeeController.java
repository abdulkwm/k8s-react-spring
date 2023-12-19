package com.example.k8s.controller;

import com.example.k8s.entity.Employee;
import com.example.k8s.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
//@CrossOrigin("*")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee){
        Employee emp = employeeService.save(employee);
        return new ResponseEntity<>(emp, HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable long id){
        Employee employee = employeeService.get(id);
        return new ResponseEntity<>(employee,HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees(){
        List<Employee> employees = employeeService.getAll();
        return new ResponseEntity<>(employees,HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable long id, @RequestBody Employee employee){
        Employee emp = employeeService.update(id,employee);
        return new ResponseEntity<>(emp, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable long id){
        employeeService.delete(id);
        String s = "the employee with id " + id + " is deleted";
        return new ResponseEntity<>(s,HttpStatus.OK);
    }

}
