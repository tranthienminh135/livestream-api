package com.phuong.livestreamapi.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String email;

    private String avatar;

    private String title;

    private String description;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id", name = "position_id")
    private EmployeePosition employeePosition;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id", name = "status_id")
    private EmployeeStatus employeeStatus;
}
