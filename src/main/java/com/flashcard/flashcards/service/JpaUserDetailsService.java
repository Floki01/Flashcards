package com.flashcard.flashcards.service;

import com.flashcard.flashcards.model.UsuarioSecurity;
import com.flashcard.flashcards.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JpaUserDetailsService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    // Busca si el usuario está registrado
    @Override
    public UserDetails loadUserByUsername(String nombre) throws UsernameNotFoundException {
       return usuarioRepository
               .findByNombre(nombre)
               .map(UsuarioSecurity::new)
               .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado: " + nombre));
    }
}
