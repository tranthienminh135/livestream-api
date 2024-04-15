package com.phuong.livestreamapi.dto;

import lombok.Data;
import org.springframework.data.domain.Sort;

@Data
public class RequestDto {
    private Integer page;

    private Integer size;

    private Sort.Direction sortDirection;

    private String sortBy;

    private String name;

    private Integer categoryId;

    private Double priceFrom;

    private Double priceTo;

}
