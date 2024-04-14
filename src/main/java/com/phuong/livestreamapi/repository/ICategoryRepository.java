package com.phuong.livestreamapi.repository;

import com.phuong.livestreamapi.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ICategoryRepository extends JpaRepository<Category, Integer> {

    @Query(value = " select c from Category c order by RAND() limit 8 ")
    List<Category> find8Categories();
}
