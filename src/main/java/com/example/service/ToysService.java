package com.example.service;

import com.example.model.Categories;
import com.example.model.Toys;
import com.example.repository.ToysRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ToysService {

    @Autowired
    ToysRepository toysRepository;

    public List<Toys> getToysList(){
        return toysRepository.findAll();
    }

    public Toys getToyById(int id) throws Exception {
        Optional<Toys> toy = toysRepository.findById(id);

        if(toy.isPresent())
            return toy.get();
        else{
            throw  new Exception("Exceptie");
        }
    }

    public void saveToys(Toys toy){
        toysRepository.save(toy);
    }

    public void deleteToys(Toys toy){
        toysRepository.delete(toy);
    }
    public void deleteToysById(int id){
        toysRepository.deleteById(id);
    }


}
