package com.phuong.livestreamapi.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class ChatBox {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String cover;

}
