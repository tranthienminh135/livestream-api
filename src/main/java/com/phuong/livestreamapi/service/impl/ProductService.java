package com.phuong.livestreamapi.service.impl;

import com.phuong.livestreamapi.dto.RequestDto;
import com.phuong.livestreamapi.model.Product;
import com.phuong.livestreamapi.repository.IProductRepository;
import com.phuong.livestreamapi.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository productRepository;

    @Override
    public Page<Product> getAllPage(RequestDto requestDto) {
        Pageable pageable = PageRequest.of(requestDto.getPage(), requestDto.getSize(), requestDto.getSortDirection(), requestDto.getSortBy());
        return this.productRepository.getAllPage(pageable, requestDto);
    }
}
