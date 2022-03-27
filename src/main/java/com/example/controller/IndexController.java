package com.example.controller;

import com.example.dto.CategoryDto;
import com.example.dto.ToyDto;
import com.example.model.Category;
import com.example.model.Toy;
import com.example.service.CategoryService;
import com.example.service.ToyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


import javax.annotation.PostConstruct;
import java.util.List;


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
        model.addAttribute("categories", categoryService.getCategoriesList());
        return "toys";
    }

    @GetMapping("/categories")
    public String showcategories(Model model) {
        model.addAttribute("categories", categoryService.getCategoriesList());
        return "categories";
    }

    @PostMapping("/categories/addCategory")
    public String addNewCategory(@ModelAttribute CategoryDto categoryDto){
        categoryService.saveCategory(categoryDto);
        return "redirect:/categories";
    }

    @PostMapping("/categories/editCategory")
    public String editCategory(@ModelAttribute CategoryDto categoryDto){
        categoryService.saveCategory(categoryDto);
        return "redirect:/categories";
    }

/*
    @PostMapping("/toys/addToy")
    public String addNewToy(@ModelAttribute("toy") ToyDto toyDto, Model model){
        toyDto.setCategory(categoryService.getCategoriesList().get(toyDto.getCategory().getId()-1));
        toyService.saveToys(toyDto);
        return "redirect:/toys";
    }
*/

    @PostMapping("/toys/addToy")
    public String addNewToy(@ModelAttribute("toy") ToyDto toyDto, Model model){
        List<CategoryDto> listCategories = categoryService.getCategoriesList();
        model.addAttribute("toy", new ToyDto());
        model.addAttribute("listCategories", listCategories);
        toyService.saveToys(toyDto);
        return "redirect:/toys";
    }

    @GetMapping(value={"/addT"})
    public String adaugaJcuarii(final Model model) {
        model.addAttribute("toy", new Toy());
        return "employees/employees-add";
    }

    @PostMapping(value = {"/addT"})
    public String adaugaJcuarii(@ModelAttribute("toy") final ToyDto toyDto, final BindingResult error, final Model model) {

        if (error.hasErrors()) {
            System.err.println(error);
            return "redirect:/index";
        }
        final Toy toy = this.toyService.saveToys(toyDto);
        System.err.println(toy);
        return "toys";
    }




    @PostMapping("/toys/editToy")
    public String editToy(@ModelAttribute ToyDto toyDto){
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

    @GetMapping(value="/login")
    public String showLogin(){return "login";};

    @GetMapping(value="/register")
    public String showRegister(){return "register";};

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



    //Ultimate

    @GetMapping(value = "adaugaCategorii")
    public String showAdaugaCategorii(Model model) {
        model.addAttribute("category", new CategoryDto());
        return "adaugaCategorii";
    }

    @PostMapping("/addCategorie")
    public String addCategorie(@ModelAttribute CategoryDto categoryDto) {
        categoryService.saveCategory(categoryDto);
        return "redirect:/categories";
    }


    @GetMapping(value = "adaugaJucarii")
    public String showAdaugaJucarii(Model model) {
        List<CategoryDto> listCategories = categoryService.getCategoriesList();
        model.addAttribute("toy", new ToyDto());
        model.addAttribute("categories", listCategories);
        return "adaugaJucarii";
    }

    @PostMapping("addJucarie")
    public String addJucarie(@ModelAttribute ToyDto toyDto) {
        toyService.saveToys(toyDto);
        return "redirect:/toys";
    }

    @GetMapping("/editCategory/{id}")
    public ModelAndView showEditCategoryPage(@PathVariable(name = "id") int id) throws Exception {
        ModelAndView editCategoryView = new ModelAndView("editCategorii");
        CategoryDto categoryDto = categoryService.getCategoryById(id);
        editCategoryView.addObject("category", categoryDto);

        return editCategoryView;
    }

    @GetMapping("/editToy/{id}")
    public ModelAndView showEditToyPage(@PathVariable(name = "id") int id) throws Exception {
        ModelAndView editCategoryView = new ModelAndView("editJucarii");
        ToyDto toyDto = toyService.getToyById(id);
        editCategoryView.addObject("toy", toyDto);
        return editCategoryView;
    }

    @PostMapping("/addNewToy")
    public String showAddNewToy(ToyDto toyDto){
        toyService.saveToys(toyDto);
        return "redirect:/toys";
    }

}
