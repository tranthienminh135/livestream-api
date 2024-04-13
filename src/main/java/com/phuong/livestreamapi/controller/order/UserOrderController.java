package com.phuong.livestreamapi.controller.order;

import com.phuong.livestreamapi.dto.OrderDto;
import com.phuong.livestreamapi.model.ProductOrder;
import com.phuong.livestreamapi.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("user/order")
public class UserOrderController {

    @Autowired
    private IOrderService orderService;

    @PostMapping("")
    public ResponseEntity<?> addProductToCart(@RequestBody OrderDto orderDto, Principal principal) {
        this.orderService.addToCart(orderDto, principal.getName());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("show")
    public ResponseEntity<?> showCart(Principal principal) {
        List<ProductOrder> productOrders = this.orderService.getOrdersByUsername(principal.getName());
        return new ResponseEntity<>(productOrders, HttpStatus.OK);
    }
}
