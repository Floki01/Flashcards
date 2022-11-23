package com.flashcard.flashcards.repository;

import com.flashcard.flashcards.model.Usuario;
import org.springframework.data.repository.CrudRepository;
import java.util.Optional;

public interface UsuarioRepository extends CrudRepository<Usuario, Long> {
    Optional<Usuario> findByNombre(String nombre);
}
