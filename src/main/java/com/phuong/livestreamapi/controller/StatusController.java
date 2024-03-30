package com.phuong.livestreamapi.controller;

import com.phuong.livestreamapi.model.CustomerPosition;
import com.phuong.livestreamapi.model.CustomerStatus;
import com.phuong.livestreamapi.repository.IStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("status")
public class StatusController {

    @Autowired
    private IStatusRepository statusRepository;

    @GetMapping("")
    public ResponseEntity<?> getAllPosition() {
        List<CustomerStatus> customerPositions = this.statusRepository.findAll();
        return new ResponseEntity<>(customerPositions, HttpStatus.OK);
    }
}
