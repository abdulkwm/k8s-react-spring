package com.example.k8s;

import com.example.k8s.entity.Employee;
import com.example.k8s.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class K8sApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(K8sApplication.class, args);
    }
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public void run(String... args) throws Exception {
        Employee employee1 = new Employee(1,"abdu","ab@gmail.com");
        Employee employee2 = new Employee(2,"sekina","se@gmail.com");
        Employee employee3 = new Employee(3,"zakir","za@gmail.com");
        employeeRepository.save(employee1);
        employeeRepository.save(employee2);
        employeeRepository.save(employee3);
    }
}
