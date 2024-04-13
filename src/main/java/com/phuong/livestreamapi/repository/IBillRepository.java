package com.phuong.livestreamapi.repository;

import com.phuong.livestreamapi.model.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IBillRepository extends JpaRepository<Bill, Integer> {

}
