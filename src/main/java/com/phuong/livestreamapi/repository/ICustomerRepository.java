package com.phuong.livestreamapi.repository;

import com.phuong.livestreamapi.dto.RequestDto;
import com.phuong.livestreamapi.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ICustomerRepository extends JpaRepository<Customer, Integer> {

    @Query(value = " select c from Customer c " +
            " join CustomerPosition cp on cp.id = c.customerPosition.id " +
            " join CustomerStatus cs on cs.id = c.customerStatus.id " +
            " where c.name like concat('%', :#{#requestDto.name}, '%') " +
            " and c.email like concat('%', :#{#requestDto.email}, '%') " +
            " and (c.customerStatus.id = :#{#requestDto.statusId} or :#{#requestDto.statusId} = -1) " +
            " and (c.customerPosition.id = :#{#requestDto.positionId} or :#{#requestDto.positionId} = -1) ")
    Page<Customer> getAllPage(@Param("requestDto") RequestDto requestDto, Pageable pageable);
}
