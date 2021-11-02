package com.felinos.microservice.entities;

import javax.persistence.*;

@Table(name ="Item")
@Entity
public class Item {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private long item_id;
    private String name;
    private String description;


    public Item(long item_id, String name, String description) {
        this.item_id = item_id;
        this.name = name;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Item{" +
                "item_id=" + item_id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    public Item(){

    }

    public long getItem_id() {
        return item_id;
    }

    public void setItem_id(long item_id) {
        this.item_id = item_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
