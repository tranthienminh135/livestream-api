package com.phuong.livestreamapi.repository;

import com.phuong.livestreamapi.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepository extends JpaRepository<Category, Integer> {
}
