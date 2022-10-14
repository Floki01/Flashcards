package com.flashcard.flashcards.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.flashcard.flashcards.model.Tarjeta;

@Repository
public interface TarjetaRepository extends JpaRepository<Tarjeta,Long>{
    
}
