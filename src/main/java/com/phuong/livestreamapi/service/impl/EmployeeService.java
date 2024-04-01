package com.phuong.livestreamapi.service.impl;

import com.phuong.livestreamapi.model.Employee;
import com.phuong.livestreamapi.repository.IEmployeeRepository;
import com.phuong.livestreamapi.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService implements IEmployeeService {

    @Autowired
    private IEmployeeRepository employeeRepository;

    @Override
    public List<Employee> findAll() {
        return this.employeeRepository.getAll();
    }
}
