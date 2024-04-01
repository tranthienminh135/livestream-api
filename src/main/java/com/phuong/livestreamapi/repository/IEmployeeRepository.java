package com.phuong.livestreamapi.repository;

import com.phuong.livestreamapi.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEmployeeRepository extends JpaRepository<Employee, Integer> {
}
