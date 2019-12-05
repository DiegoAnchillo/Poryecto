package com.webencyclop.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="order_table")
public class Order{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private int id;

    @NotNull(message="Order table is compulsory")
    @Column(name = "order_table")
    private int table;

    @NotNull(message="Order user is compulsory")
    @Column(name="order_user")
    private String user;
    
    @NotNull(message="Order food is compulsory")
    @Column(name="order_food")
    private String food;

    @NotNull(message="Order drink is compulsory")
    @Column(name="order_drink")
    private String drink;

    @OneToMany
    @JoinTable(name = "order_table", JoinColumns=@JoinColumn(name="auth_user_id"),inverserJoinColumns=@JoinColumn(referencedColumnName = "food_id"))
    private Set<Food>
    
}