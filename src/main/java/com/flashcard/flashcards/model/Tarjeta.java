package com.flashcard.flashcards.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.fasterxml.jackson.core.sym.Name;

@Entity
@Table(name = "tarjeta")
public class Tarjeta {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private long id;

    @Column(name = "fraseAnverso")
    private String fraseAnverso;

    @Column(name = "fraseReverso")
    private String fraseReverso;

    @Column(name = "descripcion")
    private String descripcion;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "mazo_id", nullable = false)
    private Mazo mazo;
    
    public Tarjeta(){
        
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFraseAnverso() {
        return fraseAnverso;
    }

    public void setFraseAnverso(String fraseAnverso) {
        this.fraseAnverso = fraseAnverso;
    }

    public String getFraseReverso() {
        return fraseReverso;
    }

    public void setFraseReverso(String fraseReverso) {
        this.fraseReverso = fraseReverso;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Tarjeta [id=" + id + ", fraseAnverso=" + fraseAnverso + ", fraseReverso=" + fraseReverso
                + ", descripcion=" + descripcion + ", mazo=" + mazo + "]";
    }

    public Mazo getMazo() {
        return mazo;
    }

    public void setMazo(Mazo mazo) {
        this.mazo = mazo;
    }
}
