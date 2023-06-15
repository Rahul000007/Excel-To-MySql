package com.example.excelmysql.service;

import com.example.excelmysql.entity.Employee;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface EmployeeService {
    void saveEmployee(MultipartFile file);

    List<Employee> getAllEmployee();
}
