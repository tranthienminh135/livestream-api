package com.phuong.livestreamapi.service;

import com.phuong.livestreamapi.dto.RequestDto;
import com.phuong.livestreamapi.model.Product;
import org.springframework.data.domain.Page;

public interface IProductService {
    Page<Product> getAllPage(RequestDto requestDto);
}
