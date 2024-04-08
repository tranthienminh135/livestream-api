package com.phuong.livestreamapi.controller;

import com.phuong.livestreamapi.dto.CustomerDto;
import com.phuong.livestreamapi.dto.RequestDto;
import com.phuong.livestreamapi.model.Customer;
import com.phuong.livestreamapi.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("customer")
public class CustomerController {

    @Autowired
    private ICustomerService customerService;

    @PostMapping("")
    public ResponseEntity<?> getAllCustomer(@RequestBody RequestDto requestDto) {
        Page<Customer> customers = this.customerService.getAllPage(requestDto);
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<?> saveCustomer(@RequestBody CustomerDto customerDto) {
        this.customerService.save(customerDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/get")
    public ResponseEntity<?> findCustomerById(@RequestBody CustomerDto customerDto) {
        Customer customer = this.customerService.findById(customerDto.getId());
        return new ResponseEntity<>(customer,HttpStatus.OK);
    }

    @PostMapping("/delete")
    public ResponseEntity<?> deleteCustomer(@RequestBody CustomerDto customerDto) {
        this.customerService.deleteCustomer(customerDto.getId());
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
