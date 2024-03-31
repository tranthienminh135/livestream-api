package com.phuong.livestreamapi.service;

import com.phuong.livestreamapi.dto.CustomerDto;
import com.phuong.livestreamapi.dto.RequestDto;
import com.phuong.livestreamapi.model.Customer;
import org.springframework.data.domain.Page;

public interface ICustomerService {
    Page<Customer> getAllPage(RequestDto requestDto);

    void save(CustomerDto customerDto);

    Customer findById(Integer id);

    void deleteCustomer(Integer id);

}
