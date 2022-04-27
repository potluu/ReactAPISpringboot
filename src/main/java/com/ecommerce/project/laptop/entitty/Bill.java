package com.ecommerce.project.laptop.entitty;

import java.util.Date;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "bills")
@Builder
public class Bill {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name = "code_bill")
	private String codeBill;

	@Column (name = "name_pay")
	private String namePay;
	@Column (name = "pay_date")
	private Date payDate;
	@Column(name = "total_price")
	private double totalPrice;

	@ManyToOne
	@JoinColumn(name = "user_id",nullable = false)
	private User user;

	@OneToOne
	@JoinColumn(name = "payment_id")
	private Payment payment;


}
