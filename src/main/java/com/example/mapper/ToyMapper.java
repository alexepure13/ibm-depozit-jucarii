package com.example.mapper;

import com.example.dto.ToyDto;
import com.example.model.Toy;
import org.springframework.stereotype.Component;

@Component
public class ToyMapper {


    public ToyDto mapToyDto(Toy toy){
        ToyDto toyDto = new ToyDto();
        toyDto.setId(toy.getId());
        toyDto.setName(toy.getName());
        toyDto.setManufacturer(toy.getManufacturer());
        toyDto.setAge(toy.getAge());
        toyDto.setPrice(toy.getPrice());
        toyDto.setQuantity(toy.getQuantity());
        return toyDto;
    }

    public Toy mapToy(ToyDto toyDto){
        Toy toy = new Toy();
        toy.setId(toyDto.getId());
        toy.setName(toyDto.getName());
        toy.setManufacturer(toyDto.getManufacturer());
        toy.setAge(toyDto.getAge());
        toy.setPrice(toyDto.getPrice());
        toy.setQuantity(toyDto.getQuantity());
        return toy;
    }
}
