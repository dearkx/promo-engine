package com.java.kundan.promotion.engine.app.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString;

@Data
@Entity
@Table(name = "PRODUCT")
@ToString
public class Product {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
 private Long id;
 private String name;
 private double price;
}
