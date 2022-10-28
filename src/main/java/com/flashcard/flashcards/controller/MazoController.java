package com.flashcard.flashcards.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fasterxml.jackson.annotation.JsonCreator.Mode;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.flashcard.flashcards.model.Mazo;
import com.flashcard.flashcards.model.Tarjeta;
import com.flashcard.flashcards.service.MazoService;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping
public class MazoController {
    
    @Autowired
    private MazoService service;

    @RequestMapping("/mazo")
    public String listar(Model model){
        List<Mazo> mazos = service.listAll();
        model.addAttribute("mazos", mazos);
        return "mazo";
    }

    @GetMapping("/crear")
    public String crear(Model model) {
        model.addAttribute("mazo",new Mazo());
        return "crearMazo";
    }

    @RequestMapping(value ="/guardar",method = RequestMethod.POST)
    public String guardar(@ModelAttribute("mazo") Mazo mazo){
        service.save(mazo);
        return "redirect:/mazo";
    }

    @RequestMapping("/editar/{id}")
    public ModelAndView editar(@PathVariable(name = "id") long id,Model model){
        ModelAndView modelAndView = new ModelAndView("editarMazo");
        Mazo mazo = service.get(id);
        modelAndView.addObject("mazo",mazo);
        return modelAndView;
    }

    @GetMapping(value = "/eliminar/{id}")
    public String eliminar(Model model, @PathVariable(name = "id") Long id){
        service.delete(id);
        return "redirect:/mazo";
    }
    
}
