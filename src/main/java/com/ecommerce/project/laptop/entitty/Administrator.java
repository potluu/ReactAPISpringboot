package com.ecommerce.project.laptop.entitty;

import com.ecommerce.project.laptop.common.EPosition;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "administrator")
@Builder
public class Administrator  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne()
    @JoinColumn(name = "account_id")
    private Account account;

    @Enumerated(EnumType.STRING)
    @Column(name = "postition")
    private EPosition position;

    @OneToMany(mappedBy = "administrator")
    private Set<Order> orders;

    @OneToMany(mappedBy = "administrator")
    private Set<Product> products;

    @OneToMany(mappedBy = "administrator")
    private Set<Notify> notifies;


    public String getName(){
        return this.account.getInformation().getName();
    }
}
