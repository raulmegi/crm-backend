package org.ediae.tfm.crmapi.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Brand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;



}