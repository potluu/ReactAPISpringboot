package com.ecommerce.project.laptop.entitty;

import java.util.Date;

import javax.persistence.*;


import com.ecommerce.project.laptop.common.ETranspostStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "transpost")
@Builder
public class Transpost {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	@Column(name = "id")
	private long id;
	@Column(name = "sku_mvc")
	private String skuMVC;

	@Enumerated(EnumType.STRING)
	@Column(length = 20)
	private ETranspostStatus status;

	@Column(name = "name_shipper")
	private String nameShipper;

	@JsonFormat(pattern="dd/MM/yyyy")
	@Column(name = "delivered_date")
	private Date deliveredDate;

	@Column(name = "checks")
	private boolean checks;

	@Column(name = "recever")
	private String recever;
	@Column(name = "email")

	private String email;
	@Column(name = "phone")

	private String phone;
	@Column(name = "address")
	private String address;

	@Column (name = "note")
	private String note;
	@OneToOne()
	@JoinColumn(name = "payment_id")
	private Payment payment;

}