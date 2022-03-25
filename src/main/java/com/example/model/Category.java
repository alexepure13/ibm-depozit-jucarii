package com.example.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Data

@Entity
@Table(name = "t_categories")

public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "tipjucarii")
    private String typeOfToy;
    @Column(name="cantitate")
    public int quantity;

    public Category() {
    }


    public Category(int id, String typeOfToy, int quantity) {
        this.id = id;
        this.typeOfToy = typeOfToy;
        this.quantity = quantity;
    }
}
