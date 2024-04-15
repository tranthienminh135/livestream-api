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
            " where p.name like concat('%', :#{#requestDto.name} , '%') " +
            " and (p.category.id = :#{#requestDto.categoryId} or :#{#requestDto.categoryId} = -1)" +
            " and ((p.price between :#{#requestDto.priceFrom} and :#{#requestDto.priceTo}) or :#{#requestDto.priceFrom} is null or :#{#requestDto.priceTo} is null ) ")
    Page<Product> getAllPage(Pageable pageable,@Param("requestDto") RequestDto requestDto);

    @Query(" select p from ProductOrder po join Product p on po.product.id = p.id where po.bill.id is not null order by po.quantity desc")
    List<Product> find6PopularProducts();

    @Query(" select p from Product p order by RAND()")
    List<Product> find4RecommendedProducts();

    @Query(" select p.price from Product p order by p.price desc limit 1 ")
    Double getMaxPriceProduct();
}
