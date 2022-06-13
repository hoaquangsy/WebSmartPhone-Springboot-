package com.example.demo.entities;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartItem {
private Integer id;
private String name;
private Integer quantity;
private BigDecimal price;
private BigDecimal total;

}
