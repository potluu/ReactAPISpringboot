package com.ecommerce.project.laptop.entitty;



import javax.persistence.*;

import lombok.Builder;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "carts")
@Builder
public class ShoppingCart {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToOne(mappedBy = "cart",cascade = CascadeType.ALL)
	private User user;

	@Column(name = "quantity")
	private int quantity;

    @NumberFormat(style = Style.CURRENCY)
	@Column(name = "total_price")
	private double totalPrice;

    @OneToMany(mappedBy = "shoppingCart")
	private Set<CartItem> cartItemSet;

	
}
