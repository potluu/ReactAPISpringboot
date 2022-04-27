package com.ecommerce.project.laptop.entitty;

import java.util.Set;

import javax.persistence.*;


import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "categories")
@Builder
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "name")
	private String name;

	@ManyToMany(mappedBy = "categories")
	private Set<Product> products;

}
