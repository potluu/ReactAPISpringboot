package com.ecommerce.project.laptop.entitty;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "banner")
@Builder
public class Banner {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name="name")
	private String name;

	@JoinColumn(name = "product_id")
	private String link_images;

	@Column(name ="title_price")
	private String title_price;

	@Column (name = "theme_title")
	private String theme_title;

	@Column(name = "slogan")
	private  String slogan;


	
	

}
