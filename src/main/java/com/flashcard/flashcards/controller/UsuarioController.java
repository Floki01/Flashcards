package com.flashcard.flashcards.controller;


import com.flashcard.flashcards.model.Usuario;
import com.flashcard.flashcards.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import javax.validation.Valid;

@Controller
@SessionAttributes("usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/login")
    public String iniciarSesion() {
        return "login";
    }

    @GetMapping("/registro")
    public String registro(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "registro";
    }

    @PostMapping("/registro")
    public String guardarUsuario(@Valid Usuario usuario, SessionStatus status) {

        //Pasar nueva contraseña cifrada
        usuario.setClave(usuarioService.cifrarClave(usuario.getClave()));

        usuario.setRoles("ROLE_USER");

        usuarioService.guardar(usuario);
        status.setComplete();
        return "redirect:/mazo";
    }
 /** Funcion del rol admin (tratar de implementar)
    @GetMapping("/info-usuario")
    public String userInfo() {
        return "info-usuario";
    }*/

}
