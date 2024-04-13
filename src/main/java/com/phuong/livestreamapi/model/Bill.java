package com.phuong.livestreamapi.model;


import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;
import java.util.List;

@Entity
@Data
public class Bill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String code;

    private Date orderDate;

    private String messageToSeller;

    private Double totalPrice;

    private String currentAddress;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private PaymentStatus paymentStatus;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private OrderStatus orderStatus;

//    @OneToMany(mappedBy = "bill")
//    private List<ProductOrder> productOrders;
}
