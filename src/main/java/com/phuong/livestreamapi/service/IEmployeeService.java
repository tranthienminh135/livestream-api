package com.phuong.livestreamapi.service;

import com.phuong.livestreamapi.model.Employee;

import java.util.List;

public interface IEmployeeService {
    List<Employee> findAll();
}
