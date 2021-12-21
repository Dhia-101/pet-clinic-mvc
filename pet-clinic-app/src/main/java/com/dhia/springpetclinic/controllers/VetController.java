package com.dhia.springpetclinic.controllers;

import com.dhia.springpetclinic.model.Vet;
import com.dhia.springpetclinic.services.VetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Set;

@Controller
public class VetController {

    private final VetService vetService;

    public VetController(VetService vetService) {
        this.vetService = vetService;
    }

    @RequestMapping({"/vets", "/vets/", "/vets/index"})
    public String index(Model model) {
        model.addAttribute("vets", vetService.findAll());
        return "vets/index";
    }

    @RequestMapping("/api/vets")
    public @ResponseBody Set<Vet> getVetJson() {
        return vetService.findAll();
    }

}
