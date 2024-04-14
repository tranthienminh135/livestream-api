package com.phuong.livestreamapi.controller.product;

import com.phuong.livestreamapi.dto.RequestDto;
import com.phuong.livestreamapi.model.Product;
import com.phuong.livestreamapi.repository.IProductRepository;
import com.phuong.livestreamapi.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("public/product")
public class PublicProductController {

    @Autowired
    private IProductRepository productRepository;

    @Autowired
    private IProductService productService;

    @GetMapping("8new")
    public ResponseEntity<?> get8NewProducts() {
        List<Product> products = this.productRepository.find8NewProducts();
        return new ResponseEntity<>(products,HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<?> getAllPageProduct(@RequestBody RequestDto requestDto) {
        Page<Product> products = this.productService.getAllPage(requestDto);
        return new ResponseEntity<>(products,HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getProductById(@PathVariable Integer id) {
        Product product = this.productRepository.findById(id).orElse(new Product());
        return new ResponseEntity<>(product,HttpStatus.OK);
    }

    @GetMapping("/popular")
    public ResponseEntity<?> get6ProductsPopular() {
        List<Product> products = this.productRepository.find6PopularProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/recommended")
    public ResponseEntity<?> get6ProductsRecommended() {
        List<Product> products = this.productRepository.find4RecommendedProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
}
