package com.example.dto;

import javax.persistence.Column;

public class CategoryDto {

    private int id;
    private String typeOfToy;
    public int quantity;

    public CategoryDto(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTypeOfToy() {
        return typeOfToy;
    }

    public void setTypeOfToy(String typeOfToy) {
        this.typeOfToy = typeOfToy;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
