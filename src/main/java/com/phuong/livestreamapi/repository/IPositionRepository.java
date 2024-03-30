package com.phuong.livestreamapi.repository;

import com.phuong.livestreamapi.model.CustomerPosition;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPositionRepository extends JpaRepository<CustomerPosition, Integer> {
}
