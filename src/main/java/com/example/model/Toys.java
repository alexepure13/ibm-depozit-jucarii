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

public class Toys {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String nume;
    @Column
    private String producator;
    @Column
    private String varsta;
    @Column
    public double pret;
    @Column
    public int cantitate;

    public Toys() {
    }

    public Toys(int id, String nume, String producator, String varsta, double pret, int cantitate){
        this.id=id;
        this.nume = nume;
        this.producator = producator;
        this.varsta = varsta;
        this.pret = pret;
        this.cantitate = cantitate;
    }
}
