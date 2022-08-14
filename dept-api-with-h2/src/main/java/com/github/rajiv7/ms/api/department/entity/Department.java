package com.github.rajiv7.ms.api.department.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long recordId;

    @NotNull
    @Column(unique = true, length = 128)
    private String name;

    @NotNull
    @Column(unique = true)
    private String code;

    private String remarks;

    private String address;
}
