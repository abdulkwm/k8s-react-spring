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
        Employee employee1 = Employee.builder()
                .name("Abdu")
                .email("abdu2gmail.com")
                .build();
        Employee employee2 = Employee.builder()
                .name("Zakir")
                .email("zakir@gmail.com")
                .build();
        Employee employee3 = Employee.builder()
                .name("Sekina")
                .email("sekina@gmail.com")
                .build();
        employeeRepository.save(employee1);
        employeeRepository.save(employee2);
        employeeRepository.save(employee3);
    }
}
