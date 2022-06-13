package com.example.demo.entities;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "orders")
public class Order {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  
//  @Column
//  private Integer accountId;
  @Column(name = "create_date")
  private Date createDate;
  
  @Column
  private String address;
  
  @Column
  private BigDecimal total;
  
  @Column
  private Integer status;
  
  @ManyToOne
  @JoinColumn(name = "accountid")
  private Account account;
  
  @OneToMany(mappedBy = "order")
  private List<OrderDetail> orderDetails;
}
