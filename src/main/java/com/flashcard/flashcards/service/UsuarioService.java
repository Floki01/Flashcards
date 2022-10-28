package com.flashcard.flashcards.service;

import com.flashcard.flashcards.model.Usuario;
import java.util.List;
import java.util.Optional;

public interface UsuarioService {

    public List<Usuario> listar();
    public Optional<Usuario> listarId(Long id);
    public void guardar(Usuario u);

    public String cifrarClave(String clave);

}
