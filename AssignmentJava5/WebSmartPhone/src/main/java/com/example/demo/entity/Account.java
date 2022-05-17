package com.example.demo.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "accounts")
public class Account {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  
  @Column
  private String name;
  @Column
  private String email;
  @Column
  private String password;
  
  @Column(name = "phone_number")
  private String phoneNumber;
  @Column
  private String avatar;
  @Column
  private int gender;
  @Column
  private int role;
  
  @OneToMany(mappedBy = "account")
  private List<Order> orders;
	
}
