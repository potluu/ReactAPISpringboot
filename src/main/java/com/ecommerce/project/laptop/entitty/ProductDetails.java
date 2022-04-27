package com.ecommerce.project.laptop.entitty;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.ecommerce.project.laptop.dto.ProductDetailsDto;
import com.ecommerce.project.laptop.dto.ProductDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "product_details")
@Builder
public class ProductDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@OneToOne(mappedBy = "details")
	private Product product;
	@Column(name = "trademark")
	private String trademark;
	@Column(name = "guarantee")
	private double guarantee;
	@Column(name = "color")
	private String color;
	@Column(name = "seriesLaptop")
	private String seriesLaptop;
	@Column(name = "part_number")

	private String part_number;
	@Column(name = "CPUgeneration")

	private String CPUgeneration;
	@Column(name = "CPU")

	private String CPU;
	@Column(name = "graphics_chip")

	private String graphics_chip;
	@Column(name = "RAM")

	private String RAM;
	@Column(name = "screen")

	private String screen;
	@Column(name = "storage")

	private String storage;
	@Column(name = "maximum_number_of_storage_port")

	private String maximum_number_of_storage_port;
	@Column(name = "supportedM_2slot_type")

	private String supportedM_2slot_type;
	@Column(name = "output_port")

	private String output_port;
	@Column(name = "connector")

	private String connector;
	@Column(name = "wireless_Connectivity")

	private String wireless_Connectivity;
	@Column(name = "keyboard")

	private String keyboard;
	@Column(name = "operating_system")

	private String operating_system;
	@Column(name = "size")

	private String size;
	@Column(name = "weight")
	private double weight;
	@Column(name = "Pin")

	private String pin;
	@Column(name = "security")

	private String security;
	@Column(name = "LED_light_on_machine")

	private String LED_light_on_machine;
	@Column (name = "included")
	private String included;

	public ProductDetails(ProductDetailsDto productDetailsDto) {
		this.id = productDetailsDto.getId();
		this.trademark = productDetailsDto.getTrademark();
		this.guarantee = productDetailsDto.getGuarantee();
		this.color = productDetailsDto.getColor();
		this.seriesLaptop = productDetailsDto.getSeriesLaptop();
		this.part_number = productDetailsDto.getPart_number();
		this.CPUgeneration = productDetailsDto.getCPUgeneration();
		this.CPU = productDetailsDto.getCPU();
		this.graphics_chip = productDetailsDto.getGraphics_chip();
		this.RAM = productDetailsDto.getRAM();
		this.screen = productDetailsDto.getScreen();
		this.storage = productDetailsDto.getStorage();
		this.maximum_number_of_storage_port = productDetailsDto.getMaximum_number_of_storage_port();
		this.supportedM_2slot_type = productDetailsDto.getSupportedM_2slot_type();
		this.output_port = productDetailsDto.getOutput_port();
		this.connector = productDetailsDto.getConnector();
		this.wireless_Connectivity = productDetailsDto.getWireless_Connectivity();
		this.keyboard = productDetailsDto.getKeyboard();
		this.operating_system = productDetailsDto.getOperating_system();
		this.size = productDetailsDto.getSize();
		this.weight = productDetailsDto.getWeight();
		this.pin = productDetailsDto.getPin();
		this.security = productDetailsDto.getSecurity();
		this.LED_light_on_machine = productDetailsDto.getLED_light_on_machine();
		this.included = productDetailsDto.getIncluded();
	}
}
