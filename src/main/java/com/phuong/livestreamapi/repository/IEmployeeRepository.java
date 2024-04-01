package com.phuong.livestreamapi.repository;

import com.phuong.livestreamapi.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IEmployeeRepository extends JpaRepository<Employee, Integer> {

    @Query(" select e from Employee e " +
            " join EmployeePosition ep on e.employeePosition.id = ep.id " +
            " join EmployeeStatus es on e.employeeStatus.id = es.id ")
    List<Employee> getAll();
}
