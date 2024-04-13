package com.phuong.livestreamapi.repository;

import com.phuong.livestreamapi.model.PaymentStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPaymentStatusRepository extends JpaRepository<PaymentStatus, Integer> {
}
