package com.webencyclop.demo.model;


//import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="order_table")
public class Order{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private int idorder;

    @NotNull(message="Order table is compulsory")
    @Column(name = "number_of_order")
    private int table;

    //@NotNull(message="Order user is compulsory")
    //@Column(name="auth_user_id")
    //private String user;
    
    @ManyToOne
    @JoinColumn(name = "auth_user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "food_id")
    private Food food;

    @ManyToOne
    @JoinColumn(name = "drink_id")
    private Drink drink;
    
    //ManyToMany
    //@JoinTable(name = "order_table", joinColumns = @JoinColumn(name="auth_user_id"),inverseJoinColumns=@JoinColumn(referencedColumnName = "food_id"))
    //private Set<Food> idfood;

    //@ManyToMany
    //@JoinTable(name = "order_table", joinColumns = @JoinColumn(name="auth_user_id"),inverseJoinColumns=@JoinColumn(referencedColumnName = "drink_id"))
    //private Set<Drink> iddrink;

    @NotNull(message="Order drink is compulsory")
    @Column(name="count_food")
    private int countfood;
    
    @NotNull(message="Order drink is compulsory")
    @Column(name="count_drink")
    private int countdrink;

    public int getIdorder() {
        return idorder;
    }

    public void setIdorder(int idorder) {
        this.idorder = idorder;
    }

    public int getTable() {
        return table;
    }

    public void setTable(int table) {
        this.table = table;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public int getCountfood() {
        return countfood;
    }

    public void setCountfood(int countfood) {
        this.countfood = countfood;
    }

    public int getCountdrink() {
        return countdrink;
    }

    public void setCountdrink(int countdrink) {
        this.countdrink = countdrink;
    }

    
}