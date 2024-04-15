package com.phuong.livestreamapi.controller.category;

import com.phuong.livestreamapi.model.Category;
import com.phuong.livestreamapi.repository.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("public/category")
public class PublicCategoryController {

    @Autowired
    private ICategoryRepository ICategoryRepository;

    @GetMapping("")
    public ResponseEntity<?> getAllCategories() {
        List<Category> categories = this.ICategoryRepository.findAll();
        return new ResponseEntity<>(categories,HttpStatus.OK);
    }

    @GetMapping("4rand")
    public ResponseEntity<?> get4Categories() {
        List<Category> categories = this.ICategoryRepository.find4Categories();
        return new ResponseEntity<>(categories,HttpStatus.OK);
    }
}
