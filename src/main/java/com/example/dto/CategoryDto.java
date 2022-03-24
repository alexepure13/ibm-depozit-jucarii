package com.example.dto;

import javax.persistence.Column;

public class CategoryDto {

    private int id;
    private String tipJucarii;
    public int cantitate;

    public CategoryDto(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipJucarii() {
        return tipJucarii;
    }

    public void setTipJucarii(String tipJucarii) {
        this.tipJucarii = tipJucarii;
    }

    public int getCantitate() {
        return cantitate;
    }

    public void setCantitate(int cantitate) {
        this.cantitate = cantitate;
    }
}
