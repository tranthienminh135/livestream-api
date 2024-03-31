package com.phuong.livestreamapi.dto;

import lombok.Data;

@Data
public class CustomerDto {
    private Integer id;

    private String name;

    private String email;

    private String avatar;

    private String title;

    private String description;

    private Integer positionId;

    private Integer statusId;
}
