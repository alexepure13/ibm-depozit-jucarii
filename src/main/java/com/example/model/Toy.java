package com.example.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Data

@Entity
@Table(name="t_toys")

public class Toy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column (name="nume")
    private String name;
    @Column (name="producator")
    private String manufacturer;
    @Column (name="varsta")
    private String age;
    @Column (name="pret")
    public double price;
    @Column (name="cantitate")
    public int quantity;

    public Toy() {
    }

    public Toy(int id, String name, String manufacturer, String age, double price, int quantity){
        this.id=id;
        this.name = name;
        this.manufacturer = manufacturer;
        this.age = age;
        this.price = price;
        this.quantity = quantity;
    }
}
