package com.example.mapper;

import com.example.dto.ToyDto;
import com.example.model.Toy;
import org.springframework.stereotype.Component;

@Component
public class ToyMapper {


    public ToyDto mapToyDto(Toy toy){
        ToyDto toyDto = new ToyDto();
        toyDto.setId(toy.getId());
        toyDto.setNume(toy.getNume());
        toyDto.setProducator(toy.getProducator());
        toyDto.setVarsta(toy.getVarsta());
        toyDto.setPret(toy.getPret());
        toyDto.setCantitate(toy.getCantitate());
        return toyDto;
    }

    public Toy mapToy(ToyDto toyDto){
        Toy toy = new Toy();
        toy.setId(toyDto.getId());
        toy.setNume(toyDto.getNume());
        toy.setProducator(toyDto.getProducator());
        toy.setVarsta(toyDto.getVarsta());
        toy.setPret(toyDto.getPret());
        toy.setCantitate(toyDto.getCantitate());
        return toy;
    }
}
