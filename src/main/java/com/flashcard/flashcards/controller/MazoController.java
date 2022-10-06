package com.flashcard.flashcards.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.flashcard.flashcards.interfaceService.IMazoService;
import com.flashcard.flashcards.model.Mazo;

@Controller
@RequestMapping
public class MazoController {
    
    @Autowired
    private IMazoService service;

    @GetMapping("/index")
    public String listar(Model model){
        List<Mazo> mazos = service.listar();
        model.addAttribute("mazos", mazos);
        return "index";
    }
}
