package com.phuong.livestreamapi.dto;

import com.phuong.livestreamapi.model.EmployeePosition;
import com.phuong.livestreamapi.model.EmployeeStatus;
import lombok.Data;

@Data
public class EmployeeDto {
    private Integer id;

    private String name;

    private String email;

    private String avatar;

    private String title;

    private String description;

    private EmployeePosition employeePosition;

    private EmployeeStatus employeeStatus;
}
