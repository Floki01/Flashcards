package com.flashcard.flashcards.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.flashcard.flashcards.model.Mazo;

@Repository
public interface IMazo extends JpaRepository<Mazo,Long>{
    
}
