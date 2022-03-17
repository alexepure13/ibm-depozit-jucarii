package com.example.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class Jucarii {
    private int id;
    private String nume;
    private String producator;
    private String varsta;
    public double pret;
    public int cantitate;

    public Jucarii() {
    }

    public Jucarii(int id, String nume, String producator, String varsta, double pret, int cantitate){
        this.id=id;
        this.nume = nume;
        this.producator = producator;
        this.varsta = varsta;
        this.pret = pret;
        this.cantitate = cantitate;
    }


}
