package com.ecommerce.project.laptop.dto;

import com.ecommerce.project.laptop.entitty.ProductDetails;
import lombok.Data;


@Data
public class ProductDetailsDto {
    private Long id;
    private String trademark;
    private double guarantee;
    private String color;
    private String seriesLaptop;
    private String part_number;
    private String CPUgeneration;
    private String CPU;
    private String graphics_chip;
    private String RAM;
    private String screen;
    private String storage;
    private String maximum_number_of_storage_port;
    private String supportedM_2slot_type;
    private String output_port;
    private String connector;
    private String wireless_Connectivity;
    private String keyboard;
    private String operating_system;
    private String size;
    private double weight;
    private String pin;
    private String security;
    private String LED_light_on_machine;
    private String included;

    public ProductDetailsDto(ProductDetails productDetails) {
        this.id = productDetails.getId();
        this.trademark = productDetails.getTrademark();
        this.guarantee =  productDetails.getGuarantee();
        this.color =  productDetails.getColor();
        this.seriesLaptop =  productDetails.getSeriesLaptop();
        this.part_number =  productDetails.getPart_number();
        this.CPUgeneration =  productDetails.getCPUgeneration();
        this.CPU =  productDetails.getCPU();
        this.graphics_chip =  productDetails.getGraphics_chip();
        this.RAM =  productDetails.getRAM();
        this.screen =  productDetails.getScreen();
        this.storage =  productDetails.getStorage();
        this.maximum_number_of_storage_port =  productDetails.getMaximum_number_of_storage_port();
        this.supportedM_2slot_type =  productDetails.getSupportedM_2slot_type();
        this.output_port =  productDetails.getOutput_port();
        this.connector =  productDetails.getConnector();
        this.wireless_Connectivity =  productDetails.getWireless_Connectivity();
        this.keyboard =  productDetails.getKeyboard();
        this.operating_system =  productDetails.getOperating_system();
        this.size =  productDetails.getSize();
        this.weight =  productDetails.getWeight();
        this.pin =  productDetails.getPin();
        this.security =  productDetails.getSecurity();
        this.LED_light_on_machine =  productDetails.getLED_light_on_machine();
        this.included =  productDetails.getIncluded();
    }
}
