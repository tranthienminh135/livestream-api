package com.phuong.livestreamapi.model;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;
import java.util.List;

@Entity
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private Double price;

    private String description;

    private Integer quantity;

    private Date createdDate;

    @Lob
    @Column(columnDefinition = "LONGBLOB")
    private byte[] cover;

    @OneToMany(mappedBy = "product")
    private List<ProductOrder> productOrders;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private Category category;
}
