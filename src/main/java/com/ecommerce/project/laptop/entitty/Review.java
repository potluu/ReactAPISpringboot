package com.ecommerce.project.laptop.entitty;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Builder;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "reviews")
@Builder
public class Review {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@Column(name = "confirm")

	private boolean confirm;
	@Column(name = "rating")
	private int rating;
	@Column(name = "title")

	private String title;
	@Column(name = "comment")
	private String comment;

	@Column(name = "time")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date time;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "product_id",nullable = false)
	private Product product;

	 @ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id",nullable = false)
	private User user;


}
