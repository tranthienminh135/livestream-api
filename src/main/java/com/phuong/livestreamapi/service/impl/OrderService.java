package com.phuong.livestreamapi.service.impl;

import com.phuong.livestreamapi.dto.OrderDto;
import com.phuong.livestreamapi.dto.PaymentDto;
import com.phuong.livestreamapi.model.*;
import com.phuong.livestreamapi.repository.IAppUserRepository;
import com.phuong.livestreamapi.repository.IBillRepository;
import com.phuong.livestreamapi.repository.IOrderRepository;
import com.phuong.livestreamapi.repository.IProductRepository;
import com.phuong.livestreamapi.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.List;
import java.util.Objects;
import java.util.Random;

@Service
public class OrderService implements IOrderService {

    @Autowired
    private IOrderRepository orderRepository;

    @Autowired
    private IProductRepository productRepository;

    @Autowired
    private IAppUserRepository appUserRepository;

    @Autowired
    private IBillRepository billRepository;

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
        return this.orderRepository.findAllByUsername(username);
    }

    @Override
    public List<ProductOrder> getOrdersByUsername(String username) {
        return this.orderRepository.getOrdersByUsername(username);
    }

    @Override
    @Transactional
    public void payment(PaymentDto paymentDto, String username) {
        AppUser appUser = this.appUserRepository.getAppUserByUsername(username);
        List<ProductOrder> productOrders = this.orderRepository.findAllByUsername(username);
        double totalPrice = 0;
        for (ProductOrder productOrder: productOrders) {
            totalPrice += productOrder.getQuantity() * productOrder.getProduct().getPrice();
        }
        Bill newBill = addNewBill(paymentDto, appUser, productOrders, totalPrice);
        for (ProductOrder productOrder: productOrders) {
            productOrder.setBill(newBill);
            Product product = productOrder.getProduct();
            product.setQuantity(product.getQuantity() - productOrder.getQuantity());
            this.productRepository.save(product);
            this.orderRepository.save(productOrder);
        }
    }

    @Override
    public List<ProductOrder> getOrderHistoryByUsername(String username) {
        return this.orderRepository.getOrderHistoryByUsername(username);
    }

    private Bill addNewBill(PaymentDto paymentDto, AppUser appUser, List<ProductOrder> productOrders, double totalPrice) {
        Bill bill = new Bill();
        bill.setOrderDate(new Date(System.currentTimeMillis()));
        PaymentStatus paymentStatus = new PaymentStatus();
        paymentStatus.setId(paymentDto.getPaymentStatusId());
        bill.setPaymentStatus(paymentStatus);
        bill.setTotalPrice(totalPrice);
        bill.setMessageToSeller(paymentDto.getMessageToSeller());
        bill.setCurrentAddress(appUser.getAddress());
        bill.setCurrentPhoneNumber(appUser.getPhoneNumber());
        OrderStatus orderStatus = new OrderStatus();
        orderStatus.setId(1);
        bill.setOrderStatus(orderStatus);
        randomCodeBill(bill);
        return this.billRepository.save(bill);
    }

    private void randomCodeBill(Bill bill) {
        List<Bill> bills = this.billRepository.findAll();
        Random random = new Random();
        if (bills.isEmpty()) {
            bill.setCode(String.valueOf(random.nextInt(1000,9999)));
        } else {
            String randomCode = String.valueOf(random.nextInt(1000,9999));
            for (Bill b: bills) {
                while (b.getCode().equals(randomCode)) {
                    randomCode = String.valueOf(random.nextInt(1000,9999));
                }
            }
            bill.setCode(randomCode);
        }
    }

    private void addNewProductToCart(Product product, AppUser appUser) {
        ProductOrder po = new ProductOrder();
        po.setCurrentPrice(product.getPrice());
        po.setCurrentName(product.getName());
        po.setCurrentCover(product.getCover());
        po.setAppUser(appUser);
        po.setProduct(product);
        po.setQuantity(1);
        po.setOrderDate(new Date(System.currentTimeMillis()));
        this.orderRepository.save(po);
    }
}
