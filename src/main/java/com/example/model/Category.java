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
    private String tipJucarii;
    @Column
    public int cantitate;

    public Category() {
    }


    public Category(int id, String tipJucarii, int cantitate) {
        this.id = id;
        this.tipJucarii = tipJucarii;
        this.cantitate = cantitate;
    }
}
