package com.phuong.livestreamapi.service.impl;

import com.phuong.livestreamapi.dto.CustomerDto;
import com.phuong.livestreamapi.dto.RequestDto;
import com.phuong.livestreamapi.model.Customer;
import com.phuong.livestreamapi.model.CustomerPosition;
import com.phuong.livestreamapi.model.CustomerStatus;
import com.phuong.livestreamapi.repository.ICustomerRepository;
import com.phuong.livestreamapi.service.ICustomerService;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CustomerService implements ICustomerService {

    @Autowired
    private ICustomerRepository customerRepository;

    @Override
    public Page<Customer> getAllPage(RequestDto requestDto) {
        Pageable pageable = PageRequest.of(requestDto.getPage(), requestDto.getSize(), requestDto.getSortDirection(), requestDto.getSortBy());
        return this.customerRepository.getAllPage(requestDto, pageable);
    }

    @Override
    public void save(CustomerDto customerDto) {
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto, customer);
        CustomerPosition customerPosition = new CustomerPosition();
        customerPosition.setId(customerDto.getPositionId());
        CustomerStatus customerStatus = new CustomerStatus();
        customerStatus.setId(customerDto.getStatusId());
        customer.setAvatar(customerDto.getAvatar());
        customer.setCustomerPosition(customerPosition);
        customer.setCustomerStatus(customerStatus);
        this.customerRepository.save(customer);
    }

    @Override
    public Customer findById(Integer id) {
        return this.customerRepository.findById(id).get();
    }

    @Override
    public void deleteCustomer(Integer id) {
        this.customerRepository.deleteById(id);
    }
}
