package com.example.excelmysql.controller;

import com.example.excelmysql.entity.Employee;
import com.example.excelmysql.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
public class Controller {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/upload")
    public ResponseEntity<?> upload(@RequestParam("file")MultipartFile file){
        this.employeeService.saveEmployee(file);
        return ResponseEntity.ok("file is uploaded");
    }
    @GetMapping("getemployee")
    public List<Employee> getEmployee(){
        return this.employeeService.getAllEmployee();
    }

}
