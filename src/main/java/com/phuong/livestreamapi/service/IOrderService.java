package com.phuong.livestreamapi.service;

import com.phuong.livestreamapi.dto.OrderDto;
import com.phuong.livestreamapi.model.ProductOrder;

import java.util.List;

public interface IOrderService {
    void addToCart(OrderDto orderDto, String username);

    List<ProductOrder> getOrdersByUsername(String username);
}
