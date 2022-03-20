package com.example.service;

import com.example.model.Categories;
import com.example.repository.CategoriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriesService {

    @Autowired
    CategoriesRepository categoriesRepository;

    public List<Categories> getCategoriesList(){
        return categoriesRepository.findAll();
    }

    public Categories getCategoryById(int id) throws Exception {
        Optional<Categories> category = categoriesRepository.findById(id);

        if(category.isPresent())
        return category.get();
        else{
            throw  new Exception("Exceptie");
        }
    }

    public void saveCategory(Categories category){
        categoriesRepository.save(category);
    }

    public void deleteCategory(int id){
        categoriesRepository.deleteById(id);
    }


}
