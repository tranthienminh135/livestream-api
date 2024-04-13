package com.phuong.livestreamapi.service;

import com.phuong.livestreamapi.dto.OrderDto;
import com.phuong.livestreamapi.dto.PaymentDto;
import com.phuong.livestreamapi.model.ProductOrder;

import java.util.List;

public interface IOrderService {
    List<ProductOrder> addToCart(OrderDto orderDto, String username);

    List<ProductOrder> getOrdersByUsername(String username);

    void payment(PaymentDto paymentDto, String name);

    List<ProductOrder> getOrderHistoryByUsername(String name);
}
