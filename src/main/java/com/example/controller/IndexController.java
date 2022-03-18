package com.example.controller;

import com.example.model.Categorii;
import com.example.model.Jucarii;
import com.example.model.StatCategorii;
import com.example.model.StatJucarii;
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

    @GetMapping(value = "/index")
    public String getIndex() {
        return "index";
    }

    private List<Jucarii> listJucarii;
    private List<Categorii> listaCategorii;
    private List<StatCategorii> listaStatCategorii;
    private List<StatJucarii> listaStatJucarii;

    @PostConstruct
    private void loadJucarii() {
        Jucarii j1 = new Jucarii(1, "Mașină electrică", "Mașini Electrice", "4-10 ani", 500.0, 100);
        Jucarii j2 = new Jucarii(2, "Păpușă Barbie", "Noriel", "2-8 ani", 100.0, 50);
        Jucarii j3 = new Jucarii(3, "Căluț de jucărie", "Picodino", "1-7 ani", 80.0, 70);
        Jucarii j4 = new Jucarii(4, "Ursuleț de pluș Teddy", "Noriel", "1-7 ani", 200.0, 80);
        Jucarii j5 = new Jucarii(5, "Set bucătărie", "AlindaShop", "3-8 ani", 300.0, 40);
        Jucarii j6 = new Jucarii(6, "LEGO Classic", "LEGO", "5-12 ani", 150.0, 200);
        Jucarii j7 = new Jucarii(7, "Pistol cu apă", "AFYBABY", "3-5 ani", 70.0, 20);


        listJucarii = new ArrayList<>();

        listJucarii.add(j1);
        listJucarii.add(j2);
        listJucarii.add(j3);
        listJucarii.add(j4);
        listJucarii.add(j5);
        listJucarii.add(j6);
        listJucarii.add(j7);

        Categorii c1 = new Categorii(1, "Mașinuțe", 100);
        Categorii c2 = new Categorii(2, "Păpuși", 50);
        Categorii c3 = new Categorii(3, "Căluți", 70);
        Categorii c4 = new Categorii(4, "Ursuleț", 80);
        Categorii c5 = new Categorii(5, "Set-uri copii", 40);
        Categorii c6 = new Categorii(6, "LEGO", 200);
        Categorii c7 = new Categorii(7, "Jucării piscină", 40);

        listaCategorii = new ArrayList<>();

        listaCategorii.add(c1);
        listaCategorii.add(c2);
        listaCategorii.add(c3);
        listaCategorii.add(c4);
        listaCategorii.add(c5);
        listaCategorii.add(c6);
        listaCategorii.add(c7);

        listaStatCategorii = new ArrayList<>();

        int totalIntrariCategorii = listaCategorii.size();
        int totalCantitateCategorii = 0;

        for(int i = 0; i <listaCategorii.size();i++){
            totalCantitateCategorii +=listaCategorii.get(i).getCantitate();
        }

        listaStatCategorii.add(new StatCategorii(totalIntrariCategorii,totalCantitateCategorii));

        listaStatJucarii = new ArrayList<>();

        int totalIntrariJucarii = listaCategorii.size();
        int totalCantitateJucarii = 0;

        for(int i = 0; i<listJucarii.size();i++){
            totalCantitateJucarii += listJucarii.get(i).getCantitate();
        }

        listaStatJucarii.add(new StatJucarii(totalIntrariJucarii,totalCantitateJucarii));

    }

    @GetMapping("/jucarii")
    public String showJucarii(Model model) {
        model.addAttribute("jucarii", listJucarii);
        model.addAttribute("jucariiStat",listaStatJucarii);
        return "jucarii";
    }


    @GetMapping("/categorii")
    public String showCategorii(Model model) {
        model.addAttribute("categorii", listaCategorii);
        model.addAttribute("categoriiStat", listaStatCategorii);
        return "categorii";
    }

    @GetMapping(value = "/contact")
    public String showContact() {
        return "contact";
    }


    @GetMapping(value = "adaugaCategorii")
    public String showAdaugaCategorii(Model model) {
/*      Categorii categorii = new Categorii();
        categorii.setId(10);
        categorii.setTipJucarii("avioane");
        categorii.setCantitate(250);*/
        model.addAttribute("categorie", new Categorii());
        return "adaugaCategorii";
    }

    @PostMapping("/addCategorie")
    public String addCategorie(@ModelAttribute Categorii categorie) {
        listaCategorii.add(categorie);
        listaStatCategorii.remove(0);
        int totalIntrariCategorii = listaCategorii.size();
        int totalCantitateCategorii = 0;

        for(int i = 0; i <listaCategorii.size();i++){
            totalCantitateCategorii +=listaCategorii.get(i).getCantitate();
        }

        listaStatCategorii.add(new StatCategorii(totalIntrariCategorii,totalCantitateCategorii));

        return "redirect:/categorii";
    }


    @GetMapping(value = "adaugaJucarii")
    public String showAdaugaJucarii(Model model) {
        model.addAttribute("jucarie", new Jucarii());
        return "adaugaJucarii";
    }

    @PostMapping("addJucarie")
    public String addJucarie(@ModelAttribute Jucarii jucarie) {
        listJucarii.add(jucarie);
        listaStatJucarii.remove(0);
        int totalIntrariJucarii = listJucarii.size();
        int totalCantitateJucarii = 0;

        for(int i = 0; i<listJucarii.size();i++){
            totalCantitateJucarii += listJucarii.get(i).getCantitate();
        }

        listaStatJucarii.add(new StatJucarii(totalIntrariJucarii,totalCantitateJucarii));
        return "redirect:/jucarii";
    }




}
