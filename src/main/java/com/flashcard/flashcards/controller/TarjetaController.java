package com.flashcard.flashcards.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.flashcard.flashcards.model.Mazo;
import com.flashcard.flashcards.model.Tarjeta;
import com.flashcard.flashcards.service.MazoService;
import com.flashcard.flashcards.service.TarjetaService;

@Controller
@RequestMapping("/")
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
        model.addAttribute("mazo",mazo);
        model.addAttribute("tarjeta",new Tarjeta());
        return "crearTarjeta";
    }

    @RequestMapping(value ="/guardarTarjeta",method = RequestMethod.POST)
    public String guardar(@ModelAttribute("tarjeta") Tarjeta tarjeta){
        tarjetaService.save(tarjeta);
        return "redirect:/mazos";
    }

    @GetMapping(value = "/editar")
    public String editarTarjeta(Model model,@RequestParam(value = "tarjeta", required = false) Long tarjetaId,
        @RequestParam(value = "mazo", required = false) Long mazoId){

        Mazo mazo = mazoService.get(mazoId);
        Tarjeta tarjeta = tarjetaService.get(tarjetaId);
        model.addAttribute("mazo",mazo);
        model.addAttribute("tarjeta",tarjeta);
        return "editarTarjeta";
        
    }

    @DeleteMapping("/eliminar/{id}")
    public String eliminar( @PathVariable(name = "id") Long id){
        Tarjeta tarjeta = tarjetaService.get(id);
        tarjetaService.delete(tarjeta);
        return "redirect:/mazos";
    }
    
}
