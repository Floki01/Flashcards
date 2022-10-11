package com.flashcard.flashcards.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.flashcard.flashcards.model.Mazo;
import com.flashcard.flashcards.repository.MazoRepository;

@Service
public class MazoService{

    @Autowired
    private MazoRepository mazoRepository;

    public List<Mazo> listAll(){
        return mazoRepository.findAll();
    }

    public void save(Mazo mazo){
        mazoRepository.save(mazo);
    }

    public void delete(Long id){
        mazoRepository.deleteById(id);
    }

    public Mazo get(Long id){
        return mazoRepository.findById(id).get();
    }
    
}
