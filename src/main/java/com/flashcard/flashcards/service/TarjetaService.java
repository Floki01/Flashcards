package com.flashcard.flashcards.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flashcard.flashcards.model.Tarjeta;
import com.flashcard.flashcards.repository.TarjetaRepository;

@Service
public class TarjetaService{

    @Autowired()
    private TarjetaRepository tarjetaRepository;

    public void save(Tarjeta tarjeta){
        tarjetaRepository.save(tarjeta);
    }

    public Tarjeta get(Long id){
        return tarjetaRepository.findById(id).get();
    }

    public void delete(Tarjeta tarjeta){
        tarjetaRepository.delete(tarjeta);;
    }
}
