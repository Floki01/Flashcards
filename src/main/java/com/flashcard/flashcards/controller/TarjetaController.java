package com.flashcard.flashcards.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class TarjetaController {
    
    @RequestMapping("/Tarjetas")
    public String listar(Model model) {
        return "misTarjetas";
    }
    
}
