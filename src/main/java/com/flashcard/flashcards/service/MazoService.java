package com.flashcard.flashcards.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flashcard.flashcards.interfaceService.IMazoService;
import com.flashcard.flashcards.model.Mazo;
import com.flashcard.flashcards.interfaces.IMazo;

@Service
public class MazoService implements IMazoService {

    @Autowired
    private IMazo data;

    @Override
    public int guardar(Mazo mazo) {
        return 0;
    }

    @Override
    public void delete(int id) {
        
        
    }

    @Override
    public List<Mazo> listar() {
        return (List<Mazo>)data.findAll();
    }
    
}
