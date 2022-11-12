package com.flashcard.flashcards.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InicioController {

    @GetMapping({"/"})
    public String inicio() {
        return "/index";
    }

    //para cuando inicia sesion lo lleve directo a mazos(html)
    @GetMapping({"/mazos"})
    public String inicioMazo() {
        return "/mazos";
    }

}
