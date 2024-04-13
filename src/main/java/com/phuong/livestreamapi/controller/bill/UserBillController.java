package com.phuong.livestreamapi.controller.bill;

import com.phuong.livestreamapi.repository.IBillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user/bill")
public class UserBillController {

    @Autowired
    private IBillRepository billRepository;


}
