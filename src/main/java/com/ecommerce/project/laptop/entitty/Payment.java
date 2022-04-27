package com.ecommerce.project.laptop.entitty;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "payments")
@Builder
public class Payment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "name_payment")
	private String name;
	@Column (name = "transaction")
	private String transaction;

	@Column(name = "paymentDate")
	private Date date;

	@OneToOne(mappedBy = "payment")
	private Transpost transpost;

	@OneToOne(mappedBy = "payment")
	private Bill bill;

}
