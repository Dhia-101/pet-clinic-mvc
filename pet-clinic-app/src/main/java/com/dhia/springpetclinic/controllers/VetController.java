package com.dhia.springpetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/vet")
public class VetController {

    @RequestMapping({"", "/", "index"})
    public String index() {
        return "vet/index";
    }

}
