package com.phuong.livestreamapi.controller.order;

import com.phuong.livestreamapi.dto.OrderDto;
import com.phuong.livestreamapi.dto.PaymentDto;
import com.phuong.livestreamapi.model.ProductOrder;
import com.phuong.livestreamapi.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("user/order")
public class UserOrderController {

    @Autowired
    private IOrderService orderService;

    @PostMapping("")
    public ResponseEntity<?> addProductToCart(@RequestBody OrderDto orderDto, Principal principal) {
        return new ResponseEntity<>(this.orderService.addToCart(orderDto, principal.getName()), HttpStatus.OK);
    }

    @PostMapping("show")
    public ResponseEntity<?> showCart(Principal principal) {
        List<ProductOrder> productOrders = this.orderService.getOrdersByUsername(principal.getName());
        return new ResponseEntity<>(productOrders, HttpStatus.OK);
    }

    @PostMapping("payment")
    public ResponseEntity<?> paymentComplete(@RequestBody PaymentDto paymentDto, Principal principal) {
        this.orderService.payment(paymentDto, principal.getName());
        return new ResponseEntity<>( HttpStatus.OK);
    }

    @PostMapping("history")
    public ResponseEntity<?> getOrderHistory(Principal principal) {
        List<ProductOrder> productOrders = this.orderService.getOrderHistoryByUsername(principal.getName());
        return new ResponseEntity<>(productOrders, HttpStatus.OK);
    }
}
