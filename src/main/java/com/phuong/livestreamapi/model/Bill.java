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

    private Date orderDate;

    @OneToMany(mappedBy = "bill")
    private List<ProductOrder> productOrders;
}
