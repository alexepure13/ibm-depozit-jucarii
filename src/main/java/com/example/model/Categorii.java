package com.example.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Setter
@Getter
@Data
public class Categorii {
    private int id;
    private String tipJucarii;
    public int cantitate;

    public Categorii() {
    }

    public Categorii(int id, String tipJucarii, int cantitate) {
        this.id = id;
        this.tipJucarii = tipJucarii;
        this.cantitate = cantitate;
    }
}
