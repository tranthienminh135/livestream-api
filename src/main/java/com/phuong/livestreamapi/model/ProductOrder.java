package com.phuong.livestreamapi.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class ProductOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer quality;

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
