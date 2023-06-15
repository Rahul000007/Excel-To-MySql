package com.example.excelmysql.service;

import com.example.excelmysql.entity.Employee;
import com.example.excelmysql.helper.Dumping;
import com.example.excelmysql.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.List;

@Service
public class EmployeeServiceImp implements EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;

    @Override
    public void saveEmployee(MultipartFile file) {
        try {
            List<Employee> employees = Dumping.excelToList(file.getInputStream());
            this.employeeRepo.saveAll(employees);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Employee> getAllEmployee() {
        return this.employeeRepo.findAll();

    }
}
