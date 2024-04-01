package com.phuong.livestreamapi.controller;

import com.phuong.livestreamapi.model.Employee;
import com.phuong.livestreamapi.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("employee")
public class EmployeeController {

    @Autowired
    private IEmployeeService employeeService;

    @GetMapping("")
    public ResponseEntity<?> getAllEmployee() {
        List<Employee> employees = this.employeeService.findAll();
        return new ResponseEntity<>(employees,HttpStatus.OK);
    }
}
