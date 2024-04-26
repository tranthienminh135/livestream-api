package com.phuong.livestreamapi.dto;

import lombok.Data;
import org.springframework.data.domain.Sort;

@Data
public class MessageDto {
    private Integer page;

    private Integer size;

    private Sort.Direction sortDirection;

    private String sortBy;

    private String toUser;
}
