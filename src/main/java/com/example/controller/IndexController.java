package com.example.controller;

import com.example.model.Categories;
import com.example.model.Toys;
import com.example.service.CategoriesService;
import com.example.service.ToysService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


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

    @RequestMapping(path="/deleteCategory/{id}")
    public String deleteCategoryById(Model model, @PathVariable("id") int id)
    {
        categoriesService.deleteCategory(id);
        return "redirect:/categorii";
    }

    @RequestMapping(path="/deleteToy/{id}")
    public String deleteToyById(Model model, @PathVariable("id") int id)
    {
        toysService.deleteToysById(id);
        return "redirect:/jucarii";
    }

/*    @RequestMapping(path={"/editCategory", "/editCategory/{id}"})
    public String editCategoryById(Model model, @PathVariable("id") Optional<Integer> id) throws Exception {
        if(id.isPresent()){
            Categories category = categoriesService.getCategoryById(id.get());
            model.addAttribute("edtCategory", category);
            categoriesService.saveCategory(category);
        }
        else{
            model.addAttribute("edtCategory", new Categories());
        }
        return  "editCategorii";
    }*/

    @GetMapping("/editCategory/{id}")
    public ModelAndView showEditCategoryPage(@PathVariable(name = "id") int id) throws Exception {
        ModelAndView editCategoryView = new ModelAndView("editCategorii");
        Categories category = categoriesService.getCategoryById(id);
        editCategoryView.addObject("category", category);

        return editCategoryView;
    }

    @GetMapping("/editToy/{id}")
    public ModelAndView showEditToyPage(@PathVariable(name = "id") int id) throws Exception {
        ModelAndView editCategoryView = new ModelAndView("editJucarii");
        Toys toy = toysService.getToyById(id);
        editCategoryView.addObject("toy", toy);

        return editCategoryView;
    }




}
