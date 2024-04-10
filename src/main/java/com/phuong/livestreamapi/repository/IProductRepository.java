package com.phuong.livestreamapi.repository;

import com.phuong.livestreamapi.dto.RequestDto;
import com.phuong.livestreamapi.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IProductRepository extends JpaRepository<Product, Integer> {

    @Query(value = " select p from Product p order by p.createdDate desc limit 8 ")
    List<Product> find8NewProducts();

    @Query(value = " select p from Product p " +
            " join Category c on c.id = p.category.id" +
            " where p.name like concat('%', :#{#requestDto.name} , '%') ")
    Page<Product> getAllPage(Pageable pageable,@Param("requestDto") RequestDto requestDto);

}
