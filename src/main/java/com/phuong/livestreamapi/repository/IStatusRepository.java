package com.phuong.livestreamapi.repository;

import com.phuong.livestreamapi.model.CustomerStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IStatusRepository extends JpaRepository<CustomerStatus, Integer> {
}
