package com.phuong.livestreamapi.repository;

import com.phuong.livestreamapi.model.EmployeeStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IStatusRepository extends JpaRepository<EmployeeStatus, Integer> {
}
