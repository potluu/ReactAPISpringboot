package com.ecommerce.project.laptop.entitty;

import java.util.Date;
import java.util.Set;

import javax.persistence.*;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "notifys")
@Builder
public class Notify {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name = "content")
	private String content;
	@Column(name = "checks")
	private boolean checks;


	@Column(name = "time")
	private Date time;

	@Column(name = "keyword")
	private String keyword;

	@ManyToOne()
	@JoinColumn(name = "administrator_id")
	private Administrator administrator;

	@ManyToMany
	@JoinTable(name = "notify_user",joinColumns = @JoinColumn(name = "notify_id"),
	inverseJoinColumns = @JoinColumn(name = "user_id"))
	private Set<User> users;

}
