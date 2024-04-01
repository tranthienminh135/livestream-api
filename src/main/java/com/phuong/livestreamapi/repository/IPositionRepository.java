package com.phuong.livestreamapi.repository;

import com.phuong.livestreamapi.model.EmployeePosition;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPositionRepository extends JpaRepository<EmployeePosition, Integer> {
}
