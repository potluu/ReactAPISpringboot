package com.ecommerce.project.laptop.entitty;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "order_details")
@Builder
public class OrderDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@OneToOne(mappedBy = "orderDetails")
	private Order order;

	@Column(name = "amount")
	private int amount;

	@Column(name = "total")
	private float total;

	@ManyToMany()
	@JoinTable(name = "orderdetails_product",joinColumns = @JoinColumn(name = "orderd_id"),
	inverseJoinColumns = @JoinColumn(name = "product_id"))
	private Set<Product> products;


}
