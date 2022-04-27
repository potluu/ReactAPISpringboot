package com.ecommerce.project.laptop.entitty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "cartitem")
@Builder
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;


    @Column(name = "quantity")
    private int quantity;

    @Column(name = "discount")
    private int discount;

    @Column(name = "total_price")
    private float totalPrice;

    @ManyToOne()
    @JoinColumn(name = "cart_id",nullable = false)
    private ShoppingCart shoppingCart;

    @OneToOne(cascade = CascadeType.PERSIST,fetch =FetchType.LAZY )
    @JoinColumn(name = "product_id")
    private Product product;

}
