package com.felinos.microservice.entities;


import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

@Table(name = "orders")
@Entity
public class Order {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long order_id;
    private int quantity;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "users_id")
    @JsonManagedReference
    private User users;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "items_name")
    private Item items;

    public Order(Long order_id, int quantity, User users, Item items) {
        this.order_id = order_id;
        this.quantity = quantity;
        this.users = users;
        this.items = items;
    }
    public Order(){

    }

    @Override
    public String toString() {
        return "Order{" +
                "order_id=" + order_id +
                ", quantity=" + quantity +
                ", users=" + users +
                ", items=" + items +
                '}';
    }

    public Long getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Long order_id) {
        this.order_id = order_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public User getUsers() {
        return users;
    }

    public void setUsers(User users) {
        this.users = users;
    }

    public Item getItems() {
        return items;
    }

    public void setItems(Item items) {
        this.items = items;
    }
}
