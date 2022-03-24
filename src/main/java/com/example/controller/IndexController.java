package com.example.controller;

import com.example.dto.CategoryDto;
import com.example.dto.ToyDto;
import com.example.service.CategoryService;
import com.example.service.ToyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import javax.annotation.PostConstruct;


@Controller
public class IndexController {

    @Autowired
    ToyService toyService;
    @Autowired
    CategoryService categoryService;

    @GetMapping(value = "/index")
    public String getIndex() {
        return "index";
    }


    @PostConstruct
    private void loadtoys() {
    }

    @GetMapping("/toys")
    public String showtoys(Model model) {
        model.addAttribute("toys", toyService.getToysList());
        return "toys";
    }


    @GetMapping("/categories")
    public String showcategories(Model model) {
        model.addAttribute("categories", categoryService.getCategoriesList());
        return "categories";
    }

    @PostMapping("/categories/addCategory")
    public String addNewCategory(CategoryDto categoryDto){
        categoryService.saveCategory(categoryDto);
        return "redirect:/categories";
    }

    @PostMapping("/categories/editCategory")
    public String editCategory(CategoryDto categoryDto){
        categoryService.saveCategory(categoryDto);
        return "redirect:/categories";
    }

    @PostMapping("/toys/addToy")
    public String addNewCategory(ToyDto toyDto){
        toyService.saveToys(toyDto);
        return "redirect:/toys";
    }

    @PostMapping("/toys/editToy")
    public String editToy(ToyDto toyDto){
        toyService.saveToys(toyDto);
        return "redirect:/toys";
    }


    @GetMapping("/gallery")
    public String showGallery(){
        return "gallery";
    }

    @GetMapping(value = "/contact")
    public String showContact() {
        return "contact";
    }

    @RequestMapping(path="/categories/deleteCategory/{id}")
    public String deleteCategoryById(@PathVariable("id") int id)
    {
        categoryService.deleteCategoryById(id);
        return "redirect:/categories";
    }

    @RequestMapping(path="/deleteToy/{id}")
    public String deleteToyById(@PathVariable("id") int id)
    {
        toyService.deleteToysById(id);
        return "redirect:/toys";
    }



}
