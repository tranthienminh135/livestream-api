package com.phuong.livestreamapi.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String email;

    @Lob
    @Column(columnDefinition = "LONGBLOB")
    private byte[] avatar;

    private String title;

    private String description;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id", name = "position_id")
    private CustomerPosition customerPosition;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id", name = "status_id")
    private CustomerStatus customerStatus;
}
