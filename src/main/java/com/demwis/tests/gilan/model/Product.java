package com.demwis.tests.gilan.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@Data
@Entity
public class Product {

    @Id
    private String id;

    private String brand;

    private String name;

    private BigDecimal price;

    private Integer quantity;
}
