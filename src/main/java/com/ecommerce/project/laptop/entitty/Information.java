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
@Table(name = "information")
@Builder
public  class Information {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "name")
	private String name;

	@Temporal(value = TemporalType.DATE)
	@Column(name = "created_date")
	private Date createdDate;

	@Column(name = "phone")
	private String phone;


	@Column(name = "dateBrithday")
	@Temporal(TemporalType.DATE)
	private Date dateBrithday;

	@Column(name = "sex")
	private String sex;

	@Column(name = "company")
	private String company;

	@Column(name = "address")
	private String address;

	@OneToOne
	@JoinColumn(name = "account_id")
	private Account account;

}
