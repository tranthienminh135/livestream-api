package com.phuong.livestreamapi.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;

@Entity
@Data
public class ProductOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer quantity;

    private Date orderDate;

    private Double currentPrice;

    private String currentName;

    @Lob
    @Column(columnDefinition = "LONGBLOB")
    private byte[] currentCover;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private Product product;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private AppUser appUser;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private Bill bill;
}
