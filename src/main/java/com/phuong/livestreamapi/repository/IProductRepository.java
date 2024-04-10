package com.phuong.livestreamapi.repository;

import com.phuong.livestreamapi.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IProductRepository extends JpaRepository<Product, Integer> {

    @Query(value = " select p from Product p order by p.createdDate desc limit 8 ")
    List<Product> find8NewProducts();
}
