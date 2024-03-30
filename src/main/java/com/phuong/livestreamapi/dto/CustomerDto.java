package com.phuong.livestreamapi.dto;

import com.phuong.livestreamapi.model.CustomerPosition;
import com.phuong.livestreamapi.model.CustomerStatus;
import lombok.Data;

@Data
public class CustomerDto {
    private Integer id;

    private String name;

    private String email;

    private String avatar;

    private String title;

    private String description;

    private CustomerPosition customerPosition;

    private CustomerStatus customerStatus;
}