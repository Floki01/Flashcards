package com.flashcard.flashcards.interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.flashcard.flashcards.model.Mazo;

@Repository
public interface IMazo extends CrudRepository<Mazo,Integer>{
    
}
