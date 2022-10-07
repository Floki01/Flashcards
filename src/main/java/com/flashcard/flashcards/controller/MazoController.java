package com.flashcard.flashcards.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fasterxml.jackson.annotation.JsonCreator.Mode;
import com.flashcard.flashcards.interfaceService.IMazoService;
import com.flashcard.flashcards.model.Mazo;
import com.flashcard.flashcards.service.MazoService;

import org.springframework.web.bind.annotation.RequestParam;



@Controller
@RequestMapping
public class MazoController {
    
    @Autowired
    private MazoService service;

    @GetMapping("/index")
    public String listar(Model model){
        List<Mazo> mazos = service.listar();
        mazos.add(new Mazo("Hola","aqui")); //ejemplos
        mazos.add(new Mazo("soy","quien"));
        mazos.add(new Mazo("Matias Arias","quien"));
        model.addAttribute("mazos", mazos);
        return "index";
    }

    @GetMapping(value="/crear")
    public String crear(Model model) {
        model.addAttribute("mazo",new Mazo());
        return "crear";
    }

    @RequestMapping(value="/guardar", method = RequestMethod.POST)
    public String guardar(@Valid Mazo mazo, Model model){
        service.guardar(mazo);
        return "redirect:/index";
    }
    
}
