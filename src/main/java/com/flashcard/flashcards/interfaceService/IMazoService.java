package com.flashcard.flashcards.interfaceService;

import java.util.List;
import com.flashcard.flashcards.model.Mazo;

public interface IMazoService {
    public List<Mazo> listar();
    public int guardar(Mazo mazo);
    public void delete(int id);
}
