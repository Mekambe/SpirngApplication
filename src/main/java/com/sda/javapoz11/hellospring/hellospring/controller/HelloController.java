package com.sda.javapoz11.hellospring.hellospring.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

    @GetMapping("/hello")
    public ModelAndView hello (){
        ModelAndView modelAndView = new ModelAndView("hello.html"); //szuka zniacznika w pliku html
        modelAndView.addObject("message", "Ala ma kota");
        return modelAndView;
    }
}
