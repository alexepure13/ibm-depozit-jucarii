package com.example.service;

import com.example.model.Toys;
import com.example.repository.ToysRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToysService {

    @Autowired
    ToysRepository toysRepository;

    public List<Toys> getToysList(){
        return toysRepository.findAll();
    }

    public void saveToys(Toys toy){
        toysRepository.save(toy);
    }

    public void deleteToys(Toys toy){
        toysRepository.delete(toy);
    }

}
