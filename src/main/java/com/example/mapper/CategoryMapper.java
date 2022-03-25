package com.example.mapper;

import com.example.dto.CategoryDto;
import com.example.model.Category;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper {

    public CategoryDto mapCategoryDto(Category category){
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setId(category.getId());
        categoryDto.setTypeOfToy(category.getTypeOfToy());
        categoryDto.setQuantity(category.getQuantity());
        return categoryDto;
    }

    public Category mapCategory(CategoryDto categoryDto){
        Category category = new Category();
        category.setId(categoryDto.getId());
        category.setTypeOfToy(categoryDto.getTypeOfToy());
        category.setQuantity(categoryDto.getQuantity());
        return category;
    }
}
