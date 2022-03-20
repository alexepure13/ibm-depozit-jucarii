package com.example.controller;

import com.example.model.Categories;
import com.example.model.Toys;
import com.example.service.CategoriesService;
import com.example.service.ToysService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;


@Controller
public class IndexController {

    @Autowired
    ToysService toysService;
    @Autowired
    CategoriesService categoriesService;

    @GetMapping(value = "/index")
    public String getIndex() {
        return "index";
    }


    @PostConstruct
    private void loadJucarii() {


    }

    @GetMapping("/jucarii")
    public String showJucarii(Model model) {
        model.addAttribute("jucarii", toysService.getToysList());

        return "jucarii";
    }


    @GetMapping("/categorii")
    public String showCategorii(Model model) {
        model.addAttribute("categorii", categoriesService.getCategoriesList());

        return "categorii";
    }

    @GetMapping(value = "/contact")
    public String showContact() {
        return "contact";
    }


    @GetMapping(value = "adaugaCategorii")
    public String showAdaugaCategorii(Model model) {
        model.addAttribute("category", new Categories());
        return "adaugaCategorii";
    }

    @PostMapping("/addCategorie")
    public String addCategorie(@ModelAttribute Categories category) {
        categoriesService.saveCategory(category);

        return "redirect:/categorii";
    }


    @GetMapping(value = "adaugaJucarii")
    public String showAdaugaJucarii(Model model) {
        model.addAttribute("toy", new Toys());
        return "adaugaJucarii";
    }

    @PostMapping("addJucarie")
    public String addJucarie(@ModelAttribute Toys toy) {

        toysService.saveToys(toy);
        return "redirect:/jucarii";
    }




}
