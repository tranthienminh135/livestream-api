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

    private String email;

    private Integer statusId;

    private Integer positionId;

}
