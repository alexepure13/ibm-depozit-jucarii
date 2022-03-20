package com.example.service;

import com.example.model.Categories;
import com.example.repository.CategoriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriesService {

    @Autowired
    CategoriesRepository categoriesRepository;

    public List<Categories> getCategoriesList(){
        return categoriesRepository.findAll();
    }

    public void saveCategory(Categories category){
        categoriesRepository.save(category);
    }

    public void deleteCategory(Categories category){
        categoriesRepository.delete(category);
    }
}
