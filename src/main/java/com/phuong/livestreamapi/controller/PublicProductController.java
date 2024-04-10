package com.phuong.livestreamapi.controller;

import com.phuong.livestreamapi.model.Product;
import com.phuong.livestreamapi.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("public/product")
public class PublicProductController {

    @Autowired
    private IProductRepository productRepository;

    @GetMapping("8new")
    public ResponseEntity<?> get8NewProducts() {
        List<Product> products = this.productRepository.find8NewProducts();
        return new ResponseEntity<>(products,HttpStatus.OK);
    }
}
