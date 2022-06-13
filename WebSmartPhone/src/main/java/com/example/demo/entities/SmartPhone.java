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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

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
@Table(name = "products")

public class SmartPhone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
	private Integer id;
    
    @Column(name = "name")
	private String name;
    
    @Column(name = "image")
	private String image;
    
    @Column(name = "price")
	private BigDecimal price;
    
    @Column(name = "quantity")
	private Integer quantity;
    
    @Column(name = "screen")
	private String screen;
    
    @Column(name = "chip")
	private String chip;
    
    @Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "create_date")
	private Date createDate;
    
    @ManyToOne
    @JoinColumn(name = "categoryid")
	private Category category;
    
    
    @OneToMany(mappedBy = "product")
    private List<OrderDetail> orderDetails;
    
}
