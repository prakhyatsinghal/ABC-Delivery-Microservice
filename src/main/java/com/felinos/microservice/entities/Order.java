package com.felinos.microservice.entities;


import javax.persistence.*;

@Table(name = "orders")
@Entity
public class Order {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int user_id;
    private int quantity;
    private long order_id;
    private String items;

    public Order(Long order_id, int quantity, int user_id, String items) {
        this.order_id = order_id;
        this.quantity = quantity;
        this.user_id = user_id;
        this.items = items;
    }
    public Order(){

    }

    @Override
    public String toString() {
        return "Order{" +
                "order_id=" + order_id +
                ", quantity=" + quantity +
                ", user_id=" + user_id +
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

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getItems() {return items;}

    public void setItems(String items) {
        this.items = items;
    }
}
