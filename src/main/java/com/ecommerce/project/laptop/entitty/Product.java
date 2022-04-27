
package com.ecommerce.project.laptop.entitty;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

import lombok.Builder;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "products")
@Builder
public class Product{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "discount")
    private int discount;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "created_date")
    private Date createdDate;


    @NumberFormat(style = Style.CURRENCY)
    @Column(name = "price")
    private double price;

    @ManyToOne
    @JoinColumn(name = "brand_id")
    private Brand brand;

	@ManyToOne()
	@JoinColumn(name = "administrator_id")
	private Administrator administrator;

    @ManyToMany()
    @JoinTable(name = "product_category", joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private Set<Category> categories;


    @OneToOne(mappedBy = "product")
    private CartItem cartItem;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_details_id")
    private ProductDetails details;

	@ManyToMany(mappedBy = "products")
	private Set<OrderDetails> orderDetails;
	@OneToMany(mappedBy = "product")
	private Set<ProductImage> productImages;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "product")
    private List<Review> reviews;


}