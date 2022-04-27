package com.ecommerce.project.laptop.entitty;

import java.util.Date;

import javax.persistence.*;

import com.ecommerce.project.laptop.common.EStatus;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "orders")
@Builder
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "sku_order")
	private String sku_order;

	@Column(name = "note")
	private String note;

	@Enumerated(EnumType.STRING)
	@Column(name = "status")
	private EStatus status;

	@Column(name = "created_date")
	@Temporal(TemporalType.DATE)
	private Date createdDate;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "administrator_id")
	private Administrator administrator;


	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "transpost_id")
	private Transpost transpost;

	@ManyToOne(cascade={CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE})
	@JoinColumn(name = "user_id")
	private User user;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "orderd_id")
	private OrderDetails orderDetails; ;


}
