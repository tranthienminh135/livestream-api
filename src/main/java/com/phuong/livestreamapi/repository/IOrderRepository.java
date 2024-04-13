package com.phuong.livestreamapi.repository;

import com.phuong.livestreamapi.model.ProductOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IOrderRepository extends JpaRepository<ProductOrder, Integer> {

    @Query(value = "select po from ProductOrder po where po.appUser.username = :#{#username} and po.bill.id is null and po.product.id = :#{#productId}")
    ProductOrder findOrderByUsernameAndProductId(@Param("username") String username,@Param("productId") Integer productId);

    @Query(value = "select po from ProductOrder po where po.appUser.username = :#{#username} and po.bill.id is null")
    List<ProductOrder> getOrdersByUsername(@Param("username") String username);
}
