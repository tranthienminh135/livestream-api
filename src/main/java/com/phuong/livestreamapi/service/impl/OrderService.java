package com.phuong.livestreamapi.service.impl;

import com.phuong.livestreamapi.dto.OrderDto;
import com.phuong.livestreamapi.model.AppUser;
import com.phuong.livestreamapi.model.Product;
import com.phuong.livestreamapi.model.ProductOrder;
import com.phuong.livestreamapi.repository.IAppUserRepository;
import com.phuong.livestreamapi.repository.IOrderRepository;
import com.phuong.livestreamapi.repository.IProductRepository;
import com.phuong.livestreamapi.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.Objects;

@Service
public class OrderService implements IOrderService {

    @Autowired
    private IOrderRepository orderRepository;

    @Autowired
    private IProductRepository productRepository;

    @Autowired
    private IAppUserRepository appUserRepository;

    @Override
    public List<ProductOrder> addToCart(OrderDto orderDto, String username) {
        Product product = this.productRepository.findById(orderDto.getProductId()).orElse(new Product());
        AppUser appUser = this.appUserRepository.getAppUserByUsername(username);
        ProductOrder productOrder = this.orderRepository.findOrderByUsernameAndProductId(username, product.getId());
        if (Objects.isNull(productOrder)) {
            addNewProductToCart(product, appUser);
        } else {
            if (orderDto.getQuantity() == 1) {
                if (product.getQuantity() > productOrder.getQuantity()) {
                    productOrder.setQuantity(productOrder.getQuantity() + 1);
                    this.orderRepository.save(productOrder);
                }
            } else if (orderDto.getQuantity() == -1) {
                if (productOrder.getQuantity() > 1) {
                    productOrder.setQuantity(productOrder.getQuantity() - 1);
                    this.orderRepository.save(productOrder);
                } else if (productOrder.getQuantity() == 1) {
                    this.orderRepository.delete(productOrder);
                }
            }
        }
        return this.orderRepository.findAll();
    }

    @Override
    public List<ProductOrder> getOrdersByUsername(String username) {
        return this.orderRepository.getOrdersByUsername(username);
    }

    private void addNewProductToCart(Product product, AppUser appUser) {
        ProductOrder po = new ProductOrder();
        po.setAppUser(appUser);
        po.setProduct(product);
        po.setQuantity(1);
        po.setOrderDate(new Date(System.currentTimeMillis()));
        this.orderRepository.save(po);
    }
}
