package com.dhia.springpetclinic.controllers;

import com.dhia.springpetclinic.services.VetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/vet")
public class VetController {

    private final VetService vetService;

    public VetController(VetService vetService) {
        this.vetService = vetService;
    }

    @RequestMapping({"", "/", "index"})
    public String index(Model model) {
        model.addAttribute("vets", vetService.findAll());
        return "vet/index";
    }

}
