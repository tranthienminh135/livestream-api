package com.phuong.livestreamapi.service;

import com.phuong.livestreamapi.dto.RequestDto;
import com.phuong.livestreamapi.model.Customer;
import org.springframework.data.domain.Page;

public interface ICustomerService {
    Page<Customer> getAllPage(RequestDto requestDto);
}
