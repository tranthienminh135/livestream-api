package com.phuong.livestreamapi.controller.bill;

import com.phuong.livestreamapi.model.PaymentStatus;
import com.phuong.livestreamapi.repository.IPaymentStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("user/payment-status")
public class UserPaymentStatusController {

    @Autowired
    private IPaymentStatusRepository paymentStatusRepository;

    @GetMapping("")
    public ResponseEntity<?> getAllPaymentStatus() {
        List<PaymentStatus> paymentStatuses = this.paymentStatusRepository.findAll();
        return new ResponseEntity<>(paymentStatuses,HttpStatus.OK);
    }
}
