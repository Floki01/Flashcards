package com.flashcard.flashcards.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.flashcard.flashcards.model.Mazo;
import com.flashcard.flashcards.model.Tarjeta;
import com.flashcard.flashcards.service.MazoService;
import com.flashcard.flashcards.service.TarjetaService;

@Controller
@RequestMapping
public class TarjetaController {
    
    @Autowired
    private TarjetaService tarjetaService;
    
    @Autowired
    private MazoService mazoService;
    
    @GetMapping(value = "/tarjetas/{id}")
    public String listar(Model model, @PathVariable(name = "id") Long id){
        Mazo mazo = mazoService.get(id);
        model.addAttribute("tarjetas",mazo.getTarjetas());
        model.addAttribute("mazo",mazo);
        return "tarjetas";
    }


    @GetMapping(value = "/crearTarjeta/{id}")
    public String crearTarjeta(Model model, @PathVariable(name = "id") Long id){
        Mazo mazo = mazoService.get(id);
        model.addAttribute("tarjeta",new Tarjeta());
        model.addAttribute("mazo",mazo);
        return "crearTarjeta";
    }

    @RequestMapping(value ="/guardarTarjeta/{id}",method = RequestMethod.POST)
    public String guardar(@ModelAttribute("tarjeta") Tarjeta tarjeta, @PathVariable(name = "id") Long id){
        
        tarjetaService.save(tarjeta);
        
        return "redirect:/index";
    }




    
}
