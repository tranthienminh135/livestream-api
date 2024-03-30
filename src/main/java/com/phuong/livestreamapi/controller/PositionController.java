package com.phuong.livestreamapi.controller;

import com.phuong.livestreamapi.model.CustomerPosition;
import com.phuong.livestreamapi.repository.IPositionRepository;
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
@RequestMapping("position")
public class PositionController {

    @Autowired
    private IPositionRepository positionRepository;

    @GetMapping("")
    public ResponseEntity<?> getAllPosition() {
        List<CustomerPosition> customerPositions = this.positionRepository.findAll();
        return new ResponseEntity<>(customerPositions, HttpStatus.OK);
    }
}
