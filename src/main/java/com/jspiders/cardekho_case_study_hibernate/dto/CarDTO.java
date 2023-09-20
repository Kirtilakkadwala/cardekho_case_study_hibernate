package com.jspiders.cardekho_case_study_hibernate.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="car_info")
public class CarDTO {
    @Id
    @Column(name="car_id")
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int car_id;
    @Column(name="name")
    private String name;
    @Column(name="model")
    private String model;
    @Column(name="brand")
    private String brand;
    @Column(name="fuel_type")
    private String fuel_type;
    @Column(name="price")
    private double price;
}
