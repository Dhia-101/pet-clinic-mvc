package com.dhia.springpetclinic.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller()
public class ErrorPageController {

    @RequestMapping({"/errorTest"})
    public String index() {
        return "notImplemented";
    }

}
