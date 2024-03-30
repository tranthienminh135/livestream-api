package com.phuong.livestreamapi.controller;

import com.phuong.livestreamapi.dto.RequestDto;
import com.phuong.livestreamapi.model.Customer;
import com.phuong.livestreamapi.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("customer")
public class CustomerController {

    @Autowired
    private ICustomerService customerService;

    @PostMapping("")
    public ResponseEntity<?> getAllCustomer(@RequestBody RequestDto requestDto) {
        Page<Customer> customers = this.customerService.getAllPage(requestDto);
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }
}
